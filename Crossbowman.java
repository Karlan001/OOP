import java.util.ArrayList;

public class Crossbowman extends Heroes {
    protected int accuracy;
    protected int speed;

    protected Crossbowman(String name, int x, int y) {
        super(name, 80, 50, 45, 10, 50, x, y);
    }

    @Override
    protected int attack(Heroes target) {
        return super.attack(target);
    }

    protected int powerFullShot(){
        int damage = Heroes.random.nextInt(4, 8);
        this.agility -= 4;
        return damage;
    }

    public String toString() {
        return name + ", class Crossbowman, coordinate: " + place;
    }
    protected String findEnemy(ArrayList<Heroes> enemy){
        int minDistance = 10;
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
        return String.format("Ближайший противник к %s находится на расстоянии: %d и это %s",name, minDistance, clas);
    }

}
