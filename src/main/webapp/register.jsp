<!DOCTYPE html>
<html lang="en">
<head>
<title>Fintech</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="register-signin-container">
		<h1>register</h1>
		<form action="register" method="post">
			<div class="form-login">
				<label for="email"></label> <input type="email" name="email"
					id="email" class="form-login" placeholder="email" />
			</div>
			<div class="form-login">
				<label for="password"></label> <input type="password"
					name="password" id="password" class="form-login"
					placeholder="password" />
			</div>
			<input type="submit" value="Registrar" class="login-form-btn" />
		</form>
		<c:if test="${empty user }">
			<span class="navbar-text text-danger">${userExists }</span>
		</c:if>
	</div>
</body>
</html>
