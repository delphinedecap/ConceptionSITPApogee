package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Apogee {
    private ArrayList<User> users;
    private User utilisateurCourant;
    private ArrayList<Matiere> matieres;
    private Scanner scanner = new Scanner(System.in);

    public Apogee(){
        this.users = new ArrayList<>();
        this.matieres = new ArrayList<>();
    }

    public void addUser(User u){
        this.users.add(u);
    }

    public User getUser(String user_name){
        for (User u : this.users){
            if (Objects.equals(u.getUserName(), user_name)){
                return u;
            }
        }
        return null;
    }

    public void connexionUtilisateur(String user_name){
        User u = this.getUser(user_name);
        if (u == null){
            System.out.println("Utilisateur inconnu ...");
        } else {
            u.seConnecter();
            utilisateurCourant = u;
            System.out.println("Bienvenue " + user_name);
        }
    }

    public void deconnexionUtilisateur(){
        System.out.println("Aurevoir " + this.utilisateurCourant.getUserName() + " ... ");
        this.utilisateurCourant.seDeconnecter();
        this.utilisateurCourant = null;
    }

    public void addMatiere(int idMat, String nomMatiere, String username){
        User p = getUser(username);
        if (p instanceof Professeur){
            if (getMatiere(idMat)==null){
                this.matieres.add(new Matiere(idMat,nomMatiere, (Professeur)p));
            } else {
                System.out.println("Une matière existe déjà avec cet ID");
            }
        } else {
            System.out.println("Ce nom d'utilisateur ne correspond pas à un professeur");
        }

    }

    public ArrayList<Matiere> getMatieres(){
        return this.matieres;
    }

    public Matiere getMatiere(int idMat){
        for (Matiere m : this.matieres){
            if (m.idMat == idMat){
                return m;
            }
        }
        return null;
    }

    public User getUserCourant(){
        return this.utilisateurCourant;
    }

    public void afficherMenu(){
        if (this.users.isEmpty()){
            System.out.println("Veuillez créer un nom administrateur pour commencer à utiliser Apogee");
            System.out.println("-------------");
            System.out.println("Veuillez entrer le nouveau nom d'utilisateur du compte administrateur");
            String username = scanner.nextLine();
            Administration admin = new Administration(username, this);
            this.users.add(admin);
            connexionUtilisateur(username);
        } else {
            if (this.utilisateurCourant == null) {
                System.out.println("Que souhaitez vous faire ?");
                System.out.println("1- Se connecter");
            } else {
                if (utilisateurCourant instanceof Etudiant) {
                    ((Etudiant) utilisateurCourant).afficherMenu();
                } else if (utilisateurCourant instanceof Professeur) {
                    ((Professeur) utilisateurCourant).afficherMenu();
                } else {
                    ((Administration) utilisateurCourant).afficherMenu();
                }
            }
        }
    }

    public void getResponse(){
        if (this.utilisateurCourant == null ){
            Integer reponse = scanner.nextInt();
            scanner.nextLine();
            if (reponse == 1){
                System.out.println("Veuillez entrer l'username : ");
                String username = scanner.nextLine();
                connexionUtilisateur(username);
            } else {
                System.out.println("Choix invalide ...");
            }
        } else {
            Integer reponse;
            if (utilisateurCourant instanceof Etudiant) {
                reponse = ((Etudiant)utilisateurCourant).getResponse(this.scanner);
            } else if (utilisateurCourant instanceof Professeur) {
                reponse = ((Professeur)utilisateurCourant).getResponse(this.scanner);
            } else {
                reponse = ((Administration)utilisateurCourant).getResponse(this.scanner);
            }
            if (reponse == -1) {
                this.deconnexionUtilisateur();;
            }
        }
    }

}
