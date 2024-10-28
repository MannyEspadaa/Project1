public abstract class Entity implements Interactables {
    private int speed;
    private int defense;
    private int attack;
    private int health;
    public int getSpeed(){
        return speed;
    }
    public int getDefense() {
        return defense;
    }
    public int getAttack(){
        return attack;
    }
    public int getHealth() {
        return health;
    }
    public int setSpeed(int speed){
        this.speed = speed;
        return speed;
    }
    public int setDefense(int defense){
        this.defense = defense;
        return defense;
    }
    public int setAttack(int attack){
        this.attack = attack;
        return attack;
    }
    public int setHealth(int health){
        this.health = health;
        return health;
    }
    public void levelUpEntities() {
        this.speed += 3;
        this.attack += 3;
        this.defense += 3;
        this.health += 3;
    }
    public abstract void attack(Entity entity);
    public abstract void damageTaken(int damage);
}