package br.com.fiap.fintech.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String url = req.getRequestURI();

		if (session.getAttribute("user") == null && !url.endsWith("login") && !url.contains("register")
				&& !url.contains("404") && !url.contains("resources") && !url.contains("styles")) {
			request.setAttribute("loginForbidden", "Entre com o usuário e senha!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
}
