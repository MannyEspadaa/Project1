public class RunGame { 
    public static void main(String[] args) {
        Player player = new Hero(5, 20, 5, 3);
        DungeonGame game = new DungeonGame(player);
        game.start();
    }
    
}