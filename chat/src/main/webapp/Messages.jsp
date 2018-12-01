<%@ page import="fr.univlyon1.m1if.m1if03.tp2.Modele.Message,java.io.PrintWriter,javax.servlet.http.*,javax.servlet.*,java.util.*" %>
  Created by IntelliJ IDEA.
  User: Elo
  Date: 28/10/2018
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:useBean id="messages" scope="session" class="fr.univlyon1.m1if.m1if03.tp2.Modele.GestionMessages" />
<%!  private List<Message> list;%>
<%!  private String salon;%>

<%
    salon = (String) session.getAttribute("salon");
    list = messages.getMessagesList(salon);

    if (list == null) {
        messages.setSalon(salon);
        list = messages.getMessagesList(salon);
    }
%>
<%
    if (request.getMethod().equals("POST")) {
%>
<jsp:include page= 'Stockage.jsp' />
<% }%>

<jsp:forward page= 'Affichage.jsp' />
