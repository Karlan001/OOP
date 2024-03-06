package Person;

import java.util.ArrayList;
import java.util.Comparator;

public class Monk extends Heroes {
    protected int mana;
    protected int efficiency;
    int maxHp = 65;
    int maxMana = 10;

    public Monk(String name, int x, int y) {
        super(name, 65, 40, 35, 10, 10, x, y);
        this.initiative = 1;
        this.mana = 10;
        this.hp = maxHp;
    }

    protected int buff(Heroes target){
            int buff = (int) (efficiency * 0.2);
            this.mana -= 5;
        return buff;
    }

    @Override
    public int attack(Heroes target) {
        this.stamina -= 3;
        return super.attack(target) * ((int) (efficiency * 0.22));
    }

    @Override
    protected int heal(Heroes target) {
        int heal = -7;
        return heal;
    }

    @Override
    public String toString() {
        return String.format("%s , Monk, \u2665 - %d, mana - %d", this.name, this.getHp(), this.mana);
    }


    @Override
    public void Step(ArrayList<Heroes> team, ArrayList<Heroes> frendly) {
        if (isDead(Monk.this)) return;
        ArrayList<Heroes> forHeal = new ArrayList<>(frendly);
        forHeal.sort(Comparator.comparingInt(Heroes::getHp));
        int count = 0;
        for (Heroes hero : forHeal) {
            if (!isDead(hero) && mana >= 2 && (hero.hp <= (int) (this.maxHp * 0.6))) {
                if (hero.getHp() >= maxHp) return;
                hero.getDamage(heal(hero));
                mana -= 2;
                System.out.println(hero.name + " Получил лечение");
                return;
            }
            if (isDead(hero)) {
                count++;
                if (count >= 3 && mana == maxMana) {
                    hero.getDamage(heal(hero));
                    mana -= maxMana;
                    System.out.println(this.name + " Воскресил - " + hero);
                    return;
                }
            }
        }
        if (mana < maxMana) mana++;
    }

    @Override
    public String getInfo() {
        return String.format("Шаман, %s, class Monk", super.getInfo());
    }
}
