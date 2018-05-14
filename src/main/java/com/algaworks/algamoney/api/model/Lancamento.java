package com.algaworks.algamoney.api.model;

import com.algaworks.algamoney.api.enums.TipoLancamento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wesley
 */
@Entity
@Table(name = "tb_lcm_lancamento")
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lcm_id_lancamento")
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lcm_ds_lancamento")
    private String descricao;

    @NotNull
    @Column(name = "lcm_dt_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "lcm_dt_pagamento")
    private LocalDate dataPagamento;

    @NotNull
    @Column(name = "lcm_vl_lancamento")
    private BigDecimal valor;

    @Size(max = 100)
    @Column(name = "lcm_ds_observacao")
    private String observacao;

    @NotNull
    @Column(name = "lcm_tp_lancamento")
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipoLancamento;

    @NotNull
    @JoinColumn(name = "cat_id_categoria", referencedColumnName = "cat_id_categoria")
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @JoinColumn(name = "pes_id_pessoa", referencedColumnName = "pes_id_pessoa")
    @ManyToOne
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Lancamento)) {
            return false;
        }
        Lancamento other = (Lancamento) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

}
