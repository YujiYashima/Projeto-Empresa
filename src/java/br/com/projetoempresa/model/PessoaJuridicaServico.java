
package br.com.projetoempresa.model;

/**
 *
 * @author Yuji adm
 */

public class PessoaJuridicaServico {
    
    private Servico servico;
    private PessoaJuridica pessoajuridica;

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public PessoaJuridica getPessoajuridica() {
        return pessoajuridica;
    }

    public void setPessoajuridica(PessoaJuridica pessoajuridica) {
        this.pessoajuridica = pessoajuridica;
    }
   
}
