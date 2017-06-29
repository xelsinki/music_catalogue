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
<title>Home</title>
<body>
<span style="float: right"> 
				<a href="?lang=en_GB">en</a>
				<a href="?lang=fi_FI">fi</a> 
				<a href="?lang=ru_RU">ru</a>
</span>
<h1>
	Hello world!  
</h1>

<h2><spring:message code="hello"/></h2> 

<h4><spring:message code="helloText"/></h4> 

<p>  <spring:message code="time"/>${serverTime}. </p>

<form:form  method="GET" commandName="form" action="form" class="homeButton1">
<input type="submit" class="btnLogin" tabindex="4"  value="<spring:message code="create"/>">
</form:form>

<form:form method="GET" commandName="mp3" action="list" class="homeButton2">
<input type="submit" class="btnLogin" tabindex="4"  value="<spring:message code="list"/>">
</form:form>

</body>
</html>
