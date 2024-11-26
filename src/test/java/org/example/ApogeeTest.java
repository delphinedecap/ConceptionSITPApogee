package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApogeeTest {

    @Test
    void addUser() {
        Apogee apogee = new Apogee();
        User etu = new Etudiant("etu");
        apogee.addUser(etu);
        User prof = new Professeur("prof");
        apogee.addUser(prof);
        assertTrue(apogee.users.contains(etu));
        assertTrue(apogee.users.contains(prof));
    }

    @Test
    void getUser() {
        Apogee apogee = new Apogee();
        User etu = new Etudiant("etu");
        apogee.addUser(etu);
        User prof = new Professeur("prof");
        apogee.addUser(prof);

        assertEquals(etu, apogee.getUser("etu"));
        assertEquals(prof, apogee.getUser("prof"));
    }

    @Test
    void connexionUtilisateur() {
        Apogee apogee = new Apogee();
        User etu = new Etudiant("etu");
        apogee.addUser(etu);

        apogee.connexionUtilisateur("etu");
        assertEquals(apogee.utilisateurCourant, etu);
        assertTrue(etu.connected);
    }

    @Test
    void deconnexionUtilisateur() {
        Apogee apogee = new Apogee();
        User etu = new Etudiant("etu");
        apogee.addUser(etu);

        apogee.connexionUtilisateur("etu");
        apogee.deconnexionUtilisateur();
        assertNull(apogee.utilisateurCourant);
        assertFalse(etu.connected);
    }

    @Test
    void addMatiere() {
        Apogee apogee = new Apogee();
        Professeur prof = new Professeur("prof");
        apogee.addUser(prof);
        apogee.addMatiere(1, "Mat", "prof");
        assertNotNull(apogee.matieres);
        assertEquals(apogee.matieres.get(0).nomMat, "Mat");
    }

    @Test
    void getMatieres() {
        Apogee apogee = new Apogee();
        Professeur prof = new Professeur("prof");
        apogee.addUser(prof);
        apogee.addMatiere(1, "Mat", "prof");
        Matiere m = apogee.getMatiere(1);
        assertNotNull(m);
        assertEquals(m.idMat, 1, 0.1);
        assertEquals(m.nomMat,"Mat");
    }

    @Test
    void getMatiere() {
    }

    @Test
    void getUserCourant() {
    }

    @Test
    void afficherMenu() {
    }

    @Test
    void getResponse() {
    }
}