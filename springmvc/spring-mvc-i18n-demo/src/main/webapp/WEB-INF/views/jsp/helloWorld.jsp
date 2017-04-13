<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:message code="welcome_title" var="welcomeTitle" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Maven + Spring MVC + @JavaConfig</title>
</head>
<body>
	<h1>${welcomeTitle}</h1>
	<form action="localetest" method="get">
		<select name="lang">
			<option>en_US</option>
			<option>zh_TW</option>
		</select>
		<button type="submit">submit</button>
	</form>
</body>
</html>