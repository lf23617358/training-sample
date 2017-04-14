<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/form" var="form" />
<!DOCTYPE html>
<html>
<head>
<title>Upload a file please</title>
</head>
<body>
	<h1>Please upload a file</h1>
	<form method="post" action="${form}" enctype="multipart/form-data">
		<input type="text" name="name" /> <input type="file" name="file" /> <input
			type="submit" />
	</form>
	<p>${result}</p>
</body>
</html>