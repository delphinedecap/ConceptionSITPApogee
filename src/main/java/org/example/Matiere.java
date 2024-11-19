package org.example;

import java.util.HashMap;

public class Matiere {
    public int idMat;
    public String nomMat;
    public HashMap<Etudiant, Integer> notes = new HashMap();
    public Professeur prof;

    public Matiere(int id, String nomMat, Professeur prof){
        this.idMat = id;
        this.nomMat = nomMat;
        this.prof = prof;
    }

    public void consulterEtu(){
        System.out.println(notes);
    }

    public void noter(Etudiant etu, int note){
        if (notes.containsKey(etu)){
            notes.put(etu, note);
            System.out.println("Note mise à jour");
        }
        else {
            System.out.println("Etudiant pas dans ce cours");
        }
    }
}
