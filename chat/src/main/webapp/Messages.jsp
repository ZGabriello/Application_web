<%@ page import="fr.univlyon1.m1if.m1if03.Message,java.io.PrintWriter,javax.servlet.http.*,javax.servlet.*,java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.univlyon1.m1if.m1if03.Salon" %><%--
  Created by IntelliJ IDEA.
  User: Elo
  Date: 28/10/2018
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<META HTTP-EQUIV=Refresh CONTENT="5">
<%!
    public Salon salon;

    public List<Message> messages = new ArrayList<Message>();;

    void addMessage(String message, String author) {

        if (author != null) {
            messages.add(new Message(author,message));
        }
    }

    void addListToSalon(Salon salon, List<Message> liste) {
        salon.setMessages(liste);
    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if ((String) session.getAttribute("salon") != null) {


        salon = new Salon((String) session.getAttribute("salon"), messages);

        //si on a une requête POST on ajoute un message à la liste
        if (request.getMethod().equals("POST")) {
            if ((String) request.getParameter("message") != null) {
                addMessage((String) request.getParameter("message"), (String) session.getAttribute("pseudo"));
                salon.setMessages(messages);
            }
        }
    }
//Affichage des messages
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
