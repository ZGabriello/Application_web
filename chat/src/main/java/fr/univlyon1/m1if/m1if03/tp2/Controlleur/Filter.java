package fr.univlyon1.m1if.m1if03.tp2.Controlleur;

import fr.univlyon1.m1if.m1if03.tp3.beans.GestionUsersBean;
import fr.univlyon1.m1if.m1if03.tp3.beans.UserBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig config) {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {

        if (((HttpServletRequest) req).getMethod().equals("POST")) {
            if (req.getParameter("pseudo") != null && req.getParameter("salon") != null && !req.getParameter("pseudo").equals("") && !req.getParameter("salon").equals("")) {
                if (GestionUsersBean.getUsersList().contains(new UserBean(req.getParameter("pseudo")))) // vérification si l'utilisateur est dans la liste
                {
                    HttpSession session = ((HttpServletRequest) req).getSession();

                    session.setAttribute("pseudo", req.getParameter("pseudo"));
                    session.setAttribute("salon", req.getParameter("salon"));

                    filterChain.doFilter(req, res);
                    return;
                }
            }
            /*else if (req.getParameter("login2") != null && !req.getParameter("login2").equals("")) {
                if (GestionUtilisateur.getUsers().contains(new Utilisateur(req.getParameter("login2")))) {
                    HttpSession session = ((HttpServletRequest) req).getSession();

                    session.setAttribute("login", req.getParameter("login2"));
                    filterChain.doFilter(req, res);
                    return;
                }
            }*/
        } else if (((HttpServletRequest) req).getSession().getAttribute("pseudo") != null) {
                filterChain.doFilter(req, res);
                return;
            }

            ((HttpServletResponse) res).sendRedirect("index.html");
        }
    /*protected FilterConfig filterConfig;
    java.util.List revokeList;

    public Filter() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        String username = (String) httpServletRequest.getParameter("pseudo");
        if (username == null || username.trim().isEmpty()) {
            httpServletResponse.sendRedirect("/");
        }
        else if (httpServletResponse.getStatus() == 500) {
            httpServletResponse.sendRedirect("/");
        }
        else {
            chain.doFilter(req, resp);
            return;
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }*/

}

