<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Login</title>
<link rel="stylesheet" href="${assets}css/bootstrap.css">
<link rel="stylesheet" href="${assets}css/font-awesome.css">

<script type="text/javascript" src=="${assets}js/jquery-3.2.1.js"></script>
<script type="text/javascript" src=="${assets}js/popper.js"></script>
<script type="text/javascript" src=="${assets}js/bootstrap.js"></script>
</head>
<body>
	<div class="container h-100">
		<div class="row h-100  justify-content-center align-items-center">
			<form class="col-12 col-md-6 col-lg-4 p-4 shadow-lg" method="post">
				<div class="row justify-content-center">
					<i class="fa fa-user-circle fa-5x"></i>
				</div>
				<br>
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fa fa-user-circle-o"></i>
						</div>
					</div>
					<input required type="email" value='<c:out value="${email}"></c:out>' class="form-control" name="email"
						placeholder="Email">
				</div>
				<div class="input-group mt-1">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fa fa-key"></i>
						</div>
					</div>
					<input required type="password" class="form-control" name="password"
						placeholder="Password">
				</div>
				<br>
				<button type="submit" class="btn btn-primary">Submit</button>
				<c:if test="${msg != null}">
					<br>
					<br>
					<div class="alert alert-danger"><c:out value="${msg}"></c:out> </div>
				</c:if>
			</form>
		</div>
	</div>
</body>
</html>