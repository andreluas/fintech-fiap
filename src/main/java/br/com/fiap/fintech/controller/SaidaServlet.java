package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import br.com.fiap.fintech.dao.SaidaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exceptions.DBException;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.Saida;
import br.com.fiap.fintech.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saida")
public class SaidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SaidaDAO dao;
	private UsuarioDAO userDao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getSaidaDAO();
		userDao = DAOFactory.getUsuarioDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "list":
			list(request, response);
			break;
		case "open-edit-form":
			int id = Integer.parseInt(request.getParameter("id"));
			Saida saida = dao.findById(id);
			request.setAttribute("saida", saida);
			request.getRequestDispatcher("edicao-saida.jsp").forward(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Saida> list = dao.findAll();
		request.setAttribute("saidas", list);
		request.getRequestDispatcher("saidas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "insert":
			insert(request, response);
			break;
		case "edit":
			edit(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			dao.delete(id);
			request.setAttribute("msg", "Saida removida!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}
		list(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			double value = Double.parseDouble(request.getParameter("value"));
			Usuario userSession = (Usuario) request.getSession().getAttribute("user");
			String email = userSession.getEmail();

			Usuario user = userDao.findByEmail(email);
			Saida saida = new Saida(name, value, user);
			dao.insert(saida);
			request.setAttribute("msg", "Saida cadastrada!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-saida.jsp").forward(request, response);
	}

	@SuppressWarnings("unused")
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			double value = Double.parseDouble(request.getParameter("value"));
			Usuario userSession = (Usuario) request.getSession().getAttribute("user");
			String email = userSession.getEmail();

			Usuario user = userDao.findByEmail(email);
			Saida saida = new Saida(id, name, value, user);
			dao.update(saida);
			request.setAttribute("msg", "Produto atualizado!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		list(request, response);
	}
}
