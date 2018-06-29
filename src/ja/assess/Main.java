package ja.assess;

public class Main {

    public static void main(String[] args) {


        Game game = new Game(5,5);
        game.setMap();
        game.setPosTreasure();

        Player player = new Player();
        player.setPos();

        game.runGame();

    }
}
