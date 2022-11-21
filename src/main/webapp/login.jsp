<!DOCTYPE html>
<html lang="en">
<head>
<title>Fintech</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="login-container">
		<div class="login-background-container"></div>
		<div class="login-headline-container">
			<h1>fintech</h1>
			<p>
				Conquiste e <span class="color-effect">viva</span> <br /> sua <span
					class="color-effect">independencia</span>
			</p>
		</div>
		<div class="login-signin-container">
			<h1>sign in</h1>
			<c:if test="${empty user }">
				<span class="navbar-text text-danger">${invalidCredentials }</span>
			</c:if>
			<form action="login" method="post">
				<div class="form-login">
					<label for="email"></label> <input type="email" name="email"
						id="email" class="form-login" placeholder="email" />
				</div>
				<div class="form-login">
					<label for="password"></label> <input type="password"
						name="password" id="password" class="form-login"
						placeholder="password" />
				</div>
				<input type="submit" value="Login" class="login-form-btn" />
			</form>
			<p>
				Nao tem conta? <a onclick="window.location='register.jsp'">Cadastre-se</a>
			</p>
		</div>
	</div>
</body>
</html>
