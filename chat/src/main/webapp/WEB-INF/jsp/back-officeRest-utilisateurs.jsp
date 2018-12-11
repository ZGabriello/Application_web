<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="../../style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>

    <h1 style="text-align: center;color: blue;">Chatons.org</h1>
    <hr>
    <div class="chat" style="width: 500px;margin: 40px auto;background: #FFF; text-align: center;">
        <c:choose>
            <c:when test="${requete == 'GET'}">

                <c:choose>
                    <c:when test="${not empty listeUtilisateurs}">
                        <h3>Utilisateurs pouvant accéder au chat: </h3>

                        <c:forEach items="${listeUtilisateurs}" var="user">
                            <h3> - ${user.nom} </h3>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h3>Aucun utilisateur n'a le droit d'accéder au chat</h3>
                    </c:otherwise>
                </c:choose>

                <a href="/tpAjax/test/back-officeRest/">Retour à l'accueil du back office</a>
            </c:when>
            <c:when test="${requete == 'POST'}">

                <c:choose>
                    <c:when test="${user == 'dejaPresentDansLaListe'}">
                        <h3>L'utilisateur est déjà dans la liste</h3>
                    </c:when>
                    <c:otherwise>
                        <h3>L'utilisateur ${user} a bien été ajouté à la liste</h3>
                    </c:otherwise>
                </c:choose>

                <a href="/tpAjax/test/back-officeRest/users/list">Voir la liste des utilisateurs</a>
                <br>
                <a href="/tpAjax/test/back-officeRest/">Retour à l'accueil du back office</a>
                <br>
                <a href="Deco">Déconnexion</a>

            </c:when>
        </c:choose>

    </div>

</body>
</html>
