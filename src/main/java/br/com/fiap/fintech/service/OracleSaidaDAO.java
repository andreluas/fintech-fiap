package br.com.fiap.fintech.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.connection.ConnectionManager;
import br.com.fiap.fintech.dao.SaidaDAO;
import br.com.fiap.fintech.exceptions.DBException;
import br.com.fiap.fintech.model.Saida;
import br.com.fiap.fintech.model.Usuario;

public class OracleSaidaDAO implements SaidaDAO {

	private Connection connection;

	@Override
	public void insert(Saida saida) throws DBException {
		PreparedStatement stmt = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO SAIDAS(NOME, VALOR, EMAIL) VALUES (?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, saida.getNome());
			stmt.setDouble(2, saida.getValor());
			stmt.setString(3, saida.getUsuario().getEmail());
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
	public void update(Saida saida) throws DBException {
		PreparedStatement stmt = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE SAIDAS SET NOME=?, VALOR=?, EMAIL=? WHERE ID=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, saida.getNome());
			stmt.setDouble(2, saida.getValor());
			stmt.setString(3, saida.getUsuario().getEmail());
			stmt.setInt(4, saida.getId());
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
			String sql = "DELETE FROM SAIDAS WHERE ID=?";
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
	public Saida findById(int id) {
		Saida saida = new Saida();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM SAIDAS WHERE ID=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int cod = rs.getInt("ID");
				String nome = rs.getString("NOME");
				Double valor = rs.getDouble("VALOR");
				String email = rs.getString("EMAIL");
				saida = new Saida(cod, nome, valor);
				Usuario usuario = new Usuario(email);
				saida.setUsuario(usuario);
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

		return saida;
	}

	@Override
	public List<Saida> findAll() {
		List<Saida> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM SAIDAS");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String nome = rs.getString("NOME");
				Double valor = rs.getDouble("VALOR");
				String email = rs.getString("EMAIL");
				Saida saida = new Saida(id, nome, valor);
				Usuario usuario = new Usuario(email);
				saida.setUsuario(usuario);
				list.add(saida);
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
