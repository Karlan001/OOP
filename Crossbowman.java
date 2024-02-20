public class Crossbowman extends Heroes {
    protected int accuracy;
    protected int speed;

    protected Crossbowman(String name, int x, int y) {
        super(name, 80, 50, 45, 10, 50, x, y);
    }

    @Override
    protected int attack(Heroes target) {
        return super.attack(target);
    }

    protected int powerFullShot(){
        int damage = Heroes.random.nextInt(4, 8);
        this.agility -= 4;
        return damage;
    }

    public String toString() {
        return name + ", class Crossbowman, coordinate: " + place;
    }

}
