package Person;

import Service.Coordinate;

import java.util.ArrayList;

public class Pikeman extends Heroes {
    protected int power;
    int maxHp = 75;

    public Pikeman(String name, int x, int y) {
        super(name, 75, 45, 40, 10, 35, x, y);
        this.initiative = 2;
        this.hp = maxHp;
    }

    @Override
    public int attack(Heroes target) {
        return super.attack(target) + 3;
    }

    @Override
    protected int heal(Heroes target) {
        return super.heal(target);
    }

    @Override
    public String toString() {
        return String.format("%s , Pikeman, \u2665 - %d", this.name, this.getHp());
    }


    @Override
    public void Step(ArrayList<Heroes> team, ArrayList<Heroes> frendly) {
        if (isDead(Pikeman.this)) return;
        Heroes target = team.get(findEnemy(team));
        int targetx = target.place.getX();
        int targety = target.place.getY();
        if (place.coordCalc(place.x, place.y, targetx, targety) < 2 && target.getHp() > 0) {
            team.get(findEnemy(team)).getDamage(attack(team.get(findEnemy(team))));
//            System.out.printf("Цель под индексом %s атакована! Находиться на коррдинатах %d, %d\n", findEnemy(team), targetx, targety);
            return;
        }
        Coordinate newcord = new Coordinate(place.x, place.y);
        Coordinate diff = place.getDifference(target.place);
        if (Math.abs(diff.x) > Math.abs(diff.y)) {
            newcord.x += diff.x < 0 ? 1 : -1;
        } else {
            newcord.y += diff.y < 0 ? 1 : -1;
        }
        for (Heroes heroes : frendly) {
            if (newcord.equals(heroes.place) && !isDead(heroes)) return;
        }
        place = newcord;

    }

    @Override
    public String getInfo() {
        return String.format("Копейщик, %s, class Pikeman", super.getInfo());
    }
}
