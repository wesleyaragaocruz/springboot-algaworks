package com.algaworks.algamoney.api.repository.queries;

import com.algaworks.algamoney.api.filtro.LancamentoFiltro;
import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.projection.ResumoLancamento;
import java.time.LocalDate;
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
public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Lancamento> listar(LancamentoFiltro filtro) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> cq = cb.createQuery(Lancamento.class);
        Root<Lancamento> root = cq.from(Lancamento.class);

        cq.where(getPredicates(root, filtro, cb).toArray(new Predicate[0]));

        return manager.createQuery(cq).getResultList();
    }

    @Override
    public Page<Lancamento> listar(LancamentoFiltro filtro, Pageable pageable) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> cq = cb.createQuery(Lancamento.class);
        Root<Lancamento> root = cq.from(Lancamento.class);

        cq.where(getPredicates(root, filtro, cb).toArray(new Predicate[0]));

        TypedQuery<Lancamento> query = manager.createQuery(cq);
        query.setMaxResults(pageable.getPageSize());
        query.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());

        return new PageImpl<>(query.getResultList(), pageable, totalRegistros(filtro));
    }

    @Override
    public Page<ResumoLancamento> resumir(LancamentoFiltro filtro, Pageable pageable) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<ResumoLancamento> cq = cb.createQuery(ResumoLancamento.class);
        Root<Lancamento> root = cq.from(Lancamento.class);

        cq.select(cb.construct(ResumoLancamento.class, root.get("id"), root.get("descricao"),
                root.get("dataVencimento"), root.get("dataPagamento"), root.get("valor"),
                root.get("tipoLancamento"), root.get("categoria").get("descricao"), root.get("pessoa").get("nome")));

        cq.where(getPredicates(root, filtro, cb).toArray(new Predicate[0]));

        TypedQuery<ResumoLancamento> query = manager.createQuery(cq);
        query.setMaxResults(pageable.getPageSize());
        query.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());

        return new PageImpl<>(query.getResultList(), pageable, totalRegistros(filtro));
    }

    private Long totalRegistros(LancamentoFiltro filtro) {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Lancamento> root = cq.from(Lancamento.class);

        cq.where(getPredicates(root, filtro, cb).toArray(new Predicate[0]));
        cq.select(cb.count(root));

        return manager.createQuery(cq).getSingleResult();
    }

    private List<Predicate> getPredicates(Root<Lancamento> root, LancamentoFiltro filtro, CriteriaBuilder cb) {
        List<Predicate> filtros = new ArrayList<>();

        if (StringUtils.isNotBlank(filtro.getDescricao())) {
            filtros.add(cb.like(cb.lower(root.get("descricao")), "%" + filtro.getDescricao().toLowerCase() + "%"));
        }

        if (filtro.getDataVencimentoInicio() != null) {
            filtros.add(cb.<LocalDate>greaterThanOrEqualTo(root.get("dataVencimento"), filtro.getDataVencimentoInicio()));
        }

        if (filtro.getDataVencimentoFinal() != null) {
            filtros.add(cb.lessThanOrEqualTo(root.<LocalDate>get("dataVencimento"), filtro.getDataVencimentoFinal()));
        }

        return filtros;
    }

}
