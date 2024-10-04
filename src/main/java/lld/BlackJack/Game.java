package lld.BlackJack;

public class Game {
    Player player = new UserPlayer(new Hand());
    Player dealer = new Dealer(new Hand());

    static Deck deck = new Deck();

    private void drawInitialCards(){
        for(int i=0;i<2;i++){
            player.addCard(deck.draw());
            dealer.addCard(deck.draw());
        }
    }

    public void play(){
        while(!deck.cards.isEmpty()){
            boolean isPlayerWon = player.makeMove();
            if(isPlayerWon){
                System.out.println("Congratulations you won");
                break;
            }
            boolean isDealerWon = player.makeMove();
            if(isDealerWon){
                System.out.println("Dealer won!");
                break;
            }
        }
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.drawInitialCards();
        deck.shuffle();
        game.play();
    }
}
