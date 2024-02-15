import java.util.Random;

abstract class Heroes {
    protected static Random random;
    protected String name;
    protected int hp;
    protected int stamina;
    protected int agility;

    protected int intellect;

    protected int strange;

static {
    Heroes.random = new Random();
}

    protected Heroes(String name, int hp, int stamina, int agility, int intellect, int strange) {
        this.name = name;
        this.hp = hp;
        this.stamina = stamina;
        this.agility = agility;
        this.intellect = intellect;
        this.strange = strange;
    }
    protected String getInfo(){
        return String.format("Name: %s, hp: %d, stamina: %d, agility: %d, intellect: %d, strange: %d", this.name, this.hp, this.stamina, this.agility, this.intellect,
                this.strange);
    }

    protected void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
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
}
