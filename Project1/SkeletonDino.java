public class SkeletonDino extends Entity {
    public SkeletonDino() {
        setSpeed(6);
        setHealth(20);
        setAttack(11);
        setDefense(16);
    }
    @Override
    public void attack(Entity entity){
        int damage = getAttack() - entity.getDefense();
        entity.damageTaken(damage);
        System.out.println("The Skeleton Dinosaur stomps on you : -" + damage + "hp : New HP = " + entity.getHealth());
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