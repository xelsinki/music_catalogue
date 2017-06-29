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
<title><spring:message code="create"/></title>
</head>
<body>

<!-- <h1>Create:</h1> -->

<h2><spring:message code="create"/></h2> 

<form:form method="POST" commandName="mp3" action="create" class="box login">
	<fieldset class="boxBody">
				
	<div id="langsel">
		<a href="?lang=en_GB">en</a> | <a href="?lang=fi_FI">fi</a> | <a href="?lang=ru_RU">ru</a>
	</div>
	  <form:label path="name"><spring:message code="name"/></form:label>
	  <form:input path="name" placeholder="name"></form:input>
	  <form:errors path="name" cssClass="error"></form:errors>
	  
	  <form:label path="author"><spring:message code="author"/></form:label>
	  <form:input path="author" placeholder="author"></form:input>
	  <form:errors path="author" cssClass="error"></form:errors>
	</fieldset>
	
	<footer>
	  <input type="submit" class="btnLogin" tabindex="4"
	  value="<spring:message code="create"/>">
	</footer>
</form:form>


<%-- <form:form method="POST" commandName="create" action="create" class="login"> --%>
<!-- <input type="submit" class="btnLogin" value="Login" tabindex="4"> -->
<!-- <p><a href="tiedot">tiedot</a></p>	 -->
<%-- </form:form> --%>


</body>
</html>