<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
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
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta http-equiv="refresh" content="5;url=messages" />
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="css/interface.css"/>
    <link href="style.css" rel="stylesheet" media="all" type="text/css">
</head>
<body class="frame-body">
<%
    response.setHeader("Cache-Control", "public");
    response.setHeader("Pragma", "Pragma");
    String salon = (String)session.getAttribute("salon");
    String username = (String) session.getAttribute("pseudo");
    Cookie cookie = null;
    Cookie[] cookies = request.getCookies();
    for(int i = 0; i< cookies.length; i++) {
        if (cookies[i].getName().equals("messageNumber")) {
            cookie = cookies[i];
        }
    }

    out.println("<div class='message-status'>" + "<p> "+
            "Bonjour " +
            "<span class='username'>" + username + "</span>" +
            ", vous êtes sur le salon " + "<span class='salon'>" + salon + "</span>" + "</p> " +
            "</div>" + "<br/>");
    out.println("<div class='messages-wrapper'>");

    for (Message msg : messages.getMessagesList()) {
        out.println(msg.toString() + "<br/>");
    }


%>
</body>
</html>
