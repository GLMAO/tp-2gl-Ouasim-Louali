package com.polytech.tp;


 //Classe Etudiant - Observer du pattern Observer
 //Reçoit les notifications des changements d'emploi du temps

public class Etudiant implements Observer {
    private String nom;

    public Etudiant(String nom) {
        this.nom = nom;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification pour l'étudiant " + nom + " : " + message);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}