<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${assets}css/bootstrap.css">
<link rel="stylesheet" href="${assets}css/font-awesome.css">

<script type="text/javascript" src== "${assets}js/jquery-3.2.1.js"></script>
<script type="text/javascript" src== "${assets}js/popper.js"></script>
<script type="text/javascript" src== "${assets}js/bootstrap.js"></script>
<meta charset="windows-1256">
<title>Settings | ${user.nom} ${user.prenom}</title>
</head>
<body>
	<div class="container">
		<div class="row mt-3">
			<a href="${goback }" class="btn btn-primary"><i
				class="fa fa-arrow-left"></i> Go Back</a>
		</div>
		<div class="row justify-content-center">
			<form method="post" class="col-12 col-md-6 mt-3 p-3 shadow">
				<p class="text-center">
					<i class="fa fa-user-circle fa-5x"></i>
				</p>
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fa fa-user-circle-o"></i>
						</div>
					</div>
					<input required type="email"
						value='<c:out value="${user.email}"></c:out>' class="form-control"
						name="email" placeholder="Email">
				</div>
				<div class="input-group mt-1">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fa fa-key"></i>
						</div>
					</div>
					<input required type="password" class="form-control" name="password"
						placeholder="Password" value="${user.password}">
				</div>
				<hr>
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fa fa-user-circle-o"></i>
						</div>
					</div>
					<input required type="text"
						value='<c:out value="${user.nom}"></c:out>' class="form-control"
						name="nom" placeholder="Nom">
				</div>
				<div class="input-group mt-1">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fa fa-user-circle-o"></i>
						</div>
					</div>
					<input required type="text"
						value='<c:out value="${user.prenom}"></c:out>'
						class="form-control" name="prenom" placeholder="Prenom">
				</div>
				<input type="hidden" name="id" value="${user.id }"> <br>
				<div class="row justify-content-end ">
					<button type="submit" class="btn btn-success mr-3">
						<i class="fa fa-save"></i> Save
					</button>
				</div>
				<c:if test="${msg != null }">
					<div class="alert alert-primary">${msg }</div>
				</c:if>
			</form>

		</div>
	</div>
</body>
</html>