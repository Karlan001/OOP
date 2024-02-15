public class Sniper extends Heroes{
    protected int accuracy;

    protected int stealthiness;

    protected Sniper(String name, int hp, int stamina, int agility, int intellect, int strange, int accuracy, int stealthiness) {
        super(name, hp, stamina, agility, intellect, strange);
        this.accuracy = accuracy;
        this.stealthiness = stealthiness;
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
        return "class Sniper";
    }
}
