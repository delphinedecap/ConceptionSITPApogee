package org.example;

import java.util.ArrayList;

public class Etudiant extends User{
    public ArrayList<Matiere> mat = new ArrayList();

    public Etudiant(String user_name){
        this.user_name = user_name;
    }

    public void consulterMatiere(){
        System.out.println("Vos matières sont :");
        for(Matiere matiere: mat){
            System.out.println(matiere+" ");
        }
    }

    public void afficherMenu(){
        super.afficherMenu();
        System.out.println("2 - Consulter matière");
    }

}
