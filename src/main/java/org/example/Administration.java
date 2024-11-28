package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Administration extends User{

    Apogee apogee;

    public Administration(String user_name, Apogee a){
        this.user_name = user_name;
        this.apogee = a;
    }

    public void créerCompte(String user_name, String typeCompte){
        if (this.apogee.getUser(user_name)!=null){
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

    public void inscriptionProfMatiere(int idMat, Professeur p){
        Matiere m = this.apogee.getMatiere(idMat);
        if (m==null){
            System.out.println("Cet identifiant ne correspond pas à une matière existante...");
        } else {
            m.prof = p;
            p.mat.add(m);
        }
    }

    public void suppressionProfMatiere(int idMat, Professeur p){
        Matiere m = this.apogee.getMatiere(idMat);
        if (m == null) {
            System.out.println("Cet identifiant ne correspond pas à une matière existante...");
        } else {
            m.prof = null;
            p.mat.remove(m);
        }
    }

    public void inscriptionEleveMatiere(int idMat, Etudiant etu){
        Matiere m = this.apogee.getMatiere(idMat);
        if (m == null) {
            System.out.println("La matière n'existe pas...");
        } else {
            m.notes.put(etu, -1);
            etu.mat.add(apogee.getMatiere(idMat));
        }
    }

    public void suppressionEleveMatiere(Etudiant etu, int idMat){
        Matiere m = this.apogee.getMatiere(idMat);
            if (m == null) {
                System.out.println("La matière n'existe pas...");
            } else {
                m.notes.remove(etu);
                etu.mat.remove(apogee.getMatiere(idMat));
            }
    }

    public void creerMatiere(int idMat, String nomMat, String username){
        boolean identique = false;
        for (Matiere m : apogee.matieres){
            if (m.nomMat==nomMat){
                identique=true;
            }
        }
        if (identique){
            System.out.println("Nom de la matière déjà utilisé");
        } else {
            apogee.addMatiere(idMat, nomMat, username);
        }
    }

    public void afficherMenu(){
        super.afficherMenu();
        System.out.println("2- Créer compte");
        System.out.println("3- Inscrire un élève à une matière");
        System.out.println("4- Supprimer un élève d'une matière");
        System.out.println("5- Inscrire un professeur à une matière");
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
                System.out.println("Quel type de compte voulez vous créer ? 1- Etudiant, 2- Professeur, 3- Administrateur");
                int type = scan.nextInt();
                scan.nextLine();
                String type_reel;
                if (type==1){
                    type_reel = "Etudiant";
                } else if (type == 2) {
                    type_reel = "Professeur";
                } else if (type ==3){
                    type_reel = "Administration";
                } else {
                    System.out.println("Type de compte inconnu");
                    return 0;
                }
                System.out.println("Entrez le nom d'utilisateur : ");
                String username = scan.nextLine();
                this.créerCompte(username, type_reel);
                return 0;
            case 3 :
                scan.nextLine();
                System.out.println("Entrez l'username de l'étudiant : ");
                String usernameEtu = scan.nextLine();
                User e = apogee.getUser(usernameEtu);
                if (e != null && e instanceof Etudiant) {
                    System.out.println("Entree l'identifiant de la matière : ");
                    int idMat = scan.nextInt();
                    scan.nextLine();
                    inscriptionEleveMatiere(idMat, (Etudiant)e);
                } else {
                    System.out.println("L'identifiant ne correspond pas à un étudiant existant");
                }
                return 0;
            case 4 :
                scan.nextLine();
                System.out.println("Entrez l'username de l'étudiant : ");
                String usernameEtu2 = scan.nextLine();
                User e2 = apogee.getUser(usernameEtu2);
                if (e2 != null && e2 instanceof Etudiant) {
                    System.out.println("Entree l'identifiant de la matière : ");
                    int idMat2 = scan.nextInt();
                    scan.nextLine();
                    suppressionEleveMatiere((Etudiant)e2, idMat2);
                } else {
                    System.out.println("L'identifiant ne correspond pas à un étudiant existant");
                }
                return 0;
            case 5 :
                scan.nextLine();
                System.out.println("Entrez l'username du professeur : ");
                String profUsername = scan.nextLine();
                User p = apogee.getUser(profUsername);
                if (p != null && p instanceof Professeur) {
                    System.out.println("Entree l'identifiant de la matière : ");
                    int idMat3 = scan.nextInt();
                    scan.nextLine();
                    inscriptionProfMatiere(idMat3, (Professeur)p);
                } else {
                    System.out.println("L'identifiant ne correspond pas à un professeur existant");
                }
                return 0;
            case 6 :
                scan.nextLine();
                System.out.println("Entrez l'username du professeur : ");
                String profUsername2 = scan.nextLine();
                User p2 = apogee.getUser(profUsername2);
                if (p2 != null && p2 instanceof Professeur) {
                    System.out.println("Entree l'identifiant de la matière : ");
                    int idMat4 = scan.nextInt();
                    scan.nextLine();
                    suppressionProfMatiere(idMat4, (Professeur)p2);
                } else {
                    System.out.println("L'identifiant ne correspond pas à un professeur existant");
                }
                return 0;
            case 7 :
                System.out.println("Veuillez saisir un identifiant pour la matiere : ");
                int idMatiere = scan.nextInt();
                scan.nextLine();
                System.out.println("Veuillez saisir un nom pour la matière : ");
                String nomMat = scan.nextLine();
                System.out.println("Veuillez saisir l'username du professeur en charge de la matière : ");
                String idProf = scan.nextLine();
                creerMatiere(idMatiere, nomMat, idProf);
                return 0;
            default:
                System.out.println("Choix invalide ...");
                return 0;
        }
    }



}
