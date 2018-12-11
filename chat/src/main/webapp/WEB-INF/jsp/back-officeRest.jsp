<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="../../style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil Back-office</title>

        <script type="text/javascript">
            function buttonClick() {
                var url = "/tpAjax/test/back-officeRest/message/";

                if (document.getElementById("salon").value === "") {
                    return;
                }

                url += document.getElementById("salon").value;

                if (document.getElementById("messageNumber").value !== "") {
                    url += "/" + document.getElementById("messageNumber").value;
                }

                window.location.href = url;
            }
        </script>
    </head>
    <body>

    <h1 style="text-align: center;color: blue;">Chatons.org</h1>
    <hr>
        <div class="chat" style="width: 500px;margin: 40px auto;background: #FFF;border-radius: 10px;text-align: center;">
            
            <h1>Back office</h1>

            <h4>Récupérer la liste des messages du salon : </h4><br>
            
            <c:choose>
                <c:when test="${not empty salons}">
                    
                    <div class="inner-wrap">
                        <label>Salon</label>
                        <select id="salon">
                            <c:forEach items="${salons}" var="salon">
                                Try: <option value="${salon}">${salon}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="inner-wrap">                        
                        <label>Message numéro :</label>
                        <input id="messageNumber" type="number" min='0'/>
                    </div>
                    
                    <div class="button-section">
                        <input type="submit" onclick="buttonClick()"></input>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="inner-wrap">  
                        <label>Aucun salon de chat n'existe</label>
                    </div>
                </c:otherwise>
                </c:choose>
                    
            <br>
            <h4>Ajouter un utilisateur :</h4>
            <form method="POST" action="/tpAjax/test/back-officeRest/users/add">
                <form method="post" action="test/back-officeRest/users/add">
                    <p>
                        pseudo :
                        <input type="text" name="username">
                        <input type="submit" value="Envoyer">
                    </p>
                </form>
                    <a href="/tpAjax/test/back-officeRest/users/list">Voir les utilisateurs ayant l'autorisation</a>

            </form>
            
            <div>
                <a href="/tpAjax/">Aller à l'accueil du chat</a>
            </div>
            
        </div>

    </body>
</html>
