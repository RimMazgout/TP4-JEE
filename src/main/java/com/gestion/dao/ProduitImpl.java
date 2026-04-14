package com.gestion.dao;

import com.gestion.model.Produit;
import java.util.ArrayList;
import java.util.List;

public class ProduitImpl implements ProduitDAO {

    // ============================================
    //   STOCKAGE EN MÉMOIRE (ArrayList statique)
    // ============================================
    private static List<Produit> listeProduits = new ArrayList<>();
    private static int compteurId = 1;

    // Données de test préchargées au démarrage
    static {
        listeProduits.add(new Produit(compteurId++, "Laptop Dell",
                "Ordinateur portable 15 pouces", 8500.00));
        listeProduits.add(new Produit(compteurId++, "Souris Logitech",
                "Souris sans fil ergonomique", 250.00));
        listeProduits.add(new Produit(compteurId++, "Clavier Mécanique",
                "Clavier RGB switches bleus", 450.00));
    }

    // ============================================
    //   CREATE — Ajouter un produit
    // ============================================
    @Override
    public void addProduit(Produit produit) {
        produit.setIdProduit(compteurId++);
        listeProduits.add(produit);
    }

    // ============================================
    //   READ ALL — Récupérer tous les produits
    // ============================================
    @Override
    public List<Produit> getAllProduits() {
        return listeProduits;
    }

    // ============================================
    //   READ ONE — Récupérer un produit par ID
    // ============================================
    @Override
    public Produit getProduitById(int id) {
        for (Produit p : listeProduits) {
            if (p.getIdProduit() == id) {
                return p;
            }
        }
        return null;
    }

    // ============================================
    //   UPDATE — Modifier un produit existant
    // ============================================
    @Override
    public void updateProduit(Produit produit) {
        for (int i = 0; i < listeProduits.size(); i++) {
            if (listeProduits.get(i).getIdProduit() == produit.getIdProduit()) {
                listeProduits.set(i, produit);
                break;
            }
        }
    }

    // ============================================
    //   DELETE — Supprimer un produit par ID
    // ============================================
    @Override
    public void deleteProduit(int id) {
        listeProduits.removeIf(p -> p.getIdProduit() == id);
    }
}