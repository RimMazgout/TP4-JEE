package com.gestion.web;

import com.gestion.dao.UtilisateurDAO;
import com.gestion.dao.UtilisateurImpl;
import com.gestion.model.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UtilisateurDAO utilisateurDAO = new UtilisateurImpl();

    // Afficher la page de login
    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp")
               .forward(request, response);
    }

    // Traiter le formulaire de login
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String login      = request.getParameter("login");
        String motDePasse = request.getParameter("motDePasse");

        Utilisateur utilisateur = 
            utilisateurDAO.findByLoginAndPassword(login, motDePasse);

        if (utilisateur != null) {
            // Créer la session et stocker l'utilisateur
            HttpSession session = request.getSession();
            session.setAttribute("utilisateurConnecte", utilisateur);
            session.setAttribute("role", utilisateur.getRole());

            // Rediriger vers la liste des produits
            response.sendRedirect(
                request.getContextPath() + "/produits");
        } else {
            // Mauvais identifiants → retour login avec message
            request.setAttribute("erreurLogin", 
                "Login ou mot de passe incorrect !");
            request.getRequestDispatcher("/login.jsp")
                   .forward(request, response);
        }
    }
}