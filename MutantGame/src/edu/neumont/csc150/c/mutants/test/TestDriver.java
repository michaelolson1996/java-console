package edu.neumont.csc150.c.mutants.test;

import edu.neumont.csc150.c.mutants.model.Mutant;
import edu.neumont.csc150.c.mutants.model.QuickMutant;
import edu.neumont.csc150.c.mutants.model.StrongMutant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDriver {
    public static void main(String[] args) {
        QuickMutant quickSilver = new QuickMutant();
        quickSilver.setSpeed(100);
        Mutant mutant = quickSilver;

        List<Mutant> myMutants = new ArrayList<>();
        myMutants.add(quickSilver);




        quickSilver.setSpeed(9.7);
        quickSilver.setBirthday(LocalDate.of(1990,5,20));
        Mutant colossus = new StrongMutant();
        colossus.setHealth(100);
        colossus.setBirthday(LocalDate.of(1980,11,17));
        Mutant reference = quickSilver;
        ((QuickMutant) quickSilver).setSpeed(600.5);

        List<Mutant> mutants = new ArrayList<>();
        mutants.add(quickSilver);
        mutants.add(colossus);
        Mutant qm = mutants.get(0);

        for (Mutant m: mutants) {
            System.out.println(m );
//            m.usePower();
//            if (m instanceof QuickMutant) {
//                ((QuickMutant) m).runSuperFast();
//            }
//            System.out.println(m.formattedBirthday());
//            System.out.println(m.getAge());
        }
    }
}