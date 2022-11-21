<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fintech - Saidas</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="entradas-form-container">
		<h1>
			Edição de <br /> <span class="color-effect">movimentações</span>
		</h1>
		<p>saida</p>
		<form action="saida" method="post">
			<input type="hidden" value="edit" name="action"> <input
				type="hidden" value="${saida.id }" name="id">
			<div class="form-group">
				<label for="name">Nome</label> <input type="text" name="name"
					id="name" class="form-control entrada-input">
			</div>
			<div class="form-group">
				<label for="value">Valor</label> <input type="text" name="value"
					id="value" class="form-control entrada-input">
			</div>
			<div class="entrada-edit-form-buttons">
				<input type="submit" value="Salvar" class="entradas-form-btn">
				<a href="saida?action=list" class="entradas-form-btn cancelar">Cancelar</a>
			</div>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>