package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.rmi.ServerException;

import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;

	public LoginServlet() {
		dao = DAOFactory.getUsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Usuario user = new Usuario(email, password);

		if (dao.validUser(user)) {
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			request.setAttribute("invalidCredentials", "Usuário ou senha inválidos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
