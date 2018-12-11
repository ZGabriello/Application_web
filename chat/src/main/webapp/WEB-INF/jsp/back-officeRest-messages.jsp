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

    <h1 style="text-align: center;color: blue;">Chatons.org</h1>
    <hr>

    <div class="chat" style="width: 500px;margin: 40px auto;background: #FFF;border-radius: 10px;text-align: center;">
        <h2>Messages du salon: ${salon}</h2>

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

        <br>
        <a href="/tpAjax/test/back-officeRest">Retour à l'accueil du back office</a>
    </div>
</body>
</html>
