public class Slime extends Entity {
    public Slime() {
        setSpeed(10);
        setHealth(3);
        setAttack(2);
        setDefense(1);
    }
    @Override
    public void attack(Entity entity){
        int damage = getAttack() - entity.getDefense();
        entity.damageTaken(damage);
        System.out.println("The slime spits jelly against your arm : -" + damage + "hp : New Hp = " + entity.getHealth());
    }
    @Override
    public void damageTaken(int damage) {
        int damageDone = damage - getDefense();
        if(damageDone < 0){
            damageDone = 1;
            setHealth(getHealth() - damageDone);
            System.out.println("-" + damageDone);
        }else {
            setHealth(getHealth() - damageDone);
            System.out.println("-" + damageDone);
        }
        
        
    }
}