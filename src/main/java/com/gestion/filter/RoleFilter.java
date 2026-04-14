package com.gestion.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest  req  = (HttpServletRequest)  request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        String role = (session != null) ? 
                      (String) session.getAttribute("role") : null;

        String uri = req.getRequestURI();

        // Actions réservées à l'ADMIN uniquement
        boolean estActionAdmin = uri.contains("/addProduit")
                              || uri.contains("/deleteProduit")
                              || uri.contains("/editProduit")
                              || uri.contains("/updateProduit");

        if (estActionAdmin && !"ADMIN".equals(role)) {
            // Pas le bon rôle → page 403
            resp.sendRedirect(req.getContextPath() + "/error403.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}
}