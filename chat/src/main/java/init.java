package fr.univlyon1.m1if.m1if03;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class init extends HttpServlet {
    public void init( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException, IOException {

        response.setContentType("text/html");

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

        out.println("</html>");

    }
}
