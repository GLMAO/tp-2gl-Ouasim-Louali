package com.polytech.tp;

public class Responsable implements Observer {
    private String nom;

    public Responsable(String nom) {
        this.nom = nom;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification pour le responsable " + nom + " : " + message);

        // Le responsable pourrait avoir des actions supplémentaires
        // Par exemple : logger dans un système, envoyer un email, etc.
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}