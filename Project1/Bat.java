import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Bat extends Entity {
    private final Random ran = new Random();
    private int RabDur = 5; 
    private int RabDam = 1; 

    public Bat() {
        setSpeed(10);
        setHealth(3);
        setAttack(2);
        setDefense(1);
    }

    @Override
    public void attack(Entity entity) {
        int damage = getAttack() - entity.getDefense();
        entity.damageTaken(damage);
        System.out.println("The bat bit your neck : - " + damage + "HP : new hp =" + entity.getHealth());

        
        if (ran.nextInt(100) < 5) {
            rabies(entity);
        }
    }

    @Override
    public void damageTaken(int damage) {
        int damageDone = damage - getDefense();
        if (damageDone < 0) {
            damageDone = 1;
        }
        setHealth(getHealth() - damageDone);
        System.out.println("-" + damageDone);
    }

    private void rabies(Entity entity) {
        System.out.println("The bat has given you Rabies.");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            private int secondsElapsed = 0;

            @Override
            public void run() {
                if (secondsElapsed < RabDur) {
                    entity.damageTaken(RabDam);
                    System.out.println("Rabies effect: -" + RabDam + "hp");
                    secondsElapsed++;
                } else {
                    timer.cancel();
                    System.out.println("You fought off the rabies.");
                }
            }
        }, 0, 1000);
    }
}