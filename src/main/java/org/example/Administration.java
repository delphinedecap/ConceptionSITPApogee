package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Administration extends User{

    static ArrayList<User> users = new ArrayList<User>();

    public Administration(String user_name){
        this.user_name = user_name;
    }

    public void créerCompte(String user_name, String typeCompte){
        if (Objects.equals(typeCompte, "Etudiant")){

        } else if (Objects.equals(typeCompte, "Professeur")) {

        } else if (Objects.equals(typeCompte, "Administration")) {

        } else {
            //retourner une erreur
        }
    }

    private boolean verifierExistanceCompte(String user_name){
        for (User u : this.users) {
            if (u.getUserName == user_name)
        }
    }

}
