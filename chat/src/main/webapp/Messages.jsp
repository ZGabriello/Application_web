<%@ page import="fr.univlyon1.m1if.m1if03.Message,java.io.PrintWriter,javax.servlet.http.*,javax.servlet.*,java.util.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elo
  Date: 28/10/2018
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    List<Message> messages = new List<Message>();

    //HttpSession session = request.getSession(true);

    String texte = (String)request.getParameter("message" );
    String auteur = (String)session.getAttribute("pseudo") ;

    Message message = new Message(auteur, texte);
    messages.add(message);
%>
<c:forEach var="message" items="${messages}">
    <p>Auteur :  <%= message.getPseudo() %></p>
    <p>Message :  <%= message.getTexte %></p> <br>
</c:forEach>
</body>
</html>
