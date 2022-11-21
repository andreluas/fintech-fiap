package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.exceptions.DBException;
import br.com.fiap.fintech.model.Entrada;

public interface EntradaDAO {

	void insert(Entrada entrada) throws DBException;
	void update(Entrada entrada) throws DBException;
	void delete(int id) throws DBException;
	Entrada findById(int id);
	List<Entrada> findAll();
}
