package edu.neumont.csc150.c.codescrambler.test;

import edu.neumont.csc150.c.codescrambler.models.Cutter;
import edu.neumont.csc150.c.codescrambler.models.Doubler;
import edu.neumont.csc150.c.codescrambler.models.Reverser;
import edu.neumont.csc150.c.codescrambler.models.VowelReplacer;

public class TestDriver {
    public static void main(String[] args) {
        Cutter cutter = new Cutter();
        Doubler doubler = new Doubler();
        VowelReplacer vr = new VowelReplacer();
        Reverser reverser = new Reverser();
        System.out.println(cutter.encrypt("hello"));
        System.out.println(cutter.decrypt("lohel"));
        System.out.println(doubler.encrypt("hello"));
        System.out.println(doubler.decrypt("hellohello"));
        System.out.println(vr.encrypt("uaeiokflf"));
        System.out.println(vr.encrypt("uaeiok"));
        System.out.println(reverser.encrypt("hello world"));
        System.out.println(reverser.decrypt("dlrow olleh"));


    }
}
