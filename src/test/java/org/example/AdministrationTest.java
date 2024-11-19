package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AdministrationTest {

    @Test
    void créerCompte() {
        Apogee apo = new Apogee();
        Administration admin = new Administration("Julie", apo);
        Boolean test = false;
        test = admin.créerCompte("Bilal", "Professeur");
        assertEquals(true, test, "Les créations valides ne marchent pas");
        test = admin.créerCompte("Bilal", "Professeur");
        assertEquals(false, test, "Les créations de doublons ne sont pas pris en compte");
        test = admin.créerCompte("Mathieu", "ettudiant");
        assertEquals(false, test, "Le contrôle des statuts ne marche pas");
    }

    @org.junit.jupiter.api.Test
    void inscriptionProfMatiere() {

    }

    void suppressionProfMatiere(){

    }

    @org.junit.jupiter.api.Test
    void inscriptionElevesMatiere() {
    }

    void suppressionEleveMatiere(){

    }

    void creerMatiere(){

    }
}