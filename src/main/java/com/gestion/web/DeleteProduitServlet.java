package com.gestion.web;

import com.gestion.metier.ProduitMetier;
import com.gestion.metier.ProduitMetierImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteProduitServlet extends HttpServlet {

    private ProduitMetier produitMetier = new ProduitMetierImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        produitMetier.deleteProduit(id);
        response.sendRedirect(request.getContextPath() + "/produits");
    }
}