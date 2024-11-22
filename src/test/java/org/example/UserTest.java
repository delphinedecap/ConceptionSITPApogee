package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void seConnecter() {
        User u = new Etudiant("Anaïs");
        assertFalse(u.connected, "Initialisation de l'état : disfonctionnel");
        u.seConnecter();
        assertTrue(u.connected, "Connexion du user : disfonctionnel");
        u.seConnecter();
        assertTrue(u.connected, "Connexion du user 2: disfonctionnel");
    }

    @Test
    void seDeconnecter() {
        User u = new Etudiant("Anaïs");
        u.seConnecter();
        assertTrue(u.connected, "Connexion du user : disfonctionnel");
        u.seDeconnecter();
        assertFalse(u.connected, "Déconnexion du user: disfonctionnel");
        u.seDeconnecter();
        assertFalse(u.connected, "Déconnexion du user 2: disfonctionnel");
    }

    @Test
    void getUserName() {
        Professeur p = new Professeur("Gouteux");
        Etudiant e = new Etudiant("Anaïs");
        String nom = null ;
        nom = getUserName(p);
        assertEquals("Gouteux", nom,"Récupération des userNames - déféctueuse");
        nom = getUserName(e);
        assertEquals("Anaïs", nom,"Récupération des userNames - déféctueuse");
    }

    @Test
    void afficherMenu() {
    }
}