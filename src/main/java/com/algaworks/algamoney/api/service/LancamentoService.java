package com.algaworks.algamoney.api.service;

import com.algaworks.algamoney.api.filtro.LancamentoFiltro;
import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.projection.ResumoLancamento;
import com.algaworks.algamoney.api.repository.LancamentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author wesley
 */
@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private PessoaService pessoaService;

    public Lancamento buscarPorId(Long id) {
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
        return lancamento.isPresent() ? lancamento.get() : null;
    }

    public List<Lancamento> buscarTodos() {
        return lancamentoRepository.findAll();
    }

    public List<Lancamento> listar(LancamentoFiltro filtro) {
        return lancamentoRepository.listar(filtro);
    }

    public Lancamento criar(Lancamento lancamento) {
        Pessoa pessoa = pessoaService.buscarPorId(lancamento.getPessoa().getId());
        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }

        return lancamentoRepository.save(lancamento);
    }

    public void remover(Long id) {
        lancamentoRepository.deleteById(id);
    }

    public Lancamento atualizar(Long id, Lancamento lancamento) {
        Lancamento lancamentoSalvo = this.buscarPorId(id);
        if (lancamentoSalvo == null) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");
        return lancamentoRepository.save(lancamentoSalvo);
    }

    public Page<Lancamento> listar(LancamentoFiltro filtro, Pageable pageable) {
        return lancamentoRepository.listar(filtro, pageable);
    }

    public Page<ResumoLancamento> resumir(LancamentoFiltro filtro, Pageable pageable) {
        return lancamentoRepository.resumir(filtro, pageable);
    }
}
