package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ProfesseurTest {

    @Test
    void noter() {
        Etudiant e1 = new Etudiant("Etudiant1");
        Professeur p = new Professeur("Professeur1");
        Matiere m = new Matiere(001, "Matiere1", p);

        m.notes.put(e1, -1);

        p.noter(e1, m, 12);
        assertEquals(12, m.notes.get(e1));
    }

    @Test
    void consulterMat() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Professeur p = new Professeur("Professeur1");
        Matiere m = new Matiere(001, "Matiere1", p);
        Matiere m2 = new Matiere(002, "Matiere2", p);

        p.consulterMat();
        System.setOut(originalOut);
        String expectedOutput ="Vos matières sont : " + System.lineSeparator() + "Matiere1 " + System.lineSeparator() + "Matiere2 " + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void consulterEtu() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Professeur p = new Professeur("Professeur1");
        Matiere m = new Matiere(001, "Matiere1", p);
        Etudiant e1 = new Etudiant("Etudiant1");
        Etudiant e2 = new Etudiant("Etudiant2");
        m.notes.put(e1, -1);
        m.notes.put(e2, -1);

        p.consulterEtu(m);
        System.setOut(originalOut);
        String expectedOutput ="Les étudiants de la matière sont : " + System.lineSeparator() + "Etudiant1" + System.lineSeparator() +"Etudiant2" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void getMAt() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Professeur p = new Professeur("Professeur1");

        Matiere m = new Matiere(001, "Matiere1", p);
        Matiere m2 = new Matiere(002, "Matiere2", p);

        assertEquals(m2, p.getMAt("Matiere2"));

        assertNull(p.getMAt("Matiere3"));
    }
}