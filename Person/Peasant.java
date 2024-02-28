package Person;

import java.util.ArrayList;

public class Peasant extends Heroes {

    public Peasant(String name, int x, int y) {
        super(name, 40, 20, 20, 5, 5, x, y);
        this.initiative = 0;
    }

    @Override
    public int attack(Heroes target) {
        return super.attack(target);
    }

    public String toString() {
        return name + ", class Peasant, coordinate: " + place;
    }


    @Override
    public void Step(ArrayList<Heroes> team, ArrayList<Heroes> frendly) {

    }

    @Override
    public String getInfo() {
        return String.format("%s, class Peasant", super.getInfo());
    }
}
