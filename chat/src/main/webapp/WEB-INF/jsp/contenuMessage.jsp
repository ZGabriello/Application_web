<%@ page import="fr.univlyon1.m1if.m1if03.tp2.Modele.Message" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lionel
  Date: 06/11/2018
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="style.css" rel="stylesheet" media="all" type="text/css">
<html>
<head>
    <title>Message</title>
</head>
<body>
<h1>Le contenu du message numéro <%= request.getParameter("num")%> pour le salon <%= request.getParameter("name")%> : </h1>
<%!  private String texte;%>
<%  texte = (String)request.getAttribute("message");
    if (!texte.isEmpty()) {
        out.println(texte + "<br/>");
    } else {
        out.println("Le message n'existe pas" + "<br/>");
    }

%>
</body>
</html>
