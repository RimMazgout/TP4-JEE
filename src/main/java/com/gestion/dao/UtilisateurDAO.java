package com.gestion.dao;

import com.gestion.model.Utilisateur;

public interface UtilisateurDAO {
    Utilisateur findByLoginAndPassword(String login, String motDePasse);
}