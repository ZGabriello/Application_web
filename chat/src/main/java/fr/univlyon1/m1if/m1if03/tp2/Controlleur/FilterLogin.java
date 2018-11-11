package fr.univlyon1.m1if.m1if03.tp2.Controlleur;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterLogin")
public class FilterLogin implements Filter {

    protected FilterConfig filterConfig;
    java.util.List revokeList;

    public FilterLogin() {
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
    }

}
