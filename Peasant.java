public class Peasant extends Heroes{

    protected Peasant(String name, int x, int y) {
        super(name, 40, 20, 20, 5, 5, x, y);
    }

    @Override
    protected int attack(Heroes target) {
        return super.attack(target);
    }

    public String toString() {
        return name + ", class Peasant, coordinate: " + place;
    }

}
