package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Apogee {
    private ArrayList<User> users;
    private User utilisateurCourant;
    private ArrayList<Matiere> matieres;

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
            //retourne erreur utilisateur inconnu
        } else {
            u.seConnecter();
            utilisateurCourant = u;
        }
    }

    public void deconnexionUtilisateur(){
        this.utilisateurCourant.seDeconnecter();
        this.utilisateurCourant = null;
    }

    public void addMatiere(int idMat, Professeur p){
        if (getMatiere(idMat)==null){
            this.matieres.add(new Matiere(idMat, p));
        } else {
            //retourne erreur matièere deja existante
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

    public void changerProfMatiere(int idMat, Professeur p){
        Matiere m = getMatiere(idMat);
        if (m==null){
            //retourne erreur, matiere inexistante
        }
        this.m.professeur = p;
    }

    //iscription eleves notes negatives
    public void inscriptionElevesMatiere(int idMat, ArrayList<Etudiant> etudiants){
        Matiere m = getMatiere(idMat);
        if (m==null){
            //retourne erreur, matiere inexistante
        }
        for (Etudiant e : etudiants){
            m.notes.put(e, -1);
        }
    }
}
