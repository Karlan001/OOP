public class Monk extends Heroes{
    protected int mana;
    protected int efficiency;

    protected Monk(String name, int hp, int stamina, int agility, int intellect, int strange, int mana, int efficiency) {
        super(name, hp, stamina, agility, intellect, strange);
        this.mana = mana;
        this.efficiency = efficiency;
    }

    protected int buff(Heroes target){
            int buff = (int) (efficiency * 0.2);
            this.mana -= 5;
        return buff;
    }

    @Override
    protected int attack(Heroes target) {
        this.stamina -= 3;
        return super.attack(target) * ((int) (efficiency * 0.22));
    }

    @Override
    protected int heal(Heroes target) {
        return super.heal(target);
    }

    @Override
    public String toString() {
        return "class Monk";
    }
}
