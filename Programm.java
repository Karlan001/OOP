import java.util.SimpleTimeZone;
import java.util.SortedMap;


public class Programm {
    public static void main(String[] args) {
        Sniper hero1 = new Sniper("sniper", 100, 30, 30, 10, 12, 21, 15);
        Mag hero2 = new Mag("Mag", 80, 25, 20, 35, 7, 30, 26);
        Monk hero3 = new Monk("Monk", 80, 25, 20, 35, 7, 30, 8);
        Crossbowman hero4 = new Crossbowman("Crossbowman", 75, 30, 30, 10, 9, 30, 26);
        Peasant hero5 = new Peasant("Peasan", 50, 15, 10, 10, 10);
        Pikeman hero6 = new Pikeman("Pikeman", 100, 30, 30, 10, 25, 30, 15);
        Robber hero7 = new Robber("Robber", 70, 25, 30, 12, 10, 30, 26);
        System.out.println(hero1.toString());
        System.out.println(hero2.toString());
        System.out.println(hero3.toString());
        System.out.println(hero4.toString());
        System.out.println(hero5.toString());
        System.out.println(hero6.toString());
        System.out.println(hero7.toString());
    }

}
