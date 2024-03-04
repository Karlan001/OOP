package Person;

import java.util.ArrayList;

public class Mag extends Heroes {
    protected int mana;
    protected int spell_speed;
    protected int maxMana = 10;

    public Mag(String name, int x, int y) {
        super(name, 50, 30, 25, 40, 10, x, y);
        this.initiative = 1;
        this.mana = maxMana;
    }

    protected int attack(Heroes target) {
        int damage = Heroes.random.nextInt(3, 6);
        this.stamina -= Heroes.random.nextInt(1, 3);
        return damage;
    }

    protected int heal(Heroes target) {
        int heal = -5;
        return heal;
    }

    protected int spellAttack(Heroes target) {
        int spellDamage = Heroes.random.nextInt(5, 10);
        this.mana -= Heroes.random.nextInt(1, 4);
        return spellDamage;
    }

    @Override
    public String getInfo() {
        return String.format("Волшебник, %s, class Mag", super.getInfo());
    }

    public String toString() {
        return String.format("%s , Mag, \u2665 - %d, mana - %d", this.name, this.getHp(), this.mana);
    }


    @Override
    public void Step(ArrayList<Heroes> team, ArrayList<Heroes> frendly) {
        if (isDead(Mag.this)) return;
        ArrayList<Heroes> forHeal = new ArrayList<>(frendly);
        forHeal.sort((Heroes h1, Heroes h2) -> h1.getHp() - h2.getHp());
        System.out.println(forHeal.toString());
        for (Heroes hero : forHeal) {
            if (!isDead(hero) && mana >= 2) {
                System.out.println(hero.getHp());
                hero.getDamage(heal(hero));
                mana -= 2;
                System.out.println(hero.name + " Вылечен");
                System.out.println(hero.getHp());
            }
        }
        if (mana < maxMana) {
            mana++;
        }
    }
}
