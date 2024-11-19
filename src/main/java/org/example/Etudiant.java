package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Etudiant extends User{
    public ArrayList<Matiere> mat = new ArrayList();

    public Etudiant(String user_name){
        this.user_name = user_name;
    }

    public void consulterMatiere(){
        System.out.println("Vos matières sont :");
        for(Matiere matiere: mat){
            System.out.println(matiere.nomMat+" ");
        }
    }

    public void consulterNotes(){
        System.out.println("Vos notes sont : ");
        for (Matiere matiere : this.mat){
            System.out.print(matiere.nomMat+" : ");
            System.out.println(matiere.notes.get(this));
        }
    }

    public void afficherMenu(){
        super.afficherMenu();
        System.out.println("2 - Consulter matières ");
        System.out.println("3 - Consulter ses notes ");
    }

    public int getResponse(Scanner scan){
        int response = scan.nextInt();
        switch (response) {
            case 1 :
                this.seDeconnecter();
                return -1;
            case 2 :
                this.consulterMatiere();
                return 0;
            case 3 :
                this.consulterNotes();
                return 0;
         default:
                System.out.println("Choix invalide ...");
                return 0;
        }
    }

}
