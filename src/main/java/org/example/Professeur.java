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
                Matiere matNote = getMAt(matiereName);
                if (matNote != null){
                    System.out.println("Le nom de l'étudiant :");
                    String userName = scan.nextLine();
                    System.out.println("La note que vous voulez lui donner :");
                    int userNote = scan.nextInt();
                    Etudiant etu = matNote.getEtu(userName);
                    if (etu != null) {
                        matNote.noter(etu, userNote);
                        System.out.println("Note changé");
                    }
                    else {
                        System.out.println("Etudiant inexistant");
                    }
                }
                else {
                    System.out.println("Matière inexistante");
                }
            case 3 :
                System.out.println("La matière des étudiants à afficher : ");
                String matiereA = scan.nextLine();
                Matiere matiere2 = getMAt(matiereA);
                matiere2.consulterEtu();
            case 4 :
                this.consulterMat();
            default:
                System.out.println("Choix invalide ...");
                return 0;
        }


    }
        public Matiere getMAt(String nom){
            for (Matiere matL : mat){
                if (matL.nomMat == nom){
                    return matL;
                }
            }
            return null;
        }

}
