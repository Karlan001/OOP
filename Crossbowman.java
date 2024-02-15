public class Crossbowman extends Heroes{
    protected int accuracy;
    protected int speed;

    protected Crossbowman(String name, int hp, int stamina, int agility, int intellect, int strange, int accuracy, int speed) {
        super(name, hp, stamina, agility, intellect, strange);
        this.accuracy = accuracy;
        this.speed = speed;
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
        return "class Crossbowman";
    }

}
