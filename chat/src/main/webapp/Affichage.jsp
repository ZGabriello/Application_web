<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.univlyon1.m1if.m1if03.Modele.Message" %>
<%@ page import="fr.univlyon1.m1if.m1if03.Modele.Salon" %>
<%@ page import="static javax.servlet.http.HttpServletResponse.SC_FOUND" %>
<%@ page import="static javax.servlet.http.HttpServletResponse.SC_NOT_MODIFIED" %>
<jsp:useBean id="messages" class="fr.univlyon1.m1if.m1if03.Modele.GestionMessages" scope="session"/>
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
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="css/interface.css"/>
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
   /* if (cookie == null) {
        cookie = new Cookie("messageNumber", Integer.toString(messages.getMessageNumber(salon)));
        response.addCookie(cookie);
    }*/
    Cookie messageNumber = new Cookie("messageNumber", Integer.toString(messages.getMessagesList((String)session.getAttribute("salon")).size()));
    response.addCookie( messageNumber );


    out.println("<div class='message-status'>" +
            "Bonjour " +
            "<span class='username'>" + username + "</span>" +
            ", vous êtes sur le salon " + "<span class='salon'>" + salon + "</span>"  +
            "</div>");
    out.println("<div class='messages-wrapper'>");

    for (Message m : messages.getMessagesList((String)session.getAttribute("salon"))) {
        out.println(m.toString() + "<br/>");
    }

    if (messages.getMessagesList(salon) != null) {

        if (messages.getMessageNumber(salon) != 0) {
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                if (Integer.parseInt(cookie.getValue()) == messages.getMessageNumber(salon)) {
                    //response.setStatus(SC_NOT_MODIFIED); //breaks auto-refresh
                }
            }
            cookie.setValue(Integer.toString(messages.getMessageNumber(salon)));
            response.addCookie(cookie);
        }
    }



%>
</body>
</html>
