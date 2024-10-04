package lld.BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    List<Card> cards;
    Random random = new Random();

    public Deck() {
        this.cards = new ArrayList<>();
        for(CardSuit suit: CardSuit.values()){
            for (int x=0; x<14;x++){
                cards.add(new Card(suit,x));
            }
        }
    }

    public void shuffle(){
        for(int x=0; x<cards.size();x++){
            int ran = random.nextInt(51);
            Card temp = cards.get(x);
            cards.set(x,cards.get(ran));
            cards.set(ran,temp);

        }
    }

    public Card draw(){
        return cards.remove(cards.size()-1);
    }

    public List<Card> getCards() {
        return cards;
    }

}
