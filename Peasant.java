public class Peasant extends Heroes{

    protected Peasant(String name, int hp, int stamina, int agility, int intellect, int strange) {
        super(name, hp, stamina, agility, intellect, strange);
    }

    @Override
    protected int attack(Heroes target) {
        return super.attack(target);
    }

    public String toString() {
        return "class Peasant";
    }

}
