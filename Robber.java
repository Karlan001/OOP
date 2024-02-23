import java.util.ArrayList;

public class Robber extends Heroes {
    protected int speed;
    protected int dodge;

    protected Robber(String name, int x,int y) {
        super(name, 65, 45, 50, 10, 20, x, y);
        this.initiative = 2;
    }

    @Override
    protected int attack(Heroes target) {
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
        return name + ", class Robber, coordinate: " + place;
    }


    @Override
    public void Step(ArrayList<Heroes> team) {

    }
}
