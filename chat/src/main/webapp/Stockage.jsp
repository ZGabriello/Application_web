<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="fr.univlyon1.m1if.m1if03.tp2.Modele.Message" %>
<jsp:useBean id="messages" class="fr.univlyon1.m1if.m1if03.tp2.Modele.GestionMessages" scope="session"/>

<%--
  Created by IntelliJ IDEA.
  User: Elo
  Date: 28/10/2018
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% messages.setMessage(new Message((String) session.getAttribute("pseudo"), (String) request.getParameter("message")), (String)session.getAttribute("salon"));%>
    </body>
</html>
