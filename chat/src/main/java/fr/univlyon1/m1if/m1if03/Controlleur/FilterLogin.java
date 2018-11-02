package fr.univlyon1.m1if.m1if03.Controlleur;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterLogin")
public class FilterLogin implements Filter {

    public FilterLogin() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        String username = (String) httpServletRequest.getSession().getAttribute("username");
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

    public void init(FilterConfig config) throws ServletException {

    }

}