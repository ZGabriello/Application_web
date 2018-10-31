package fr.univlyon1.m1if.m1if03;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Init")
public class Init extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {

        super.init(config);

    }

    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

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

            String pseudo = request.getParameter("pseudo");

            session.setAttribute("pseudo", pseudo);
            response.sendRedirect("interface.html");
        } catch (Exception e) {
            response.sendRedirect("index.html");
        }

    }
}
