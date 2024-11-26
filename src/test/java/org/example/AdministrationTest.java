package org.example;

import static org.junit.jupiter.api.Assertions.*;

class AdministrationTest {

    @org.junit.jupiter.api.Test
    void créerCompte() {
        Apogee apogee = new Apogee();
        Administration admin = new Administration("admin", apogee);
        admin.créerCompte("Guillaume", "Professeur");
        admin.créerCompte("Tom", "Etudiant");
        admin.créerCompte("Julie", "Administration");
        assertNotNull(apogee.getUser("Guillaume"));
        assertTrue(apogee.getUser("Guillaume") instanceof Professeur);

        assertNotNull(apogee.getUser("Tom"));
        assertTrue(apogee.getUser("Tom") instanceof Etudiant);

        assertNotNull(apogee.getUser("Julie"));
        assertTrue(apogee.getUser("Julie") instanceof Administration);
    }

    @org.junit.jupiter.api.Test
    void inscriptionProfMatiere() {
        Apogee apogee = new Apogee();
        Administration admin = new Administration("admin", apogee);
        admin.créerCompte("prof1", "Professeur");
        admin.créerCompte("prof2", "Professeur");

        admin.creerMatiere(1, "matiere1", "prof1");

        Professeur p = (Professeur) apogee.getUser("prof2");
        Matiere m = apogee.getMatiere(1);

        admin.inscriptionProfMatiere(1, p);

        assertEquals(m.prof, p);
        assertEquals(p.mat.get(0), m);
    }

    @org.junit.jupiter.api.Test
    void suppressionProfMatiere() {
        Apogee apogee = new Apogee();
        Administration admin = new Administration("admin", apogee);
        admin.créerCompte("prof1", "Professeur");

        admin.creerMatiere(1, "matiere1", "prof1");

        Professeur p = (Professeur) apogee.getUser("prof1");
        Matiere m = apogee.getMatiere(1);

        admin.suppressionProfMatiere(1, p);
        assertNull(m.prof);
        assertTrue(p.mat.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void creerMatiere(){
        Apogee apogee = new Apogee();
        Administration admin = new Administration("admin", apogee);
        admin.créerCompte("prof", "Professeur");
        admin.creerMatiere(1, "Matiere1", "prof");
        assertNotNull(apogee.getMatiere(1));
        assertEquals(apogee.getMatiere(1).nomMat, "Matiere1");
        assertEquals(apogee.getMatiere(1).prof.user_name, "prof");
    }

    @org.junit.jupiter.api.Test
    void inscriptionEleveMatiere(){
        Apogee apogee = new Apogee();
        Administration admin = new Administration("admin", apogee);
        admin.créerCompte("prof1", "Professeur");
        admin.creerMatiere(1, "matiere1", "prof1");
        admin.créerCompte("etu1", "Etudiant");

        Professeur p = (Professeur) apogee.getUser("prof1");
        Matiere m = apogee.getMatiere(1);
        Etudiant e = (Etudiant) apogee.getUser("etu1");

        admin.inscriptionEleveMatiere(1, e);

        assertNotNull(m.notes.get(e));
        assertTrue(e.mat.contains(m));
    }

    @org.junit.jupiter.api.Test
    void suppressionEleveMatiere(){
        Apogee apogee = new Apogee();
        Administration admin = new Administration("admin", apogee);
        admin.créerCompte("prof1", "Professeur");
        admin.creerMatiere(1, "matiere1", "prof1");
        admin.créerCompte("etu1", "Etudiant");

        Professeur p = (Professeur) apogee.getUser("prof1");
        Matiere m = apogee.getMatiere(1);
        Etudiant e = (Etudiant) apogee.getUser("etu1");

        admin.inscriptionEleveMatiere(1, e);

        admin.suppressionEleveMatiere(e, 1);

        assertNull(m.notes.get(e));
        assertFalse(e.mat.contains(m));
    }
}