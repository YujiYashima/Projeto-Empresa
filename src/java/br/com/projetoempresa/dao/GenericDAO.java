package br.com.projetoempresa.dao;

import java.util.List;

public interface GenericDAO {
    
    //Criar assinaturas dos metodos
    
    public Boolean cadastrar(Object object);
    
    public List<Object> listar();
    
    public Boolean excluir(int idOject);
    
    public Object carregar(int idObject);
    
}
