package br.com.projetoempresa.model;

//O "extends" cria a herança, extende uma outra classe
public class PessoaJuridica extends Pessoa{

    //Atributos da Class
    private int idPessoaJuridica;
    private String cnpjPessoaJuridica;
    private String iePessoaJuridica;
    private TipoPessoaJuridica tipoPessoaJuridica;

    public PessoaJuridica() {
    }

    public PessoaJuridica(int idPessoaJuridica, String cnpjPessoaJuridica, String iePessoaJuridica, TipoPessoaJuridica tipoPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
        this.cnpjPessoaJuridica = cnpjPessoaJuridica;
        this.iePessoaJuridica = iePessoaJuridica;
        this.tipoPessoaJuridica = tipoPessoaJuridica;
    }

    public int getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(int idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }

    public String getCnpjPessoaJuridica() {
        return cnpjPessoaJuridica;
    }

    public void setCnpjPessoaJuridica(String cnpjPessoaJuridica) {
        this.cnpjPessoaJuridica = cnpjPessoaJuridica;
    }

    public String getIePessoaJuridica() {
        return iePessoaJuridica;
    }

    public void setIePessoaJuridica(String iePessoaJuridica) {
        this.iePessoaJuridica = iePessoaJuridica;
    }

    public TipoPessoaJuridica getTipoPessoaJuridica() {
        return tipoPessoaJuridica;
    }

    public void setTipoPessoaJuridica(TipoPessoaJuridica tipoPessoaJuridica) {
        this.tipoPessoaJuridica = tipoPessoaJuridica;
    }

}
