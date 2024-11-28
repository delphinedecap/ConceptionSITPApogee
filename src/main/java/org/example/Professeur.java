package org.example;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Professeur extends User{
    public ArrayList<Matiere> mat = new ArrayList();

    public Professeur(String user_name){
        this.connected = false;
        this.user_name = user_name;
    }
    public void noter(Etudiant etu, Matiere matiere, int note){
        if (note>20 || note<0){
            System.out.println("Note invalide");
        }
        else {
            matiere.noter(etu, note);
        }
    }

    public void consulterMat(){
        System.out.println("Vos matières sont : ");
        for(Matiere matiere : mat){
            System.out.println(matiere.nomMat+" ");
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
        System.out.println("2- Noter");
        System.out.println("3- Consulter ses étudiants");
        System.out.println("4- Consulter ses matières");
    }

    public int getResponse(Scanner scan){
        int response = scan.nextInt();
        scan.nextLine();
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
                    scan.nextLine();
                    Etudiant etu = matNote.getEtu(userName);
                    if (etu != null) {
                        matNote.noter(etu, userNote);
                    }
                    else {
                        System.out.println("Etudiant inexistant");
                    }
                }
                else {
                    System.out.println("Matière inexistante");
                }
                return 0;
            case 3 :
                System.out.println("Entrez la matière des étudiants à afficher ");
                String matiereA = scan.nextLine();
                Matiere matiere2 = getMAt(matiereA);
                if (matiere2 != null) {matiere2.consulterEtu();}
                return 0;
            case 4 :
                this.consulterMat();
                return 0;
            default:
                System.out.println("Choix invalide ...");
                return 0;
        }


    }
    public Matiere getMAt(String nom){
        for (Matiere matL : mat){
            if (Objects.equals(matL.nomMat, nom)){
                return matL;
            }
        }
        return null;
    }

}
