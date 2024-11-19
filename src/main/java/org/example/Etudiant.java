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
            System.out.println(matiere+" ");
        }
    }

    public void afficherMenu(){
        super.afficherMenu();
        System.out.println("2 - Consulter matière");
    }

    public int getResponse(Scanner scan){
        int response = scan.nextInt();
        switch (response) {
            case 1 :
                this.seDeconnecter();
                return -1;
            case 2 :
                this.consulterMatiere();
         default:
                System.out.println("Choix invalide ...");
                return 0;
        }
    }

}
