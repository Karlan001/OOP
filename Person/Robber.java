package Person;

import Service.Coordinate;

import java.util.ArrayList;

public class Robber extends Heroes {
    protected int speed;
    protected int dodge;

    public Robber(String name, int x, int y) {
        super(name, 65, 45, 50, 10, 20, x, y);
        this.initiative = 2;
    }

    @Override
    public int attack(Heroes target) {
        return super.attack(target) + 3;
    }

//    @Override
//    protected String getInfo() {
//        return String.format("%s, dodge: %d, speed: %d", super.getInfo(), this.dodge, this.speed);
//    }

    protected String hide(){
        return "Скрылся";
    }

    public String toString() {
        return String.format("%s , Robber, \u2665 - %d", this.name, this.getHp());
    }


    @Override
    public void Step(ArrayList<Heroes> team, ArrayList<Heroes> frendly) {
        if (isDead(Robber.this)) return;
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
            if (heroes.place.equals(newcord)) return;
            else {
                place.x = newcord.x;
                place.y = newcord.y;
            }
        }
            
        }
    

    @Override
    public String getInfo() {
        return String.format("Бандит, %s, class Robber", super.getInfo());
    }
}
