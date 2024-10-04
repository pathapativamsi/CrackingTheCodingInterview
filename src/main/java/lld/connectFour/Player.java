package lld.connectFour;

import lld.connectFour.constants.GridPosition;

public class Player {
    private String name;
    private GridPosition piece;

    public Player(String name, GridPosition piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public GridPosition getPosition() {
        return piece;
    }
}
