package com.gestion.model;

public class Utilisateur {

    private int idUtilisateur;
    private String login;
    private String motDePasse;
    private String role;

    public Utilisateur() {}

    public Utilisateur(int idUtilisateur, String login,
                       String motDePasse, String role) {
        this.idUtilisateur = idUtilisateur;
        this.login         = login;
        this.motDePasse    = motDePasse;
        this.role          = role;
    }

    public int getIdUtilisateur()          { return idUtilisateur; }
    public void setIdUtilisateur(int id)   { this.idUtilisateur = id; }

    public String getLogin()               { return login; }
    public void setLogin(String login)     { this.login = login; }

    public String getMotDePasse()          { return motDePasse; }
    public void setMotDePasse(String mdp)  { this.motDePasse = mdp; }

    public String getRole()                { return role; }
    public void setRole(String role)       { this.role = role; }
}