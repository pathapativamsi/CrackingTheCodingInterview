package lld.BlackJack;

import java.util.Scanner;

public class UserPlayer extends Player{

    Scanner input = new Scanner(System.in);
    public UserPlayer(Hand hand) {
        super(hand);
    }

    @Override
    boolean makeMove() {
        if (this.getHand().getScore() > 21) {
            return false;
        }
        System.out.print("Draw card? [y/n] ");
        String move = input.nextLine();
        return move.equals('y');
    }

}
