package com.gestion.web;

import com.gestion.metier.ProduitMetier;
import com.gestion.metier.ProduitMetierImpl;
import com.gestion.model.Produit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddProduitServlet extends HttpServlet {

    private ProduitMetier produitMetier = new ProduitMetierImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nom         = request.getParameter("nom");
        String description = request.getParameter("description");
        double prix        = Double.parseDouble(request.getParameter("prix"));

        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setDescription(description);
        produit.setPrix(prix);

        produitMetier.addProduit(produit);

        response.sendRedirect(request.getContextPath() + "/produits");
    }
}