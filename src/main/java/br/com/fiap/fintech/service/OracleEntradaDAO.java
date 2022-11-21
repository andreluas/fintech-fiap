package br.com.fiap.fintech.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.connection.ConnectionManager;
import br.com.fiap.fintech.dao.EntradaDAO;
import br.com.fiap.fintech.exceptions.DBException;
import br.com.fiap.fintech.model.Entrada;
import br.com.fiap.fintech.model.Usuario;

public class OracleEntradaDAO implements EntradaDAO {

	private Connection connection;

	@Override
	public void insert(Entrada entrada) throws DBException {
		PreparedStatement stmt = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO ENTRADAS(NOME, VALOR, EMAIL) VALUES (?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, entrada.getNome());
			stmt.setDouble(2, entrada.getValor());
			stmt.setString(3, entrada.getUsuario().getEmail());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Registration error");
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Entrada entrada) throws DBException {
		PreparedStatement stmt = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE ENTRADAS SET NOME=?, VALOR=?, EMAIL=? WHERE ID=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, entrada.getNome());
			stmt.setDouble(2, entrada.getValor());
			stmt.setString(3, entrada.getUsuario().getEmail());
			stmt.setInt(4, entrada.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Update error");
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int id) throws DBException {
		PreparedStatement stmt = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM ENTRADAS WHERE ID=?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("Delete error");
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Entrada findById(int id) {
		Entrada entrada = new Entrada();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM ENTRADAS WHERE ID=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int cod = rs.getInt("ID");
				String nome = rs.getString("NOME");
				Double valor = rs.getDouble("VALOR");
				String email = rs.getString("EMAIL");
				entrada = new Entrada(cod, nome, valor);
				Usuario usuario = new Usuario(email);
				entrada.setUsuario(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return entrada;
	}

	@Override
	public List<Entrada> findAll() {
		List<Entrada> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM ENTRADAS");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String nome = rs.getString("NOME");
				Double valor = rs.getDouble("VALOR");
				String email = rs.getString("EMAIL");
				Entrada entrada = new Entrada(id, nome, valor);
				Usuario usuario = new Usuario(email);
				entrada.setUsuario(usuario);
				list.add(entrada);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}
