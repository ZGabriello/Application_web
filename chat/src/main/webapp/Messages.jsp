<%@ page import="fr.univlyon1.m1if.m1if03.Message,java.io.PrintWriter,javax.servlet.http.*,javax.servlet.*,java.util.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Elo
  Date: 28/10/2018
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    public List<Message> messages = new ArrayList<Message>();

    void addMessage(String message, String author) {

        if (author != null) {
            messages.add(new Message(author,message));
        }
    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    if (request.getMethod().equals("POST")) {
        if((String)request.getAttribute("message") != null) {
            addMessage((String) request.getAttribute("message"), (String) session.getAttribute("pseudo"));
        }
    }

    String texte = (String)request.getParameter("message" );
    String auteur = (String)session.getAttribute("pseudo") ;

    if (texte != null) {

        Message message = new Message(auteur, texte);
        messages.add(message);
    }
%>
<table>
    <%
    for (Message msg : messages) {
        %>
            <tr><td><%= msg.getPseudo() %> : <%= msg.getTexte() %> </td></tr>
        <%
    } %>
</table>
</body>
</html>
