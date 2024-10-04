package lld.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int score;

    public void addCard(Card card){
        this.cards.add(card);
        if(card.getValue() == 1){
            score += (score+11 <= 21) ? 11 : 1;
        }
        else score += card.getValue();
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                ", score=" + score +
                '}';
    }
}
