package org.example;

import java.util.HashMap;
import java.util.Objects;

public class Matiere {
    public int idMat;
    public String nomMat;
    public HashMap<Etudiant, Integer> notes = new HashMap();
    public Professeur prof;

    public Matiere(int id, String nomMat, Professeur prof){
        this.idMat = id;
        this.nomMat = nomMat;
        this.prof = prof;
        prof.mat.add(this);
    }

    public void consulterEtu(){
        System.out.println("Les étudiants de la matière sont : ");
        for (Etudiant e : this.notes.keySet()){
            System.out.println(e.getUserName());
        }
    }

    public void noter(Etudiant etu, int note){
        if (notes.containsKey(etu)){
            if (note>20 || note<0){
                System.out.println("Note invalide");
            } else {
                notes.put(etu, note);
                System.out.println("Note mise à jour");
            }
        }
        else {
            System.out.println("Etudiant pas dans ce cours");
        }
    }

    public Etudiant getEtu(String Nom){
        for (Etudiant etu : notes.keySet()){
            if (Objects.equals(etu.user_name, Nom)) {
                return etu;
            }
        }
        return null;
    }
}
