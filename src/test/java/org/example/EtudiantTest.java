package org.example;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class EtudiantTest {

    @Test
    void consulterMatiere() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Etudiant etu = new Etudiant("Etudiant1");
        Professeur prof = new Professeur("Professeur1");
        Matiere m1 = new Matiere(001, "Matiere1", prof);
        Matiere m2 = new Matiere(002, "Matiere2", prof);
        etu.mat.add(m1);
        etu.mat.add(m2);

        etu.consulterMatiere();
        System.setOut(originalOut);
        String expectedOutput ="Vos matières sont :" + System.lineSeparator() + "Matiere1 " + System.lineSeparator() + "Matiere2 " + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void consulterNotes() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Etudiant etu = new Etudiant("Etudiant1");
        Professeur prof = new Professeur("Professeur1");
        Matiere m1 = new Matiere(001, "Matiere1", prof);
        Matiere m2 = new Matiere(002, "Matiere2", prof);
        etu.mat.add(m1);
        etu.mat.add(m2);

        m1.notes.put(etu, 15);
        m2.notes.put(etu, 18);

        etu.consulterNotes();
        System.setOut(originalOut);
        String expectedOutput ="Vos notes sont : " + System.lineSeparator() + "Matiere1 : 15" + System.lineSeparator() + "Matiere2 : 18" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}