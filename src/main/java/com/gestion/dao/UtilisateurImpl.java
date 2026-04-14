package com.gestion.dao;

import com.gestion.model.Utilisateur;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurImpl implements UtilisateurDAO {

    // Stockage en mémoire des utilisateurs
    private static List<Utilisateur> utilisateurs = new ArrayList<>();

    static {
        utilisateurs.add(new Utilisateur(1, "admin", "admin123", "ADMIN"));
        utilisateurs.add(new Utilisateur(2, "user",  "user123",  "USER"));
    }

    @Override
    public Utilisateur findByLoginAndPassword(String login, String motDePasse) {
        for (Utilisateur u : utilisateurs) {
            if (u.getLogin().equals(login) && 
                u.getMotDePasse().equals(motDePasse)) {
                return u;
            }
        }
        return null;
    }
}