public class Shield extends Items {
    private int defenseBoost= 5;

    public Shield(int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }
    @Override
    public void use(Player player) {
        player.setDefense(player.getDefense() + defenseBoost);
        System.out.println("Lances shield welds to you arm like perfection, Defense + " + defenseBoost);
    }
    @Override
    public void leave(Player player) {
        System.out.println("You walk away as Lance's shield cries your name");
    }
}
