import java.util.Scanner;

public class DungeonGame {
    private DungeonFloor floor;
    private Player player;
    private int currentRoomIndex;
    private int difficulty;
    public DungeonGame(Player player) {
        this.floor = new DungeonFloor(difficulty);
        this.player = player;
        this.currentRoomIndex = 1;
    }
    public void start() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        Room currentRoom = floor.getRoom(currentRoomIndex);
        handleRoom(currentRoom, scanner);

        System.out.println("Use 'a' to go left, 'd' to go right, or 'q' to quit:");
        String input = scanner.nextLine();
        if (input.equals("q")) {
            break;
        } else if (input.equals("a")) {
            currentRoomIndex = (currentRoomIndex - 1 + 12) % 12;
        } else if (input.equals("d")) {
            currentRoomIndex = (currentRoomIndex + 1) % 12; 
        }
        }
        scanner.close();
    }
    private void handleRoom(Room room, Scanner scanner) {
        System.out.println("Entering room...");
        Object content = room.getContent();
        if (content instanceof Entity) {
            handleEntity((Entity) content, scanner);
        } else if (content instanceof Items) {
            handleItem((Items) content, scanner);
        } else {
            handleExit(scanner);
        }
    }
    private void handleEntity(Entity entity, Scanner scanner) {
        System.out.println("You encounter: " + entity.getClass().getSimpleName());
        System.out.println("Do you want to fight or flee? (fight/flee)");
        String action = scanner.nextLine();
        if (action.equals("fight")) {
            fight(entity, scanner); 
        } else {
            System.out.println("You fled from the " + entity.getClass().getSimpleName());
        }
    }

    private void handleItem(Items item, Scanner scanner) {
        System.out.println("You found an item: " + item.getClass().getSimpleName());
        System.out.println("Do you want to pick it up? (y/n)");
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            if(item instanceof BanishmentScroll) {
                clearFloor();
                nextFloor();
                item.use(player);
            }
            else if ( choice.equals("y")){
            item.use(player); 
            } else {
            item.leave(player);
            }
        }
    }

    private void handleExit(Scanner scanner) {
        System.out.println("You found the exit! Do you want to leave the floor? (y/n)");
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            System.out.println("You have left the floor!");
            levelUpEntities();
            difficulty += 10;
            floor = new DungeonFloor(difficulty);
            System.out.println("You have climbed to a new floor!");
            currentRoomIndex = 0;
        } else {
            System.out.println("You chose to continue exploring.");
        }
    }
    private void fight(Entity entity, Scanner scanner) {
        System.out.println("A " + entity.getClass().getSimpleName() + " challenges you!");

        boolean playerAttacksFirst = player.getSpeed() >= entity.getSpeed();

        while (entity.getHealth() > 0 && player.getHealth() > 0) {
            if (playerAttacksFirst) {
                
                System.out.println("you slash down on the " + entity.getClass().getSimpleName() + "!");
                player.attack(entity);

                
                if (entity.getHealth() <= 0) {
                    System.out.println("The " + entity.getClass().getSimpleName() + " has been defeated!");
                    levelUpPlayer(entity);
                    return;
                }
                entity.attack(player);
                } else {
                    entity.attack(player);
                if (player.getHealth() <= 0) {
                    System.out.println("The great " + entity.getClass().getSimpleName() + " has defeated you!");
                    System.exit(0);
                }
                System.out.println("you slash down on the " + entity.getClass().getSimpleName() + "!");
                player.attack(entity);
                if (entity.getHealth() <= 0) {
                    System.out.println("You defeated the " + entity.getClass().getSimpleName() + "!");
                    levelUpPlayer(entity); 
                    return;
                }
        }

        
        System.out.println("Your health: " + player.getHealth());
        System.out.println(entity.getClass().getSimpleName() + " health: " + entity.getHealth());
            }
    }

    
    private void levelUpPlayer(Entity entity) {
        if (entity instanceof Slime) {
            player.setAttack(player.getSpeed() + 1);
            System.out.println("You gained +1 speed from defeating the Slime!");
        } else if (entity instanceof Bat) {
            player.setDefense(player.getDefense() + 1);
            System.out.println("You gained +1 Defense from defeating the Bat!");
        } else if (entity instanceof Mimic) {
            player.setHealth(player.getHealth() + 2);
            player.setAttack(player.getAttack() + 2);
        System.out.println("You gained +2 Health and +2 Attack from defeating the Mimic!");
        } else if (entity instanceof SkeletonDino) {
            player.setAttack(player.getAttack() + 3);
            player.setDefense(player.getDefense() + 4);
            player.setSpeed(player.getSpeed() + 3);
            player.setHealth(player.getHealth() + 5);
            System.out.println("You feel the ancient energy rising in you. +3 attack , +4 defense, + 3 speed, + 5 health");
        }
    
    }
    public void clearFloor() {
        Room current = floor.getHead();
        for (int i = 0; i < 12; i++) {
            if (current != null) {
                current.content = null; 
                current = current.next; 
            }
        }
        System.out.println("The floor has became empty, your whispers follow through like a ghost.");
    }

    public void nextFloor() {
        floor = new DungeonFloor(difficulty);
        currentRoomIndex = 0; 
    }
        private void levelUpEntities() {
        Room current = floor.getHead();
        do {
            if (current.getContent() instanceof Entity) {
                ((Entity) current.getContent()).levelUpEntities();
            }
            current = current.next;
        } while (current != floor.getHead());
    }   
}
