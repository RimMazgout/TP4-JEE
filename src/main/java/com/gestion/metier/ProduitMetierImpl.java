package com.gestion.metier;

import com.gestion.dao.ProduitDAO;
import com.gestion.dao.ProduitImpl;
import com.gestion.model.Produit;
import java.util.List;

public class ProduitMetierImpl implements ProduitMetier {

    private ProduitDAO produitDAO = new ProduitImpl();

    @Override
    public void addProduit(Produit produit) {
        produitDAO.addProduit(produit);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitDAO.getAllProduits();
    }

    @Override
    public Produit getProduitById(int id) {
        return produitDAO.getProduitById(id);
    }

    @Override
    public void updateProduit(Produit produit) {
        produitDAO.updateProduit(produit);
    }

    @Override
    public void deleteProduit(int id) {
        produitDAO.deleteProduit(id);
    }
}