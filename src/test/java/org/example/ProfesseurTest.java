package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfesseurTest {

    @Test
    void noter() {
        Apogee a = new Apogee();
        a.connexionUtilisateur("Admin");
        Administration utilisateurCourant = (Administration) a.getUserCourant();
        utilisateurCourant.créerCompte("prof1", "Professeur");

        utilisateurCourant.créerCompte("eleve1", "Etudiant");
        utilisateurCourant.créerCompte("eleve2", "Etudiant");
        utilisateurCourant.créerCompte("eleve3", "Etudiant");
        utilisateurCourant.créerCompte("eleve4", "Etudiant");

    }

    @Test
    void consulterMat() {
    }

    @Test
    void consulterEtu() {
    }
}