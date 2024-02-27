import java.util.ArrayList;

public class Sniper extends Heroes {
    protected int accuracy;

    protected int stealthiness;
    int arrows = 10;

    public Sniper(String name, int x, int y) {
        super(name, 60, 40, 35, 10, 10, x, y);
        this.initiative = 3;
    }

    protected int attack(Heroes target) {
        int damage = random.nextInt(2,6);
        this.stamina -= random.nextInt(1, 3);
        return damage;
    }

    @Override
    protected String getInfo() {
        return String.format("%s, class Sniper", super.getInfo(), this.accuracy, this.stealthiness);
    }

    @Override
    public String toString() {
        return name + ", class Sniper, coordinate: " + place;
    }


    @Override
    public void Step(ArrayList<Heroes> target, ArrayList<Heroes> frendly) {
        if(!isDead(Sniper.this) && arrows > 0){
            target.get(findEnemy(target)).getDamage(attack(target.get(findEnemy(target))));
            Heroes tar = target.get(findEnemy(target));
            System.out.printf("Цель под индексом %s атакована! Находиться на коррдинатах %d, %d\n", findEnemy(target), tar.place.x, tar.place.y);
            arrows -= 1;
        }
    }
}
