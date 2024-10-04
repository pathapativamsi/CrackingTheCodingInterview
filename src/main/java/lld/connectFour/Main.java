package lld.connectFour;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Grid(8,8));
        game.play();
    }
}
