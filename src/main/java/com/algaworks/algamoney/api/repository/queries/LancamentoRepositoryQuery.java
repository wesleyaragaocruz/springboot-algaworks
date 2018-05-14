package com.algaworks.algamoney.api.repository.queries;

import com.algaworks.algamoney.api.filtro.LancamentoFiltro;
import com.algaworks.algamoney.api.model.Lancamento;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author wesley
 */
public interface LancamentoRepositoryQuery {

    public List<Lancamento> listar(LancamentoFiltro filtro);
    
    public Page<Lancamento> listar(LancamentoFiltro filtro, Pageable pageable);

}
