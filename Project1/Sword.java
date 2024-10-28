public class Sword extends Items {
    private int attackBoost = 6;

    public Sword(int attackBoost) {
        this.attackBoost = attackBoost;
    }
    @Override
    public void use(Player player) {
        player.setAttack(player.getAttack() + attackBoost);
        System.out.println("You picked up Lance's Sword you feel the power surging! Attack +"
                + attackBoost);
    }
    @Override
    public void leave(Player player) {
        System.out.println("You walk away as Lance's sword screams your name");
    }
}
