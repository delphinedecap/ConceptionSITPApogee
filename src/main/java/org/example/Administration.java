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
        } else {
            System.out.println("Type de compte inconnu ...");
        }
    }

    public void inscriptionProfMatiere(int idMat, String username){
        Matiere m = this.apogee.getMatiere(idMat);
        User p = apogee.getUser(username);
        if (p instanceof Professeur) {
            if (m==null){
                System.out.println("Cet identifiant ne correspond pas à une matière existante...");
            } else {
                m.prof = (Professeur) p;
                ((Professeur)p).mat.add(m);
            }
        } else {
            System.out.println("Ce nom d'utilisateur ne correspond pas à un professeur");
        }
    }

    public void suppressionProfMatiere(int idMat, String username){
        Matiere m = this.apogee.getMatiere(idMat);
        User p = apogee.getUser(username);
        if (p instanceof Professeur) {
            if (m == null) {
                System.out.println("Cet identifiant ne correspond pas à une matière existante...");
            } else {
                m.prof = null;
                ((Professeur)p).mat.remove(m);
            }
        } else {
            System.out.println("Ce nom d'utilisateur ne correspond pas à un professeur");
        }
    }

    public void inscriptionEleveMatiere(int idMat, String username){
        Matiere m = this.apogee.getMatiere(idMat);
        User etu = apogee.getUser(username);
        if (etu instanceof Etudiant) {
            if (m == null) {
                System.out.println("La matière n'existe pas...");
            } else {
                m.notes.put((Etudiant)etu, -1);
                ((Etudiant)etu).mat.add(apogee.getMatiere(idMat));
            }
        } else {
            System.out.println("Ce nom d'utilisateur ne correspond pas à un étudiant");
        }
    }

    public void suppressionEleveMatiere(String username, int idMat){
        Matiere m = this.apogee.getMatiere(idMat);
        User etu = apogee.getUser(username);
        if (etu instanceof Etudiant) {
            if (m == null) {
                System.out.println("La matière n'existe pas...");
            } else {
                m.notes.remove((Etudiant)etu);
                ((Etudiant)etu).mat.remove(apogee.getMatiere(idMat));
            }
        } else {
            System.out.println("Ce nom d'utilisateur ne correspond pas à un étudiant");
        }
    }

    public void creerMatiere(int idMat, String nomMat, String username){
        User p = apogee.getUser(username);
        if (p instanceof Professeur){
            apogee.addMatiere(idMat,nomMat,(Professeur)p);
        } else {
            System.out.println("Ce nom d'utilisateur ne correspond pas à un professeur");
        }
    }

    public void afficherMenu(){
        super.afficherMenu();
        System.out.println("2- Créer compte");
        System.out.println("3- Inscrire un élève à une matière");
        System.out.println("4- Supprimer un élève d'une matière");
        System.out.println("5- Inscrire un professeur à une marière");
        System.out.println("6- Enlever un professeur d'une matière");
        System.out.println("7- Créer une nouvelle matière");
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
                String type_reel = "";
                switch(type) {
                    case 1 :
                        type_reel = "Etudiant";
                    case 2 :
                        type_reel = "Professeur";
                    case 3 :
                        type_reel = "Administration";
                }
                this.créerCompte(user_name, type_reel);
            case 3 :
                System.out.println("Entrez l'username de l'étudiant : ");
                String usernameEtu = scan.nextLine();
                User e = apogee.getUser(usernameEtu);
                if (e != null && e instanceof Etudiant) {
                    System.out.println("Entree l'identifiant de la matière : ");
                    int idMat = scan.nextInt();
                    inscriptionEleveMatiere(idMat, (Etudiant)e);
                } else {
                    System.out.println("L'identifiant ne correspond pas à un étudiant existant");
                }
                return 0;
            case 4 :
                System.out.println("Entrez l'username de l'étudiant : ");
                String usernameEtu2 = scan.nextLine();
                User e2 = apogee.getUser(usernameEtu2);
                if (e2 != null && e2 instanceof Etudiant) {
                    System.out.println("Entree l'identifiant de la matière : ");
                    int idMat2 = scan.nextInt();
                    suppressionEleveMatiere((Etudiant)e2, idMat2);
                } else {
                    System.out.println("L'identifiant ne correspond pas à un étudiant existant");
                }
                return 0;
            case 5 :
                System.out.println("Entrez l'username du professeur : ");
                String profUsername = scan.nextLine();
                User p = apogee.getUser(profUsername);
                if (p != null && p instanceof Professeur) {
                    System.out.println("Entree l'identifiant de la matière : ");
                    int idMat3 = scan.nextInt();
                    inscriptionProfMatiere(idMat3, (Professeur)p);
                } else {
                    System.out.println("L'identifiant ne correspond pas à un professeur existant");
                }
                return 0;
            case 6 :
                System.out.println("Entrez l'username du professeur : ");
                String profUsername2 = scan.nextLine();
                User p2 = apogee.getUser(profUsername2);
                if (p2 != null && p2 instanceof Professeur) {
                    System.out.println("Entree l'identifiant de la matière : ");
                    int idMat4 = scan.nextInt();
                    suppressionProfMAtiere(idMat4, (Professeur)p2);
                } else {
                    System.out.println("L'identifiant ne correspond pas à un professeur existant");
                }
                return 0;
            case 7 :
                System.out.println("Veuillez saisir un identifiant pour la matiere : ");
                int idMatiere = scan.nextInt();;
                System.out.println("Veuillez saisir un nom pour la matière : ");
                String nomMat = scan.nextLine();
                System.out.println("Veuillez saisir l'username du professeur en charge de la matière : ");
                String idProf = scan.nextLine();
                User prof = apogee.getUser(idProf);
                if (prof != null && prof instanceof Professeur) {
                    creerMatiere(idMatiere, nomMat, (Professeur)prof);
                } else {
                    System.out.println("L'identifiant ne correspond pas à un professeur existant");
                }
            default:
                System.out.println("Choix invalide ...");
                return 0;
        }
    }

}
