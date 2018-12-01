<%@ page import="fr.univlyon1.m1if.m1if03.tp2.Modele.Message" %>
<%@ page import="java.util.ArrayList" %>
<%--
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
    <title>Liste des messages</title>
</head>
<body>
<h1>Liste des messages pour le salon <%= request.getParameter("salon")%></h1>
<%!  private ArrayList<Message> list;%>
<%  list = (ArrayList<Message>)request.getAttribute("messages");
    for (Message m : list ) {
        out.println(m.toString() + "<br/>");
    }
%>
</body>
</html>
