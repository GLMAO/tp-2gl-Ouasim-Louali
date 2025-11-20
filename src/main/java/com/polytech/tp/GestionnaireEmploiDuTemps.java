package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {
    // Liste des cours gérés
    private List<ICours> listeCours = new ArrayList<>();

    // Liste des observateurs à notifier
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Nouvel observateur ajouté");
        }
    }

    @Override
    public void detach(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
            System.out.println("Observateur retiré");
        }
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        String message = "Nouveau cours ajouté : " + cours.getDescription();
        System.out.println(message);

        // Notifier tous les observateurs du nouveau cours
        notifyObservers(message);
    }


    public void modifierCours(ICours cours, String message) {
        // Logique de modification du cours
        System.out.println("Cours modifié : " + message);

        // Notifier tous les observateurs de la modification
        notifyObservers("Modification : " + message);
    }

    public void setChangement(String message) {
        // Notifier tous les observateurs du changement
        notifyObservers(message);
    }

    public void annulerCours(ICours cours) {
        if (listeCours.contains(cours)) {
            listeCours.remove(cours);
            String message = "Cours annulé : " + cours.getDescription();
            System.out.println(message);

            // Notifier tous les observateurs de l'annulation
            notifyObservers(message);
        }
    }

    public List<ICours> getListeCours() {
        return new ArrayList<>(listeCours);
    }
}