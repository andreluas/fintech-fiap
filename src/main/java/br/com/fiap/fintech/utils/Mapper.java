package br.com.fiap.fintech.utils;

import br.com.fiap.fintech.model.Entrada;

import br.com.fiap.fintech.model.Saida;
import br.com.fiap.fintech.service.OracleEntradaDAO;
import br.com.fiap.fintech.service.OracleSaidaDAO;

public class Mapper {

	public static Entrada entrada(int id, Entrada entrada) {
		OracleEntradaDAO service = new OracleEntradaDAO();
		Entrada entity = service.findById(id);
		entrada.setId(id);
		if (entrada.getNome() == null) {
			entrada.setNome(entity.getNome());
		}
		if (entrada.getValor() == null) {
			entrada.setValor(entity.getValor());
		}
		if (entrada.getUsuario() == null) {
			entrada.setUsuario(entity.getUsuario());
		}

		return entrada;
	}

	public static Saida saida(int id, Saida saida) {
		OracleSaidaDAO service = new OracleSaidaDAO();
		Saida entity = service.findById(id);
		saida.setId(id);
		if (saida.getNome() == null) {
			saida.setNome(entity.getNome());
		}
		if (saida.getValor() == null) {
			saida.setValor(entity.getValor());
		}
		if (saida.getUsuario() == null) {
			saida.setUsuario(entity.getUsuario());
		}

		return saida;
	}
}
