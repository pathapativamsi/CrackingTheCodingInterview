package lld.BlackJack;

public class Card {
    private final CardSuit suit;
    private final int value;

    public Card(CardSuit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }
}
