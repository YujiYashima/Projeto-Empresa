package br.com.projetoempresa.model;

public class TipoPessoaJuridica {
    
    private Integer idTipoPessoaJuridica;
    private String nomeTipoPessoaJuridica;

    public TipoPessoaJuridica() {
    }

    public TipoPessoaJuridica(Integer idTipoPessoaJuridica) {
        this.idTipoPessoaJuridica = idTipoPessoaJuridica;
    }

    public TipoPessoaJuridica(String nomeTipoPessoaJuridica) {
        this.nomeTipoPessoaJuridica = nomeTipoPessoaJuridica;
    }

    public TipoPessoaJuridica(Integer idTipoPessoaJuridica, String nomeTipoPessoaJuridica) {
        this.idTipoPessoaJuridica = idTipoPessoaJuridica;
        this.nomeTipoPessoaJuridica = nomeTipoPessoaJuridica;
    }

    public Integer getIdTipoPessoaJuridica() {
        return idTipoPessoaJuridica;
    }

    public void setIdTipoPessoaJuridica(Integer idTipoPessoaJuridica) {
        this.idTipoPessoaJuridica = idTipoPessoaJuridica;
    }

    public String getNomeTipoPessoaJuridica() {
        return nomeTipoPessoaJuridica;
    }

    public void setNomeTipoPessoaJuridica(String nomeTipoPessoaJuridica) {
        this.nomeTipoPessoaJuridica = nomeTipoPessoaJuridica;
    }
  
}
