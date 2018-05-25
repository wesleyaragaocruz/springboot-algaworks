package com.algaworks.algamoney.api.repository.queries;

import com.algaworks.algamoney.api.filtro.PessoaFiltro;
import com.algaworks.algamoney.api.model.Pessoa;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author wesley
 */
public interface PessoaRepositoryQuery {

    public List<Pessoa> listar(PessoaFiltro filtro);

    public Page<Pessoa> listar(PessoaFiltro filtro, Pageable pageable);

}
