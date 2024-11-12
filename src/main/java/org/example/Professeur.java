package org.example;
import java.util.ArrayList;

public class Professeur extends User{
    private ArrayList<Matiere> mat = new ArrayList();

    public Professeur(String user_name){
        this.user_name = user_name;
    }
    // on suppose qu'on a matière composé d'un dico EtudiantNote
    public void noter(Etudiant etu, Matiere matiere, int note){
        matiere.notes.replace(etu,note);
    }

    public void consulterMat(){
        System.out.println("Vos matières sont : ");
        for(Matiere matiere : mat){
            System.out.println(matiere+" ");
        }
    }

    public void consulterEtu(Matiere mat){
        if (this.mat.contains(mat)) {
            this.mat.consulterEtu();
        }
        else{
            System.out.println("Vous ne donnez pas ce cours.");
        }
    }
}
