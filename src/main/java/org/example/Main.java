package org.example;

public class Main {
    public static void main(String[] args) {
        Apogee apogee = new Apogee();
        while (true) {
            apogee.afficherMenu();
            apogee.getResponse();
        }
    }
}