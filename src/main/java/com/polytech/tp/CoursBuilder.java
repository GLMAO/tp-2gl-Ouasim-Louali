package com.polytech.tp;

/**
 * Builder Pattern pour la construction d'objets Cours
 * Résout le problème du constructeur surchargé avec de nombreux paramètres
 */
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

    /**
     * Constructeur par défaut
     * Initialise les valeurs par défaut pour les attributs optionnels
     */
    public CoursBuilder() {
        // Valeurs par défaut pour les paramètres optionnels
        this.salle = "Non définie";
        this.date = "Non définie";
        this.heureDebut = "Non définie";
        this.estOptionnel = false;
        this.niveau = "Non défini";
        this.necessiteProjecteur = false;
    }

    /**
     * Définit la matière du cours
     * @param matiere le nom de la matière
     * @return le builder pour chaînage
     */
    public CoursBuilder setMatiere(String matiere) {
        this.matiere = matiere;
        return this;
    }

    /**
     * Définit l'enseignant du cours
     * @param enseignant le nom de l'enseignant
     * @return le builder pour chaînage
     */
    public CoursBuilder setEnseignant(String enseignant) {
        this.enseignant = enseignant;
        return this;
    }

    /**
     * Définit la salle du cours
     * @param salle la salle
     * @return le builder pour chaînage
     */
    public CoursBuilder setSalle(String salle) {
        this.salle = salle;
        return this;
    }

    /**
     * Définit la date du cours
     * @param date la date
     * @return le builder pour chaînage
     */
    public CoursBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    /**
     * Définit l'heure de début du cours
     * @param heureDebut l'heure de début
     * @return le builder pour chaînage
     */
    public CoursBuilder setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
        return this;
    }

    /**
     * Définit si le cours est optionnel
     * @param estOptionnel true si optionnel
     * @return le builder pour chaînage
     */
    public CoursBuilder setEstOptionnel(boolean estOptionnel) {
        this.estOptionnel = estOptionnel;
        return this;
    }

    /**
     * Définit le niveau du cours
     * @param niveau le niveau (ex: "2A", "3A")
     * @return le builder pour chaînage
     */
    public CoursBuilder setNiveau(String niveau) {
        this.niveau = niveau;
        return this;
    }

    /**
     * Définit si le cours nécessite un projecteur
     * @param necessiteProjecteur true si projecteur nécessaire
     * @return le builder pour chaînage
     */
    public CoursBuilder setNecessiteProjecteur(boolean necessiteProjecteur) {
        this.necessiteProjecteur = necessiteProjecteur;
        return this;
    }

    /**
     * Construit l'objet Cours final avec les paramètres définis
     * @return un nouvel objet Cours
     */
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