<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="users" class="fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean" scope="request"/>

<%--
  Created by IntelliJ IDEA.
  User: Elo
  Date: 11/11/2018
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
    users.addUser((String) request.getParameter("pseudo"));
%>
</body>
</html>

