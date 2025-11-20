package com.polytech.tp;

public class CoursMagistral extends CoursDecorator {

    public CoursMagistral(ICours cours) {
        super(cours);
    }

    @Override
    public String getDescription() {
        return coursDecorated.getDescription() + " (Magistral)";
    }

    @Override
    public double getDuree() {
        // Un cours magistral dure environ 2h (vs 1.5h normalement)
        return coursDecorated.getDuree() * 1.33;
    }
}