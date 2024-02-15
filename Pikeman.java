public class Pikeman extends Heroes{
    protected int power;
    protected int speed;

    protected Pikeman(String name, int hp, int stamina, int agility, int intellect, int strange, int power, int speed) {
        super(name, hp, stamina, agility, intellect, strange);
        this.power = power;
        this.speed = speed;
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
        return "class Pikeman";
    }
}
