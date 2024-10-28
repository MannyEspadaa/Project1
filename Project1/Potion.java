import java.util.Random;

public class Potion extends Items {
    private Random random = new Random();
    @Override
    public void use(Player player) {
        int effectType = random.nextInt(6); 
        int effectValue = random.nextInt(3) + 1;

        switch (effectType) {
            case 0:
                player.setAttack(player.getAttack() + effectValue);
                System.out.println("Strength flows through you : Attack +" + effectValue);
                break;
            case 1:
                player.setDefense(player.getDefense() + effectValue);
                System.out.println("Your skin begins to harden : Defense +" + effectValue);
                break;
            case 2: 
                player.setHealth(player.getHealth() + effectValue);
                System.out.println("The angels have replenished you : Health +" + effectValue);
                break;
            case 3: 
                player.setSpeed(player.getSpeed() + effectValue);
                System.out.println("Lightning flows through your veins : Speed +" + effectValue);
                break;
            case 4: 
                int statToReduce = random.nextInt(4); 
                if (statToReduce == 0) {
                    player.setAttack(player.getAttack() - effectValue);
                    System.out.println("Your arms feel heavy : Attack -" + effectValue);
                } else if (statToReduce == 1) {
                    player.setDefense(player.getDefense() - effectValue);
                    System.out.println("Potion of weakness : Defense -" + effectValue);
                } else if (statToReduce == 2) {
                    player.setHealth(player.getHealth() - effectValue);
                    System.out.println("AHH Poison : Health -" + effectValue);
                } else {
                    player.setSpeed(player.getSpeed() - effectValue);
                    System.out.println("You feel as if your carrying the moutains on your back : Speed -" + effectValue);
                }
                break;
        }
    }
    @Override
    public void leave(Player player) {
        System.out.println("The Risk was too high, you left the potion.");
    }
}
