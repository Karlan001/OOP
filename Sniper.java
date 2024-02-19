public class Sniper extends Heroes{
    protected int accuracy;

    protected int stealthiness;

    public Sniper(String name, int x, int y) {
        super(name, 60, 40, 35, 10, 10, x, y);
    }

    protected int attack(Sniper target) {
        int damage = random.nextInt(2,6);
        this.stamina -= random.nextInt(1, 3);
        return damage;
    }

    @Override
    protected String getInfo() {
        return String.format("%s, accuracy: %d, stealthiness: %d", super.getInfo(), this.accuracy, this.stealthiness);
    }

    @Override
    public String toString() {
        return "class Sniper, coordinate: " + place;
    }
}
