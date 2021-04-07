package br.com.projetoempresa.dao;

import br.com.projetoempresa.model.Pessoa;
import br.com.projetoempresa.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {

    private Connection conn;

    public PessoaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Integer cadastrar(Pessoa pessoa) {

        //Incializa as configuraçoes iniciais do metodo
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idPessoa = null;

        //Cria o comando SQL para o resgistro desses dados, retornando o id de Pessoa
        String sql = "insert into pessoa(nomepessoa, telefonepessoa) "
                + "values (?, ?) returning idpessoa;";

        try {
            
            //Registra dado por dado, substituindo as variaveis do comando SQL
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getTelefonePessoa());
            rs = stmt.executeQuery();

            if (rs.next()) {
                idPessoa = rs.getInt("idpessoa");
            }

        } catch (Exception err) {
            
            //Retorna o possivel erro
            System.out.println("Problemas ao cadastrar Pessoa! Erro: " + err.getMessage());
            err.printStackTrace();
            
        } finally {

            //Fecha a conexao
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
            
        }
        
        return idPessoa;    
    }
    
    public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "delete from Pessoa where idPessoa = ?";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            
            return true;
            
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir PessoaDAO! Erro " + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
            }
        }
    }
    
    public Boolean alterar(Pessoa pessoa) {
        PreparedStatement stmt = null;

        String sql = "update pessoa set nomepessoa = ?, "
                + "telefonepessoa = ? where idpessoa = ?;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getTelefonePessoa());
            stmt.setInt(3, pessoa.getIdPessoa());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar PessoaDAO! Erro" + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os perâmetros de conexão! Erro" + ex.getMessage());
            }
        }
    }
    
}
