<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>Messages</title>
</head>
<body>
<h1>Message du salon: ${salon}</h1>

<c:choose>
    <c:when test="${empty listeMessages}">
        Le salon n'existe pas.
    </c:when>
    <c:otherwise>
        <c:forEach items="${listeMessages}" var="msg">
            ${msg} <br>
        </c:forEach>
    </c:otherwise>
</c:choose>

<br/>
<a href="/tpAjax/test/back-officeRest">Retour à l'accueil du back office</a>
</body>
</html>
