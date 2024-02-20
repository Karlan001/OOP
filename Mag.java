public class Mag extends Heroes{
    protected int mana;
    protected int spell_speed;

    protected Mag(String name, int x, int y) {
        super(name, 50, 30, 25, 40, 10, x, y);
    }

    protected int attack(Heroes target) {
        int damage = random.nextInt(3,6);
        this.stamina -= random.nextInt(1, 3);
        return damage;
    }

    protected int spellAttack(Heroes target){
        int spellDamage = random.nextInt(5, 10);
        this.mana -= random.nextInt(1, 4);
        return spellDamage;
    }
    @Override
    protected String getInfo() {
        return String.format("%s, mana: %d, spell_speed: %d", super.getInfo(), this.mana, this.spell_speed);
    }

    @Override
    protected int heal(Heroes target) {
        return super.heal(target);
    }

    public String toString() {
        return name + ", class Mag, coordinate: " + place;
    }
}
