import java.util.Random;

abstract class Heroes implements Step{
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
    protected String getInfo(){
        return String.format("Name: %s, hp: %d, stamina: %d, agility: %d, intellect: %d, strange: %d, initiative: %d", this.name, this.hp, this.stamina, this.agility, this.intellect,
                this.strange, this.initiative);
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
    protected boolean isDead(Heroes hero){
        if(this.hp < 1){
            return true;
        }
        else{
            return false;
        }
    }
    protected int getInitiative(){
        return this.initiative;
    }
}
