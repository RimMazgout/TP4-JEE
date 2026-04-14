package com.gestion.dao;

import com.gestion.model.Produit;
import java.util.List;

public interface ProduitDAO {

    // Ajouter un nouveau produit
    void addProduit(Produit produit);

    // Récupérer tous les produits
    List<Produit> getAllProduits();

    // Récupérer un produit par son ID
    Produit getProduitById(int id);

    // Mettre à jour un produit existant
    void updateProduit(Produit produit);

    // Supprimer un produit par son ID
    void deleteProduit(int id);
}