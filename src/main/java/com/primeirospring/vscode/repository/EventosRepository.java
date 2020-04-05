package com.primeirospring.vscode.repository;

import com.primeirospring.vscode.models.Evento;

import org.springframework.data.repository.CrudRepository;

/**
 * EventosRepository
 */
public interface EventosRepository extends CrudRepository<Evento, String>{
	Evento findByCodigo(long codigo);
}