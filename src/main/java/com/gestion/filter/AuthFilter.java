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

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest  req  = (HttpServletRequest)  request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        boolean estConnecte = (session != null && 
                               session.getAttribute("utilisateurConnecte") != null);

        String uri = req.getRequestURI();

        // Laisser passer : login, logout, ressources statiques
        boolean estPageLibre = uri.contains("/login") 
                            || uri.contains("/logout")
                            || uri.contains(".css")
                            || uri.contains(".js")
                            || uri.contains(".png");

        if (estConnecte || estPageLibre) {
            // Utilisateur connecté ou page libre → on laisse passer
            chain.doFilter(request, response);
        } else {
            // Non connecté → redirection vers login
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {}
}