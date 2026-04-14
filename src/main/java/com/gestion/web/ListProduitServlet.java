package com.gestion.web;

import com.gestion.metier.ProduitMetier;
import com.gestion.metier.ProduitMetierImpl;
import com.gestion.model.Produit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListProduitServlet extends HttpServlet {

    private ProduitMetier produitMetier = new ProduitMetierImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Produit> listeProduits = produitMetier.getAllProduits();
        request.setAttribute("listeProduits", listeProduits);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}