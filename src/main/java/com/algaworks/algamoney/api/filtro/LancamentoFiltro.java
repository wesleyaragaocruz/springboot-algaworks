package com.algaworks.algamoney.api.filtro;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author wesley
 */
public class LancamentoFiltro {

    private String descricao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimentoInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimentoFinal;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimentoInicio() {
        return dataVencimentoInicio;
    }

    public void setDataVencimentoInicio(LocalDate dataVencimentoInicio) {
        this.dataVencimentoInicio = dataVencimentoInicio;
    }

    public LocalDate getDataVencimentoFinal() {
        return dataVencimentoFinal;
    }

    public void setDataVencimentoFinal(LocalDate dataVencimentoFinal) {
        this.dataVencimentoFinal = dataVencimentoFinal;
    }

}
