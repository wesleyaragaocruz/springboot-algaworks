package com.algaworks.algamoney.api.repository;

import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.queries.PessoaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author wesley
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery {

}
