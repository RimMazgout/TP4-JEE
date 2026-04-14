package com.gestion.metier;

import com.gestion.model.Produit;
import java.util.List;

public interface ProduitMetier {
    void addProduit(Produit produit);
    List<Produit> getAllProduits();
    Produit getProduitById(int id);
    void updateProduit(Produit produit);
    void deleteProduit(int id);
}