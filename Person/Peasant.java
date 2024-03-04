package Person;

import java.util.ArrayList;

public class Peasant extends Heroes {
int arrows;
    public Peasant(String name, int x, int y) {
        super(name, 40, 20, 20, 5, 5, x, y);
        this.initiative = 0;
        this.arrows = 1;
    }

    @Override
    public int attack(Heroes target) {
        return super.attack(target);
    }

    public String toString() {
        return String.format("%s , Peasant, \u2665 - %d, arrows - %d", this.name, this.getHp(), this.arrows);
    }


    @Override
    public void Step(ArrayList<Heroes> team, ArrayList<Heroes> frendly) {
        if (!isDead(Peasant.this) && arrows > 0) {
            for (Heroes hero : frendly) {
                if (hero instanceof Sniper && !isDead(hero)){
                    if (((Sniper) hero).arrows < ((Sniper) hero).maxArrows){
                        ((Sniper)hero).arrows++;
                        arrows--;
                        return;
                    }
                }
                if (hero instanceof Crossbowman && !isDead(hero)){
                    if (((Crossbowman) hero).arrows < ((Crossbowman) hero).maxArrows){
                        ((Crossbowman)hero).arrows++;
                        arrows--;
                        return;
                    }
                }
            }
            return;
        }
        arrows++;
    }

    @Override
    public String getInfo() {
        return String.format("Рабочий, %s, class Peasant", super.getInfo());
    }
}
