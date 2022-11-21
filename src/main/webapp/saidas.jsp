<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fintech - Saidas</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ include file="menu.jsp"%>
	<div class="entradas-list-container">
		<h1>Saidas</h1>
		<p>
			verifique aqui todas as <br /> suas <span class="color-effect">saidas</span>
		</p>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg }</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro }</div>
		</c:if>
		<div class="table-wrapper-scroll-y custom-scrollbar">
			<table class="table table-bordered table-striped">
				<tr>
					<th>Nome</th>
					<th>Valor</th>
					<th></th>
				</tr>
				<c:forEach items="${saidas}" var="e">
					<tr>
						<td>${e.nome }</td>
						<td>${e.valor }</td>
						<td><c:url value="saida" var="link">
								<c:param name="action" value="open-edit-form" />
								<c:param name="id" value="${e.id}" />
							</c:url>
							<div class="entradas-list-button-container">
								<a href="${link }" class="entradas-list-container-buttons">Editar</a>
								<form action="saida" method="post">
									<input type="hidden" name="action" value="delete"> <input
										type="hidden" value="${e.id }" name="id" id="id">
									<button type="submit" class="entradas-list-container-buttons">
										<i class="fa-solid fa-trash"></i>
									</button>
								</form>
							</div></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<a href="cadastro-saida.jsp">Cadastrar</a>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>