package fr.univlyon1.m1if.m1if03.tp2.Controlleur;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Init extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {

        super.init(config);

    }

    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        //redirection
        res.sendRedirect("index.html");

        pw.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        try {
            // Recupere la session
            HttpSession session = request.getSession(true);

            // Ecrit la reponse
            PrintWriter out = response.getWriter();

            //on récupère le pseudo envoyé par la requete POST
            String pseudo = request.getParameter("pseudo");
            String salon = request.getParameter("salon");


            //on ajoute l'attribut pseudo et sa valeur à la session actuelle
            session.setAttribute("pseudo", pseudo);
            session.setAttribute("salon", salon);
            response.sendRedirect("interface.html");
            //this.getServletContext().getRequestDispatcher( "/interface.html" ).forward( request, response );

        } catch (Exception e) {
            response.sendRedirect("index.html");
        }

    }
}
