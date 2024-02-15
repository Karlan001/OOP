public class Robber extends Heroes{
    protected int speed;
    protected int dodge;

    protected Robber(String name, int hp, int stamina, int agility, int intellect, int strange, int speed, int dodge) {
        super(name, hp, stamina, agility, intellect, strange);
        this.speed = speed;
        this.dodge = dodge;
    }

    @Override
    protected int attack(Heroes target) {
        return super.attack(target) + 3;
    }

    @Override
    protected String getInfo() {
        return String.format("%s, dodge: %d, speed: %d", super.getInfo(), this.dodge, this.speed);
    }

    protected String hide(){
        return "Скрылся";
    }

    public String toString() {
        return "class Robber";
    }


}
