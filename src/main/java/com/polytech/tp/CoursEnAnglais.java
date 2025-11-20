package com.polytech.tp;

public class CoursEnAnglais extends CoursDecorator {

    public CoursEnAnglais(ICours cours) {
        super(cours);
    }

    @Override
    public String getDescription() {
        return coursDecorated.getDescription() + " (En anglais)";
    }

    @Override
    public double getDuree() {
        // Un cours en anglais peut prendre 10% de temps en plus
        return coursDecorated.getDuree() * 1.1;
    }
}