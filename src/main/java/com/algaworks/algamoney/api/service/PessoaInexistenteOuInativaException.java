package com.algaworks.algamoney.api.service;

/**
 *
 * @author wesley
 */
public class PessoaInexistenteOuInativaException extends RuntimeException {
    
    public PessoaInexistenteOuInativaException() {
        super("Pessoa inexistente ou inativa no cadastro");
    }
    
}
