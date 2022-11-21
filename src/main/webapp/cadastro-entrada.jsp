<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fintech - Entradas</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="entradas-form-container">
		<h1>
			Cadastro de <br /> <span class="color-effect">movimentações</span>
		</h1>
		<p>entrada</p>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg }</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro }</div>
		</c:if>
		<form action="entrada" method="post">
			<input type="hidden" value="insert" name="action">
			<div class="form-group">
				<label for="name">Nome</label> <input type="text" name="name"
					id="name" class="form-control entrada-input">
			</div>
			<div class="form-group">
				<label for="value">Valor</label> <input type="text" name="value"
					id="value" class="form-control entrada-input">
			</div>
			<input type="submit" value="Salvar" class="entradas-form-btn">
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>