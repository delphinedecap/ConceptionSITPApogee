package org.example;

import java.util.HashMap;

public class Matiere {
    public int idMat;
    public HashMap<Etudiant, Integer> notes = new HashMap();
    public Professeur prof;

    public Matiere(int id, Professeur prof){
        this.idMat = id;
        this.prof = prof;
    }

    public void consulterEtu(){
        System.out.println(notes);
    }
}
