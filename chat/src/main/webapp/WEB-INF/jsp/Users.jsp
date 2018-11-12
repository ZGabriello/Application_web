<%@ page import="fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean,java.io.PrintWriter,javax.servlet.http.*,javax.servlet.*,java.util.*" %>
<%@ page import="fr.univlyon1.m1if.m1if03.tp3.beans.UserBean" %>

<%--
  Created by IntelliJ IDEA.
  User: Elo
  Date: 11/11/2018
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="users" scope="session" class="fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean" />
<%!  private ArrayList<UserBean> list;%>
<%!  private String pseudo;%>

<%
    pseudo = (String) session.getAttribute("pseudo");
    list = users.getUsersList();

    if (list == null) {
        users.addUser(pseudo);
        list = users.getUsersList();
    }
%>
<%
    if (request.getMethod().equals("POST")) {
%>
<jsp:include page= 'StockageUser.jsp' />
<% }%>

