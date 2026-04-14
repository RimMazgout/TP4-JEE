package com.gestion.model;

public class Produit {

    // ============================================
    //              ATTRIBUTS
    // ============================================
    private int idProduit;
    private String nom;
    private String description;
    private double prix;

    // ============================================
    //         CONSTRUCTEUR VIDE
    // ============================================
    public Produit() {
    }

    // ============================================
    //         CONSTRUCTEUR AVEC PARAMÈTRES
    // ============================================
    public Produit(int idProduit, String nom, String description, double prix) {
        this.idProduit   = idProduit;
        this.nom         = nom;
        this.description = description;
        this.prix        = prix;
    }

    // ============================================
    //              GETTERS & SETTERS
    // ============================================

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // ============================================
    //              toString()
    // ============================================
    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", nom='"         + nom         + '\'' +
                ", description='" + description + '\'' +
                ", prix="         + prix        +
                '}';
    }
}