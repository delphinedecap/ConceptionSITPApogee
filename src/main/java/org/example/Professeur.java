package org.example;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

public class Professeur extends User{
    public ArrayList<Matiere> mat = new ArrayList();

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
            mat.consulterEtu();
        }
        else{
            System.out.println("Vous ne donnez pas ce cours.");
        }
    }

    public void afficherMenu(){
        super.afficherMenu();
        System.out.println("2 - Noter");
        System.out.println("3 - Consulter ses étudiants");
        System.out.println("4 - Consulter ses matières");
    }

    public int getResponse(Scanner scan){
        int response = scan.nextInt();
        switch (response) {
            case 1 :
                this.seDeconnecter();
                return -1;
            case 2 :
                System.out.println("La matière où est inscrit l'étudiant : ");
                String matiereName = scan.nextLine();
                System.out.println("Le nom de l'étudiant :");
                String userName = scan.nextLine();
                for
                // int type = scan.nextInt();
                String type_reel;
                switch(type) {
                    case 1 :
                        type_reel = "Etudiant";
                    case 2 :
                        type_reel = "Professeur";
                    case 3 :
                        type_reel = "Administration";
                    default:
                        return 0;
                }

                this.noter(etu, note);
            case 3 :
            case 4 :
            case 5 :
            case 6 :
            default:
                System.out.println("Choix invalide ...");
                return 0;
        }
    }
}
