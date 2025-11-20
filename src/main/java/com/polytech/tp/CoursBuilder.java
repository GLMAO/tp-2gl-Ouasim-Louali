package com.polytech.tp;

public class CoursBuilder {
    // Attributs privés pour stocker les valeurs pendant la construction
    private String matiere;
    private String enseignant;
    private String salle;
    private String date;
    private String heureDebut;
    private boolean estOptionnel;
    private String niveau;
    private boolean necessiteProjecteur;

    public CoursBuilder() {
        // Valeurs par défaut pour les paramètres optionnels
        this.salle = "Non définie";
        this.date = "Non définie";
        this.heureDebut = "Non définie";
        this.estOptionnel = false;
        this.niveau = "Non défini";
        this.necessiteProjecteur = false;
    }

    public CoursBuilder setMatiere(String matiere) {
        this.matiere = matiere;
        return this;
    }

    public CoursBuilder setEnseignant(String enseignant) {
        this.enseignant = enseignant;
        return this;
    }

    public CoursBuilder setSalle(String salle) {
        this.salle = salle;
        return this;
    }

    public CoursBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public CoursBuilder setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
        return this;
    }

    public CoursBuilder setEstOptionnel(boolean estOptionnel) {
        this.estOptionnel = estOptionnel;
        return this;
    }

    public CoursBuilder setNiveau(String niveau) {
        this.niveau = niveau;
        return this;
    }

    public CoursBuilder setNecessiteProjecteur(boolean necessiteProjecteur) {
        this.necessiteProjecteur = necessiteProjecteur;
        return this;
    }

    public Cours build() {
        // Validation optionnelle (exemple)
        if (matiere == null || matiere.isEmpty()) {
            throw new IllegalStateException("La matière est obligatoire");
        }
        if (enseignant == null || enseignant.isEmpty()) {
            throw new IllegalStateException("L'enseignant est obligatoire");
        }

        // Création de l'objet Cours avec tous les paramètres
        return new Cours(
                matiere,
                enseignant,
                salle,
                date,
                heureDebut,
                estOptionnel,
                niveau,
                necessiteProjecteur
        );
    }
}