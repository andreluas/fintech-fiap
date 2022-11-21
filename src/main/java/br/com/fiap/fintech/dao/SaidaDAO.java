package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.exceptions.DBException;
import br.com.fiap.fintech.model.Saida;

public interface SaidaDAO {

	void insert(Saida saida) throws DBException;
	void update(Saida saida) throws DBException;
	void delete(int id) throws DBException;
	Saida findById(int id);
	List<Saida> findAll();
}
