public class Hero extends Player {
    public Hero(int speed, int health, int attack, int defense) {
        super(speed, health, attack, defense);
    }

    @Override
    public void attack(Entity entity) {
        int damage = getAttack();
        entity.damageTaken(damage);
    }

    @Override
    public void damageTaken(int damage) {
        super.damageTaken(damage); 
    }
}
