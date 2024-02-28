package Person;

import java.util.ArrayList;

public class Mag extends Heroes {
    protected int mana;
    protected int spell_speed;

    public Mag(String name, int x, int y) {
        super(name, 50, 30, 25, 40, 10, x, y);
        this.initiative = 1;
    }

    protected int attack(Heroes target) {
        int damage = Heroes.random.nextInt(3,6);
        this.stamina -= Heroes.random.nextInt(1, 3);
        return damage;
    }

    protected int spellAttack(Heroes target){
        int spellDamage = Heroes.random.nextInt(5, 10);
        this.mana -= Heroes.random.nextInt(1, 4);
        return spellDamage;
    }
    @Override
    public String getInfo() {
        return String.format("%s, class Mag", super.getInfo());
    }

    @Override
    protected int heal(Heroes target) {
        return super.heal(target);
    }

    public String toString() {
        return name + ", class Mag, coordinate: " + place;
    }


    @Override
    public void Step(ArrayList<Heroes> team, ArrayList<Heroes> frendly) {

    }
}
