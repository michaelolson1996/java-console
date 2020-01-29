package edu.neumont.csc150.c.mutants.model;

import java.time.LocalDate;

public class StrongMutant extends Mutant {

    public StrongMutant() {}

    public StrongMutant(String a, int h, double w, Affiliation af, LocalDate bd) {
        super(a, h, w, af, bd);
    }

    @Override
    public void usePower() {
        System.out.println("Chonk, chonk, chonk");
        this.decreaseHealth(2, 4);
    }
}
