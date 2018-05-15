package com.algaworks.algamoney.api.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author wesley
 */
@Embeddable
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pes_ds_logradouro")
    private String logradouro;

    @Column(name = "pes_ds_numero")
    private String numero;

    @Column(name = "pes_ds_complemento")
    private String complemento;

    @Column(name = "pes_ds_bairro")
    private String bairro;

    @Column(name = "pes_ds_cep")
    private String cep;

    @Column(name = "pes_ds_cidade")
    private String cidade;

    @Column(name = "pes_ds_estado")
    private String estado;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
