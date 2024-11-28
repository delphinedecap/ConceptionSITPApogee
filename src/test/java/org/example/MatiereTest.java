package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MatiereTest {

    @Test
    void consulterEtu() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Etudiant e1 = new Etudiant("Etudiant1");
        Etudiant e2 = new Etudiant("Etudiant2");

        Professeur p = new Professeur("Professeur");

        Matiere m = new Matiere(001, "Matiere1", p);
        m.notes.put(e1, -1);
        m.notes.put(e2, 15);

        m.consulterEtu();

        System.setOut(originalOut);
        String expectedOutput ="Les étudiants de la matière sont : " + System.lineSeparator() + "Etudiant2" + System.lineSeparator() + "Etudiant1" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void noter() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Etudiant e1 = new Etudiant("Etudiant1");
        Etudiant e2 = new Etudiant("Etudiant2");

        Professeur p = new Professeur("Professeur");

        Matiere m = new Matiere(001, "Matiere1", p);
        m.notes.put(e1, -1);
        m.notes.put(e2, 15);

        m.noter(e1, 17);
        assertEquals(17, m.notes.get(e1), 0.01);
        System.setOut(originalOut);
        String expectedOutput ="Note mise à jour" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void noterInvalide(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Etudiant e1 = new Etudiant("Etudiant1");

        Professeur p = new Professeur("Professeur");

        Matiere m = new Matiere(001, "Matiere1", p);
        m.notes.put(e1, -1);

        m.noter(e1, -2);
        System.setOut(originalOut);
        String expectedOutput ="Note invalide" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testNoterErreur(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Etudiant e1 = new Etudiant("Etudiant1");
        Etudiant e2 = new Etudiant("Etudiant2");

        Professeur p = new Professeur("Professeur");

        Matiere m = new Matiere(001, "Matiere1", p);
        m.notes.put(e1, -1);
        m.notes.put(e2, 15);
        Etudiant e3 = new Etudiant("Etudiant3");
        m.noter(e3, 14);
        System.setOut(originalOut);
        String expectedOutput ="Etudiant pas dans ce cours" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void getEtu() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Etudiant e1 = new Etudiant("Etudiant1");
        Etudiant e2 = new Etudiant("Etudiant2");
        Etudiant e3 = new Etudiant("Etudiant3");

        Professeur p = new Professeur("Professeur");

        Matiere m = new Matiere(001, "Matiere1", p);
        m.notes.put(e1, -1);
        m.notes.put(e2, 15);

        assertEquals(e1, m.getEtu("Etudiant1"));
        assertEquals(e2, m.getEtu("Etudiant2"));
        assertNull(m.getEtu("Etudiant3"));
    }
}