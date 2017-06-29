<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
	<link href="<c:url value="resources/css/home.css" />" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="list"/></title>
</head>
<body>

<div id="langsel">
		<a href="?lang=en_GB">en</a> | <a href="?lang=fi_FI">fi</a> | <a href="?lang=ru_RU">ru</a>
	</div>

	<table>
		<caption>MP3</caption>
			<thead>
				<tr>
					<td>ID</td>
<!-- 					<td>Name</td> -->
<!-- 					<td>Author</td> -->
					<td><spring:message code="name"/></td>
					<td><spring:message code="author"/></td>
					<td>+/-</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${mp3}" var="mp3">
					<tr>
						<td><c:out value="${mp3.id}" /></td>
						<td><c:out value="${mp3.name}" /></td>
						<td><c:out value="${mp3.author}" /></td>
				<!-- Tähän on lisätty (-)BUTTON -->
						<form:form method="POST" commandName="delete" action="${mp3.id}" class="box login">
						<td><button type="submit"  class="btnLogin" tabindex="1" ><b><spring:message code="delete"/></b></button></td>
						</form:form>
					</tr>
				</c:forEach>
				<tr></tr>
			</tbody>
		</table>
		
		<p> </p>
		
<form:form method="GET" commandName="mp3" action="form" class="homeButton3">
<input type="submit" class="btnLogin" tabindex="4"  value="<spring:message code="create"/>">
</form:form>

</body>
</html>