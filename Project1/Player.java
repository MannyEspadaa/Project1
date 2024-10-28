public abstract class Player extends Entity {
    private int speed;
    private int health;
    private int attack;
    private int defense;
    private Room currentRoom;
    public Player(int speed, int health, int attack, int defense){
        setSpeed(speed);
        setHealth(health);
        setAttack(attack);
        setDefense(defense);
        
    }
    public int getHealth() {
        return health;
    }
    public int setHealth(int health){
        this.health = health;
        return health;
    }
    public void damageTaken(int damage){
        this.health -= damage;
    }
    public void PlayerAttack(Entity monster) {
        monster.damageTaken(monster.getAttack());
    }
    
    
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
    @Override
    public abstract void attack(Entity entity);
}
