public class Mimic extends Entity {
    public Mimic() {
        setSpeed(1);
        setHealth(5);
        setAttack(7);
        setDefense(9);
    }
    @Override
    public void attack(Entity entity){
        int damage = getAttack() - entity.getDefense();
        entity.damageTaken(damage);
        System.out.println("The mimic bites your ankle : -" + damage + "hp : New HP =" + entity.getHealth());
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