public class BanishmentScroll extends Items {
    @Override
    public void use(Player player) {
        System.out.println("The banishment scroll has brought you to the next floor!");
    }
    @Override
    public void leave(Player player) {
        System.out.println("You leave the power of the scroll in the dark.");
    }
}