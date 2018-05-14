package com.algaworks.algamoney.api.repository;

import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.repository.queries.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author wesley
 */
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
