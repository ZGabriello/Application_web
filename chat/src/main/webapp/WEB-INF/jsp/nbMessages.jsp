<%--
  Created by IntelliJ IDEA.
  User: Elo
  Date: 19/11/2018
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="style.css" rel="stylesheet" media="all" type="text/css">
<html>
<head>
    <title>Nombre de messages</title>
</head>
<body>
<h1>Nombre de messages pour le salon <%= request.getParameter("name")%></h1>
<%!  private Integer nb;%>
<%  nb = (Integer)request.getAttribute("nombre");
    out.println(nb.toString());

%>
</body>
</html>
