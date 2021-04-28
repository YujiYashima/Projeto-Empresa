package br.com.projetoempresa.dao;

import br.com.projetoempresa.model.PessoaJuridica;
import br.com.projetoempresa.model.TipoPessoaJuridica;
import br.com.projetoempresa.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO implements GenericDAO {

    private Connection conn;

    //Prepara a conexao
    public PessoaJuridicaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    //Cadastrar
    public Boolean cadastrar(Object object) {

        //Cria a classe que vai obter os dados digitados pelo pessoaJuridica
        PessoaJuridica pessoaJuridica = (PessoaJuridica) object;
        PreparedStatement stmt = null;

        //Cria o comando SQL para o resgistro desses dados
        String sql = "Insert into pessoajuridica(cnpjpessoajuridica, iepessoajuridica, idtipopessoajuridica, idpessoa) "
                + "values (?, ?, ?, ?);";

        try {

            //Registra dado por dado, substituindo as variaveis do comando SQL
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoaJuridica.getCnpjPessoaJuridica());
            stmt.setString(2, pessoaJuridica.getIePessoaJuridica());
            stmt.setInt(3, pessoaJuridica.getTipoPessoaJuridica().getIdTipoPessoaJuridica());
            //Obtem o codigo da PessoaDAO, apos cadastrar nela o objeto pessoaJuridica 
            stmt.setInt(4, new PessoaDAO().cadastrar(pessoaJuridica));
            stmt.execute();

            return true;

        } catch (Exception err) {

            //Retorna o possivel erro
            System.out.println("Problemas ao cadastrar PessoaJuridicaDAO! Erro: " + err.getMessage());
            err.printStackTrace();

            return false;

        } finally {

            //Fecha a conexao
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        
        List<Object> pessoasJuridicas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select pj.*, p.*, t.* from PessoaJuridica pj, Pessoa p, TipoPessoaJuridica t "
                + "where pj.idPessoa = p.idPessoa "
                + "and t.idTipoPessoaJuridica = pj.idTipoPessoaJuridica "
                + "order by pj.idPessoaJuridica;";
        
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setIdPessoaJuridica(rs.getInt("idPessoaJuridica"));
                pessoaJuridica.setNomePessoa(rs.getString("nomePessoa"));
                pessoaJuridica.setTelefonePessoa(rs.getString("telefonePessoa"));
                pessoaJuridica.setCnpjPessoaJuridica(rs.getString("cnpjPessoaJuridica"));
                pessoaJuridica.setIePessoaJuridica(rs.getString("iePessoaJuridica"));
                pessoaJuridica.setTipoPessoaJuridica(new TipoPessoaJuridica(rs.getInt("idTipoPessoaJuridica"), rs.getString("nomeTipoPessoaJuridica")));
                pessoaJuridica.setIdPessoa(rs.getInt("idPessoa"));
                
                pessoasJuridicas.add(pessoaJuridica);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar PessoaJuridicaDAO! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return pessoasJuridicas;
    }

    @Override
    public Boolean excluir(int idOject) {
        
        PreparedStatement stmt = null;
        String sql = "delete from PessoaJuridica where idPessoa = ?; "
                + "commit; "
                + "delete from Pessoa where idPessoa = ?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.setInt(2, idOject);
            stmt.executeUpdate();
            
            return true;
            
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o PessoaJuridicaDAO! Erro" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PessoaJuridica pessoaJuridica = null;
        
        String sql = "select u.*, p.* from pessoaJuridica u, pessoa p where u.idpessoa = p.idpessoa and u.idpessoa = ?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setIdPessoaJuridica(rs.getInt("idPessoaJuridica"));
                pessoaJuridica.setNomePessoa(rs.getString("nomePessoa"));
                pessoaJuridica.setTelefonePessoa(rs.getString("telefonepessoa"));
                pessoaJuridica.setCnpjPessoaJuridica(rs.getString("cnpjPessoaJuridica"));
                pessoaJuridica.setIePessoaJuridica(rs.getString("iePessoaJuridica"));
                pessoaJuridica.setTipoPessoaJuridica(new TipoPessoaJuridica(rs.getInt("idTipoPessoaJuridica"), rs.getString("nomeTipoPessoaJuridica")));
                pessoaJuridica.setIdPessoa(rs.getInt("idPessoa"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar pessoaJuridicaDAO! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return pessoaJuridica;
    }

    @Override
    public Boolean alterar(Object object) {
        
        PessoaJuridica pessoaJuridica = (PessoaJuridica) object;
        PreparedStatement stmt = null;
        String sql = "update pessoajuridica set cnpjPessoaJuridica = ?, iePessoaJuridica = ?, idTipoPessoaJuridica = ? where idpessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoaJuridica.getCnpjPessoaJuridica());
            stmt.setString(2, pessoaJuridica.getIePessoaJuridica());
            stmt.setInt(3, pessoaJuridica.getTipoPessoaJuridica().getIdTipoPessoaJuridica());
            stmt.setInt(4, pessoaJuridica.getIdPessoa());
            if (new PessoaDAO().alterar(pessoaJuridica)) {
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Problemas ao alterar pessoaJuridica! Erro: "
                    + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: "
                        + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
