import java.util.ArrayList;

public class Pikeman extends Heroes {
    protected int power;
    protected int speed;

    protected Pikeman(String name, int x, int y) {
        super(name, 75, 45, 40, 10, 35, x, y);
        this.initiative = 2;
    }

    @Override
    protected int attack(Heroes target) {
        return super.attack(target) + 3;
    }

    @Override
    protected int heal(Heroes target) {
        return super.heal(target);
    }

    @Override
    public String toString() {
        return name + ", class Pikeman, coordinate: " + place;
    }


    @Override
    public void Step(ArrayList<Heroes> team, ArrayList<Heroes> frendly) {
    }

    @Override
    protected String getInfo() {
        return String.format("%s, class Pikeman", super.getInfo());
    }
}
