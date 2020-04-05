package com.primeirospring.vscode.repository;

import com.primeirospring.vscode.models.Convidado;
import com.primeirospring.vscode.models.Evento;

import org.springframework.data.repository.CrudRepository;

/**
 * ConvidadosRepository
 */
public interface ConvidadosRepository extends CrudRepository<Convidado,  String>{
     Iterable<Convidado> findByEvento(Evento evento);
     Convidado findByRg(String rg);
    
}