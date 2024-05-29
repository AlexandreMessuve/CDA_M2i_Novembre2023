package exercice.tp.globalDesignPattern;

import exercice.tp.globalDesignPattern.entity.RaceControl;
import exercice.tp.globalDesignPattern.entity.RaceObserver;
import java.util.Random;

public class Main {

    static Random random = new Random();
    public static void main(String[] args) {
        RaceControl control = RaceControl.getRaceControl();
        control.test();
    }



}
