<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Elo
  Date: 11/11/2018
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="style.css" rel="stylesheet" media="all" type="text/css">
<html>
<head>
    <title>Utilisateur ajouté</title>
</head>
<body>
<h1>Liste des utilisateurs </h1>
<%!  private ArrayList<String> list;%>
<%  list = (ArrayList<String>)request.getAttribute("newUser");
    for (String u : list ) {
        out.println(u + "<br/>");
    }
%>
</body>
</html>
