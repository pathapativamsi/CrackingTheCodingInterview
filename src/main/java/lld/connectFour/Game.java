package lld.connectFour;


import lld.connectFour.constants.GridPosition;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Game {
    static Scanner input = new Scanner(System.in);
    private Grid grid;

    private int maxConnect = 4;
    private Player[] players;

    public Game(Grid grid) {
        this.grid = grid;
        this.players = new Player[]{
                new Player("prasanna", GridPosition.GREEN),
                new Player("vamsi", GridPosition.RED)
        };
    }

    private void printBoard(){
        System.out.println("Board:");
        int[][] grid = this.grid.getGrid();
        for (int i = 0; i < grid.length; i++) {
            String row = "";
            for (int piece : grid[i]) {
                if (piece == GridPosition.EMPTY.ordinal()) {
                    row += "0 ";
                } else if (piece == GridPosition.GREEN.ordinal()) {
                    row += "G ";
                } else if (piece == GridPosition.RED.ordinal()) {
                    row += "R ";
                }
            }
            System.out.println(row);
        }
        System.out.println();
    }

    private int[] playMove(Player player){
        printBoard();
        System.out.println(player.getName() +"'s turn ");
        System.out.println("Enter a col between 0 and "+String.valueOf(this.grid.getCols()-1)+"to add a piece");
        int placedColumn = input.nextInt();
        int row = grid.placepiece(placedColumn,player.getPosition());
        return new int[]{row, placedColumn};
    }

    public void play(){
        while (true){
            for(Player player: players){
                int[] pos = playMove(player);
                boolean didPlayerWin = this.grid.checkForWin(pos,maxConnect,player);
                if(didPlayerWin == true){
                    System.out.println(player.getName()+" Has won the game congratulations");
                    return;
                }
            }
        }
    }
}
