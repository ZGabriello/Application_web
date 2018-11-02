<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="fr.univlyon1.m1if.m1if03.Message,java.io.PrintWriter,javax.servlet.http.*,javax.servlet.*,java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.univlyon1.m1if.m1if03.Modele.Salon" %>
<%@page import="com.Chat.Modele.Message" %>
<jsp:useBean id="messages" class="fr.univlyon1.m1if.m1if03.Modele.GestionMessages" scope="session">
    <jsp:setProperty name="messages" property="servletContext" value="<%=request.getServletContext()%>"/>
</jsp:useBean>
<%--
  Created by IntelliJ IDEA.
  User: Elo
  Date: 28/10/2018
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>

<%
    String salon = request.getParameter("salon");
    String message = request.getParameter("message");
    String username = (String) session.getAttribute("username");
    if (messages.getMessageList(salon) == null) {
        messages.addSalon(salon);
    }
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        if (message != null || message != "") {
            Message msg = new Message(username, message);
            messages.addMessage(salon, msg);
        }
    }
%>