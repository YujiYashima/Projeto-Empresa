/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoempresa.dao;

import br.com.projetoempresa.model.PessoaJuridicaServico;
import br.com.projetoempresa.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Yuji adm
 */
public class PessoaJuridicaServicoDAO implements GenericDAO{
    
    private Connection conn;
    
    public PessoaJuridicaServicoDAO() {
        try {
            this.conn = ConnectionFactory.getConnection();            
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar com o Banco de Dados! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    @Override
    public Boolean cadastrar(Object object) {
        
        PessoaJuridicaServico pessoaJuridicaServico = (PessoaJuridicaServico) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO PESSOAJURIDICA_SERVICO(idServico, idPessoaJuridica) VALUES (?, ?);";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pessoaJuridicaServico.getServico().getIdServico());
            stmt.setInt(2, pessoaJuridicaServico.getPessoajuridica().getIdPessoaJuridica());
            stmt.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar PessoaJuridicaServicoDAO! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
            
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idOject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
