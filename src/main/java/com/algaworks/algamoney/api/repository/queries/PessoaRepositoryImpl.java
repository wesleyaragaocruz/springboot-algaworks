package com.algaworks.algamoney.api.repository.queries;

import com.algaworks.algamoney.api.filtro.PessoaFiltro;
import com.algaworks.algamoney.api.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author wesley
 */
public class PessoaRepositoryImpl implements PessoaRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Pessoa> listar(PessoaFiltro filtro) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
        Root<Pessoa> root = cq.from(Pessoa.class);

        cq.where(getPredicates(root, filtro, cb).toArray(new Predicate[0]));

        return manager.createQuery(cq).getResultList();
    }

    @Override
    public Page<Pessoa> listar(PessoaFiltro filtro, Pageable pageable) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
        Root<Pessoa> root = cq.from(Pessoa.class);

        cq.where(getPredicates(root, filtro, cb).toArray(new Predicate[0]));

        TypedQuery<Pessoa> query = manager.createQuery(cq);
        query.setMaxResults(pageable.getPageSize());
        query.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());

        return new PageImpl<>(query.getResultList(), pageable, totalRegistros(filtro));
    }

    private Long totalRegistros(PessoaFiltro filtro) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Pessoa> root = cq.from(Pessoa.class);

        cq.where(getPredicates(root, filtro, cb).toArray(new Predicate[0]));
        cq.select(cb.count(root));

        return manager.createQuery(cq).getSingleResult();
    }

    private List<Predicate> getPredicates(Root<Pessoa> root, PessoaFiltro filtro, CriteriaBuilder cb) {
        List<Predicate> filtros = new ArrayList<>();

        if (StringUtils.isNotBlank(filtro.getNome())) {
            filtros.add(cb.like(cb.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));
        }

        return filtros;
    }

}
