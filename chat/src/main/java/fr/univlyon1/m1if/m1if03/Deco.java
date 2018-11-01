package fr.univlyon1.m1if.m1if03;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/Deco")
public class Deco extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {

        super.init(config);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        HttpSession session = req.getSession(true);

        session.invalidate();

        res.sendRedirect("index.html");
        pw.close();
    }



}
