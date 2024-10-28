import java.util.Random;

public class DungeonFloor {
    private Room head;
    private Room exitRoom;
    private Random random;
    private int difficulty;
    public DungeonFloor(int difficulty) {
        this.random = new Random();
        this.difficulty = difficulty;
        initializeRooms();
    }
    private void initializeRooms() {
        Room previousRoom = null;
        for (int i = 1; i < 12; i++) {
            Room newRoom;
            if (i == 11) {
                newRoom = new Room(null); 
                exitRoom = newRoom;
            } else {
                newRoom = new Room(random.nextBoolean() ? getRandomEntity() : getRandomItem());
            }

            if (head == null) {
                head = newRoom;
            } else {
                previousRoom.next = newRoom;
                newRoom.prev = previousRoom;
            }
            previousRoom = newRoom;
        }

        
        if (previousRoom != null) {
            previousRoom.next = head; 
            head.prev = previousRoom; 
        }
    }   
    public Room getHead() {
        return head;
    }

    private Entity getRandomEntity() {
        switch (random.nextInt(4)) {
            case 0: return new Bat();
            case 1: return new Mimic();
            case 2: return new Slime();
            case 3: return new SkeletonDino();
            default: return null;
        }
    }

    private Items getRandomItem() {
        switch (random.nextInt(4)) { 
            case 0: return new Sword(5); 
            case 1: return new Potion();
            case 2: return new Shield(5);
            case 3: return new BanishmentScroll();
            default: return null;
            }
    }

    public Room getRoom(int index) {
        Room current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public Room getExitRoom() {
        return exitRoom;
    }
}
