package Person;

import java.util.ArrayList;
import java.util.Random;

import Service.Coordinate;
import Service.Step;

public abstract class Heroes implements Step {
    protected static Random random;
    protected String name;
    protected int hp;
    protected int stamina;
    protected int agility;

    protected int intellect;

    protected int strange;

    public Coordinate place;

    protected int initiative;

static {
    Heroes.random = new Random();
}

    protected Heroes(String name, int hp, int stamina, int agility, int intellect, int strange, int x, int y) {
        this.name = name;
        this.hp = hp;
        this.stamina = stamina;
        this.agility = agility;
        this.intellect = intellect;
        this.strange = strange;
        place = new Coordinate(x, y);
    }
    public String getInfo(){
        return String.format("Name: %s, hp: %d, stamina: %d, agility: %d, intellect: %d, strange: %d, initiative: %d, place: %d, %d", this.name, this.hp, this.stamina, this.agility, this.intellect,
                this.strange, this.initiative, this.place.x, this.place.y);
    }

    protected void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        else {
            this.hp = 0;
        }
    }

    protected int attack(Heroes target) {
        int damage = random.nextInt(1, 10);
        target.getDamage(damage);
        return damage;
    }
    protected int heal(Heroes target){
        int heal = random.nextInt(1, 4);
        return heal;

    }

    protected void getHeal(int heal){
        if (this.hp > 0){
            this.hp += heal;
        }
    }

    protected void getBuffHp(int buff){
        this.hp += buff;
    }
    protected boolean isDead(Heroes hero){
        if(this.hp < 1){
            return true;
        }
        else{
            return false;
        }
    }
    public int getInitiative(){
        return this.initiative;
    }

    /**
     * Метод поиска ближайшего противнка к текущему объекту
     * @param enemy Массив объектов вражеской команды
     * @return Возвращает результат с расстоянием и информацией ближайшего противника
     */
    protected int findEnemy(ArrayList<Heroes> enemy){
        int minDistance = 10;
        String clas = null;
        int index = 0;
        int xHero = this.place.getX();
        int yHero = this.place.getY();
        for (int i = 0; i < enemy.size(); i++) {
            int x = enemy.get(i).place.getX();
            int y = enemy.get(i).place.getY();
            if (place.coordCalc(xHero, yHero, x, y) < minDistance && enemy.get(i).getHp() > 0){
                minDistance = place.coordCalc(xHero, yHero, x, y);
                clas = enemy.get(i).toString();
                index = i;
            }
        }
        return index;
    }

    public int getHp() {
        return this.hp;
    }
}
