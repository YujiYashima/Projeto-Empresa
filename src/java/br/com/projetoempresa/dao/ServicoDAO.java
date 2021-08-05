package br.com.projetoempresa.dao;

import br.com.projetoempresa.model.Servico;
import br.com.projetoempresa.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yuji adm
 */

public class ServicoDAO {
    
    private Connection conn;
    
    public ServicoDAO() {
        try {
            this.conn = ConnectionFactory.getConnection();            
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar com o Banco de Dados! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public List<Object> listar() {
        
        List<Object> servicos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT s.* FROM servico s ORDER BY s.idservico;";
        
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setIdServico(rs.getInt("idServico"));
                servico.setNomeServico(rs.getString("nomeServico"));
                servico.setValorServico(rs.getDouble("valorServico"));
                servico.setDescricaoServico(rs.getString("descricaoServico"));
                servicos.add(servico);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar ServiçoDAO! Erro: " + ex.getMessage());
            ex.printStackTrace();            
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return servicos;
    }
    
}
