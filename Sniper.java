import java.util.ArrayList;

public class Sniper extends Heroes{
    protected int accuracy;

    protected int stealthiness;

    public Sniper(String name, int x, int y) {
        super(name, 60, 40, 35, 10, 10, x, y);
    }

    protected int attack(Sniper target) {
        int damage = random.nextInt(2,6);
        this.stamina -= random.nextInt(1, 3);
        return damage;
    }

    @Override
    protected String getInfo() {
        return String.format("%s, accuracy: %d, stealthiness: %d", super.getInfo(), this.accuracy, this.stealthiness);
    }

    @Override
    public String toString() {
        return name + ", class Sniper, coordinate: " + place;
    }

    /**
     * Метод поиска ближайшего противнка к текущему объекту
     * @param enemy Массив объектов вражеской команды
     * @return Возвращает результат с расстоянием и информацией ближайшего противника
     */
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
