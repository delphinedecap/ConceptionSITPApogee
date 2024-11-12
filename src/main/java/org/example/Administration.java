package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Administration extends User{

    Apogee apogee;

    public Administration(String user_name, Apogee a){
        this.user_name = user_name;
        this.apogee = a;
    }

    public void créerCompte(String user_name, String typeCompte){
        if (this.apogee.getUser(user_name)==null){
            //retourne erreur, compte deja existant
        }
        if (Objects.equals(typeCompte, "Etudiant")){
            this.apogee.addUser(new Etudiant(user_name));
        } else if (Objects.equals(typeCompte, "Professeur")) {
            this.apogee.addUser(new Professeur(user_name));
        } else if (Objects.equals(typeCompte, "Administration")) {
            this.apogee.addUser(new Administration(user_name, this.apogee));
        } else {
            //retourner une erreur, type compte inexistant
        }
    }

}
