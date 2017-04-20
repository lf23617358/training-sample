<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>
<link href="${rootPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<link
	href="${rootPath}/webjars/bootstrap-table/1.11.1/dist/bootstrap-table.min.css"
	type="text/css" rel="stylesheet" />
<link href="${rootPath}/resources/css/user.css" type="text/css"
	rel="stylesheet" />

<script src="${rootPath}/webjars/jquery/3.2.0/jquery.min.js"></script>
<script src="${rootPath}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="${rootPath}/webjars/bootstrap-table/1.11.1/dist/bootstrap-table.min.js"></script>
<script src="${rootPath}/resources/js/user.js"></script>

</head>
<body>
	<div class="container">
		<h1>This is a Web Sample</h1>
		<div class="panel panel-default">
			<div class="panel-heading">Query Panel</div>
			<div class="panel-body">
				<form id="queryForm" class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-2" for="name">name:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name"
								placeholder="Search Name">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="age">age:</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="age"
								placeholder="Search Age">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="country">country:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="country"
								placeholder="Search Country">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<p class="toolbar">
			<button id="createBtn" class="btn btn-success" title="Create Item">create</button>
			<button id="deleteBtn" class="btn btn-danger">delete</button>
			<span id="alert" class="alert"></span>
		</p>
		<table id="table" class="table table-hover table-striped"
			data-side-pagination="server" data-method="post"
			data-toolbar=".toolbar" data-url="user/listUser">
			<thead>
				<tr>
					<th data-field="state" data-checkbox="true"></th>
					<!-- 					<th data-field="id">id</th> -->
					<th data-field="name">name</th>
					<th data-field="age">age</th>
					<th data-field="country">country</th>
					<th data-field="action" data-align="center"
						data-formatter="actionFormatter" data-events="actionEvents">Action</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="modal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Create User</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label class="control-label" for="name">name</label> <input
							type="text" class="form-control" name="name"
							placeholder="Enter Name">
					</div>
					<div class="form-group">
						<label class="control-label" for="age">age</label> <input
							type="number" class="form-control" name="age"
							placeholder="Enter Age">
					</div>
					<div class="form-group">
						<label class="control-label" for="country">country</label> <input
							type="text" class="form-control" name="country"
							placeholder="Enter Country">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="submitBtn" type="button" class="btn btn-primary">Submit</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</body>

</html>