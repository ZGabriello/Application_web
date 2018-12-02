<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="../style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>Back-office</title>

        <script type="text/javascript">
            function buttonClick() {
                var url = "/tpRest/test/back-officeRest/messages/";

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
        <div class="chat" style="width: 500px;padding: 30px;margin: 40px auto;background: #FFF;border-radius: 10px;">
            
            <h1>Back office</h1>

            <div class="section">Récupérer la liste des messages du salon</div>
            
            <c:choose>
                <c:when test="${not empty salons}">
                    
                    <div class="inner-wrap">
                        <label>Salon</label>
                        <select id="salon">
                            <c:forEach items="${salons}" var="lobby">
                                Try: <option value="${lobby}">${lobby}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="inner-wrap">                        
                        <label>Message numéro (si pas rempli, donne tous les messages)</label>
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
                    

            <div class="section"><a href="addUser.html">Ajouter un utilisateur</a></div>
            <form method="POST" action="/tpRest/test/back-officeRest/users/add">
                <div class="inner-wrap">
                    <a href="/tpRest/test/back-officeRest/users">Voir la liste des utilisateurs</a>
                </div>
            </form>
            
            
            <div>
                <a href="/tpRest/">Aller à l'accueil du chat</a>
            </div>
            
        </div>

    </body>
</html>
