package br.com.projetoempresa.model;

/**
 *
 * @author Yuji adm
 */

public class Servico {
    
    private Integer idServico;
    private String nomeServico;
    private Double valorServico;
    private String descricaoServico;

    public Servico() {
    }

    public Servico(Integer idServico) {
        this.idServico = idServico;
    }

    public Servico(Integer idServico, String nomeServico, Double valorServico, String descricaoServico) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.valorServico = valorServico;
        this.descricaoServico = descricaoServico;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    } 
    
}
