package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Administration extends User{

    Apogee apogee;

    public Administration(String user_name, Apogee a){
        this.user_name = user_name;
        this.apogee = a;
    }

    public void créerCompte(String user_name, String typeCompte){
        if (this.apogee.getUser(user_name)==null){
            System.out.println("Cet username est déjà pris ...");
        }
        if (Objects.equals(typeCompte, "Etudiant")){
            this.apogee.addUser(new Etudiant(user_name));
        } else if (Objects.equals(typeCompte, "Professeur")) {
            this.apogee.addUser(new Professeur(user_name));
        } else if (Objects.equals(typeCompte, "Administration")) {
            this.apogee.addUser(new Administration(user_name, this.apogee));
        }
    }

    public void inscriptionProfMatiere(int idMat, Professeur p){
        Matiere m = this.apogee.getMatiere(idMat);
        if (m==null){
            //retourne erreur, matiere inexistante
        }
        m.prof = p;
    }

    //iscription eleves notes negatives
    public void inscriptionElevesMatiere(int idMat, ArrayList<Etudiant> etudiants){
        Matiere m = this.apogee.getMatiere(idMat);
        if (m==null){
            //retourne erreur, matiere inexistante
        }
        for (Etudiant e : etudiants){
            m.notes.put(e, -1);
        }
    }

    public void afficherMenu(){
        super.afficherMenu();
        System.out.println("2- Créer compte");
        System.out.println("3- Inscrire un élève à une matière");
        System.out.println("4- Supprimer un élève d'une matière");
        System.out.println("5- Inscrire un professeur à une marière");
        System.out.println("6- Enlever un professeur d'une matière");
    }


    public int getResponse(Scanner scan){
        int response = scan.nextInt();
        switch (response) {
            case 1 :
                this.seDeconnecter();
                return -1;
            case 2 :
                System.out.println("Entrez le nom d'utilisateur : ");
                String username = scan.nextLine();
                System.out.println("Quel type de compte voulez vous créer ? 1- Etudiant, 2- Professeur, 3- Administrateur");
                int type = scan.nextInt();
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

                this.créerCompte(user_name, type_reel);
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
