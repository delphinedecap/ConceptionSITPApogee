package org.example;

public abstract class User {
    String user_name;
    Boolean connected = false;

    public void seConnecter(){
        this.connected = true;
    }

    public void seDeconnecter(){
        this.connected = false;
    }
}
