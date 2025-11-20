package com.polytech;

import com.polytech.tp.*;

public class App
{
    public static void main( String[] args )
    {
        // *** Exercice 01 ***

        // Construction simple
        Cours cours1 = new CoursBuilder()
                .setMatiere("Génie Logiciel")
                .setEnseignant("Mr Oussama")
                .build();

        // Construction complète avec tous les paramètres
        Cours cours2 = new CoursBuilder()
                .setMatiere("Assurance Qualité")
                .setEnseignant("Mr Omar")
                .setSalle("D23")
                .setDate("Lundi")
                .setHeureDebut("8h00")
                .setEstOptionnel(false)
                .setNiveau("2A")
                .setNecessiteProjecteur(true)
                .build();

        // *** Exercice 02 ***
        System.out.println("********* Exercice 02 ***********");


        // Création du gestionnaire (Subject)
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();

        // Création des observateurs
        Etudiant alice = new Etudiant("Alice");
        Etudiant bob = new Etudiant("Bob");
        Responsable responsable = new Responsable("Dr. Dupont");

        // Enregistrement des observateurs
        gestionnaire.attach(alice);
        gestionnaire.attach(bob);
        gestionnaire.attach(responsable);

        // Création d'un cours
        Cours cours0 = new CoursBuilder()
                .setMatiere("Génie Logiciel")
                .setEnseignant("Mr Oussama")
                .setSalle("C15")
                .build();

        // Ajout du cours → TOUS les observateurs sont notifiés
        gestionnaire.ajouterCours(cours0);

        // Changement → TOUS les observateurs sont notifiés
        gestionnaire.setChangement("Changement de salle : C15→C16");

        // Se désinscrire des notifications
        gestionnaire.detach(bob);

        // Modification → Seuls Alice et le responsable sont notifiés
        gestionnaire.modifierCours(cours0, "Horaire décalé à 10h");


        // *** Exercice 03 ***
        System.out.println("********* Exercice 03 ***********");


        //Un seul décorateur
        // Cours de base
        ICours cours = new CoursBuilder()
                .setMatiere("Génie Logiciel")
                .setEnseignant("Mr Oussama")
                .build();

        // Application d'un décorateur
        ICours coursEnLigne = new CoursEnLigne(cours);

        System.out.println(coursEnLigne.getDescription());
        // Sortie: "Cours de Génie Logiciel avec Mr Oussama (Non définie) (En ligne)"


        //Empilement de décorateurs
        // Cours de base
        ICours course = new CoursBuilder()
                .setMatiere("Architecture Logicielle")
                .setEnseignant("Dr. Smith")
                .setSalle("A101")
                .build();

        // Empilement de décorateurs
        ICours coursDecore = new CoursEnLigne(course);
        coursDecore = new CoursEnAnglais(coursDecore);
        coursDecore = new CoursMagistral(coursDecore);

        System.out.println(coursDecore.getDescription());
        // Sortie: "Cours de Architecture Logicielle avec Dr. Smith (A101) (En ligne) (En anglais) (Magistral)"

        System.out.println(coursDecore.getDuree());
        // Sortie: 1.5 * 1.1 * 1.33 ≈ 2.2 heures



        //Création fluide avec décorateurs

        ICours coursf = new CoursMagistral(
                new CoursEnAnglais(
                        new CoursEnLigne(
                                new CoursBuilder()
                                        .setMatiere("Intelligence Artificielle")
                                        .setEnseignant("Prof. Turing")
                                        .build()
                        )
                )
        );

        System.out.println(coursf.getDescription());
        // "Cours de Intelligence Artificielle avec Prof. Turing (...) (En ligne) (En anglais) (Magistral)"

    }
}
