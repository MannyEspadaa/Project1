public class BanishmentScroll extends Items {
    public void use(Player player, DungeonGame game) {
        // Clear the current floor
        game.clearCurrentFloor();
        // Move to the next floor
        game.moveToNextFloor();
        System.out.println("You used the Exit Scroll and have been transported to the next floor!");
    }

    public void leave() {
        System.out.println("You decided to keep the Exit Scroll for later.");
    }
}