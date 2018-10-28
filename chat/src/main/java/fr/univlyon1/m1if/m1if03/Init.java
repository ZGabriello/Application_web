package fr.univlyon1.m1if.m1if03;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Init")
public class Init extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        /*response.setContentType("text/html");

        response.setCharacterEncoding( "UTF-8" );

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");

        out.println("<html>");

        out.println("<head>");

        out.println("<meta charset=\"utf-8\" />");

        out.println("<title>Test</title>");

        out.println("</head>");

        out.println("<body>");

        out.println("<p>Ceci est une page générée depuis une servlet.</p>");

        out.println("</body>");

        out.println("</html>");*/

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
