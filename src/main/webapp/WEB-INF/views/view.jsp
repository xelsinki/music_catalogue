<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="resources/css/home.css" />" rel="stylesheet" type="text/css">
<%-- <link href="<c:url value="resources/css/reset.css" />" rel="stylesheet" type="text/css"> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="viewTitle"/></title>
</head>	
<body>
	<div id="langsel">
		<a href="?lang=en_GB">en</a> | <a href="?lang=fi_FI">fi</a> | <a href="?lang=ru_RU">ru</a>
	</div>
	<h1>
		<spring:message code="viewTitle"/>
	</h1>
	<p>ID: <c:out value="${mp3.id}" default="-----"/></p>
	<p><spring:message code="name"/>: <c:out value="${mp3.name}" default="-----"/></p>
	<p><spring:message code="author"/>: <c:out value="${mp3.author}" default="-----"/></p>
	<p><a href="list"><spring:message code="list"/></a>
</body>
</html>