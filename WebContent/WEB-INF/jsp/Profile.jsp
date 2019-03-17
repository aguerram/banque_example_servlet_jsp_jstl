<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Profile</title>
<link rel="stylesheet" href="${assets}css/bootstrap.css">
<link rel="stylesheet" href="${assets}css/font-awesome.css">

<script type="text/javascript" src== "${assets}js/jquery-3.2.1.js"></script>
<script type="text/javascript" src== "${assets}js/popper.js"></script>
<script type="text/javascript" src== "${assets}js/bootstrap.js"></script>
</head>
<body>
	<div class="container h-100">
		<h1 class="text-center">Profile</h1>
		<div class="row">
			<div class="col-12 col-md-6">
				<h3>History</h3>
				<table class="table col-12 table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Amount</th>
							<th>Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${history}" var="itm">
							<tr>
								<td>${itm.id}</td>
								<c:if test="${itm.amount >= 0}">
									<td class="text-success"><b>${itm.amount}</b> $</td>
								</c:if>
								<c:if test="${itm.amount < 0}">
									<td class="text-danger"><b>${itm.amount}</b> $</td>
								</c:if>
								<td>${itm.at}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-12 col-md-6 mt-md-4 align-items-center">
				<hr>
				<div class="row justify-content-center mt-1">
					<h5>
						<p>
							<c:out value="${msg}"></c:out>
						</p>
						<label>Amount : </label> <span
							style="font-size: normal; text-decoration: underline;">${amount }$</span>
					</h5>
				</div>
				<hr>
				<div class="mt-3">
					<div class="row justify-content-center">
						<table class="table table-dark col-10">
							<thead>
								<tr>
									<th>First name</th>
									<td>${user.prenom }</td>
								</tr>
								<tr>
									<th>Last name</th>
									<td>${user.nom }</td>
								</tr>
								<tr>
									<th>Email</th>
									<td>${user.email }</td>
								</tr>
							</thead>
						</table>
					</div>
					<a href="/Banque_Example/amount" class="btn-success btn btn-block">
						<i class="fa fa-arrow-up"></i> Add random amount
					</a>
					<a href="/Banque_Example/amount?type=remove" class="btn-danger btn btn-block">
						<i class="fa fa-arrow-down"></i> Remove random amount
					</a>
					<hr>
					<div class="btn-group">
						<a href='<c:out value="${signout}"></c:out>' class="btn btn-warning">
							<i class="fa fa-sign-out"></i> Signout
						</a>
						<a href='<c:out value="${settings}"></c:out>' class="btn btn-primary">
							<i class="fa fa-cog"></i> Settings
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>