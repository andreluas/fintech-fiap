package br.com.fiap.fintech.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.fintech.connection.ConnectionManager;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exceptions.DBException;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.utils.PCrypt;

public class OracleUsuarioDAO implements UsuarioDAO {

	private Connection connection;

	@Override
	public boolean validEmail(String email) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM USUARIO WHERE EMAIL = ?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return true;
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

		return false;
	}

	@Override
	public boolean validUser(Usuario user) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM USUARIO WHERE EMAIL = ? AND PASSWORD = ?");
			stmt.setString(1, user.getEmail());
			try {
				stmt.setString(2, PCrypt.crypt(user.getPassword()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = stmt.executeQuery();

			if (rs.next()) {
				return true;
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

		return false;
	}

	@Override
	public void registerUser(Usuario user) throws DBException {
		PreparedStatement stmt = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO USUARIO(email, password) VALUES (?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			try {
				stmt.setString(2, PCrypt.crypt(user.getPassword()));
			} catch (Exception e) {
				e.printStackTrace();
			}
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
	public Usuario findByEmail(String email) {
		Usuario usuario = new Usuario();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionManager.getInstance().getConnection();
			stmt = connection.prepareStatement("SELECT * FROM USUARIO WHERE EMAIL=?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String password = rs.getString("PASSWORD");
				usuario.setEmail(email);
				usuario.setPassword(password);
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

		return usuario;
	}
}
