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

public class TipoPessoaJuridicaDAO implements GenericDAO{
    
    private Connection conn;

    //Prepara a conexao
    public TipoPessoaJuridicaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
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

    @Override
    public List<Object> listar() {
        List<Object> tiposPessoaJuridica = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs  = null;
        
        String sql = "select * from tipopessoajuridica order by nometipopessoajuridica;";
        
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                TipoPessoaJuridica tipoPessoaJuridica = new TipoPessoaJuridica();
                tipoPessoaJuridica.setIdTipoPessoaJuridica(rs.getInt("idTipoPessoaJuridica"));
                tipoPessoaJuridica.setNomeTipoPessoaJuridica(rs.getString("nomeTipoPessoaJuridica"));
                
                tiposPessoaJuridica.add(tipoPessoaJuridica);
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao listar os TiposPessoaJuridicaDAO: Erro!:" + ex.getMessage()) ;
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar a conexão. Erro! " + ex.getMessage());
            }
        }
        return tiposPessoaJuridica;
    }

}
