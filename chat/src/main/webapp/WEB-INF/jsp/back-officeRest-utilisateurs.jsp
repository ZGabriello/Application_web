<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <link type="text/css" rel="stylesheet" href="../style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="chat" style="width: 500px;padding: 30px;margin: 40px auto;background: #FFF;border-radius: 10px;-webkit-border-radius: 10px;-moz-border-radius: 10px;box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.13);-moz-box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.13);-webkit-box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.13);">
            <c:choose>
                <c:when test="${requete == 'GET'}">

                    <c:choose>
                        <c:when test="${not empty listeUtilisateurs}"> 
                            <h1>Utilisateurs pouvant accéder au chat: </h1>

                            <c:forEach items="${listeUtilisateurs}" var="user">
                                <h3> - ${user.nom} </h3>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <h1>Aucun utilisateur n'a le droit d'accéder au chat</h1>
                        </c:otherwise>
                    </c:choose>

                    <a href="/tpRest/test/back-officeRest/">Retour à l'accueil du back office</a>
                </c:when>
                 <c:when test="${requete == 'POST'}">

                     <c:choose>
                         <c:when test="${user == 'dejaPresentDansLaListe'}">
                            <h1>L'utilisateur est déjà dans la liste</h1>
                        </c:when>
                        <c:otherwise>
                            <h1>L'utilisateur ${user} a bien été ajouté à la liste</h1>
                        </c:otherwise>
                     </c:choose>

                    <a href="/tpRest/test/back-officeRest/users">Voir la liste des utilisateurs</a>
                    <br>
                    <a href="/tpRest/test/back-officeRest/">Retour à l'accueil du back office</a>

                </c:when>
            </c:choose>

        </div>

       
    </body>
</html>