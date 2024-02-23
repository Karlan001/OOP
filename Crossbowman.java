import java.util.ArrayList;

public class Crossbowman extends Heroes {
    protected int accuracy;
    protected int speed;
    int arrows = 8;

    protected Crossbowman(String name, int x, int y) {
        super(name, 80, 50, 45, 10, 50, x, y);
        this.initiative = 3;
    }

    @Override
    protected int attack(Heroes target) {
        return super.attack(target);
    }

    protected int powerFullShot(){
        int damage = random.nextInt(4, 8);
        this.agility -= 4;
        return damage;
    }

    public String toString() {
        return name + ", class Crossbowman, coordinate: " + place;
    }
    protected int findEnemy(ArrayList<Heroes> enemy){
        int minDistance = 10;
        int index = 0;
        String clas = null;
        int xSniper = this.place.getX();
        int ySniper = this.place.getY();
        for (int i = 0; i < enemy.size(); i++) {
            int x = enemy.get(i).place.getX();
            int y = enemy.get(i).place.getY();
            if (place.coordCalc(xSniper, ySniper, x, y) < minDistance){
                minDistance = place.coordCalc(xSniper, ySniper, x, y);
                clas = enemy.get(i).toString();
            }
        }
        return index;
    }


    @Override
    public void Step(ArrayList<Heroes> target) {
        if(!isDead(Crossbowman.this) && arrows > 0){
            target.get(findEnemy(target)).getDamage(attack(target.get(findEnemy(target))));
            System.out.printf("Цель атакована!");
            arrows -= 1;
        }
    }
}
