package org.example;

public class Main {
    public static void main(String[] args) {
        Apogee apogee = new Apogee();
        apogee.afficherMenu();
        while (true) {
            apogee.afficherMenu();
            apogee.getResponse();
        }
    }
}