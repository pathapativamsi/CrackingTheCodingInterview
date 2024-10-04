package lld.connectFour;

import lld.connectFour.constants.GridPosition;

public class Grid {
    private int rows;
    private int cols;
    private int[][] grid;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initGrid();
    }

    public void initGrid(){
        this.grid = new int[rows][cols];
        for (int x=0; x< rows; x++){
            for(int y=0; y<cols;y++){
                grid[x][y] = GridPosition.EMPTY.ordinal();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int placepiece(int col, GridPosition piece){
        for(int r=rows-1; r>=0;r--){
            if(grid[r][col] == GridPosition.EMPTY.ordinal()){
                this.grid[r][col] = piece.ordinal();
                return r;
            }
        }

        return -1;
    }

    public boolean checkForWin(int[] pos, int maxConnect, Player player){
        int count = 0;
        //horizontal
        for(int x = 0; x< grid[0].length;x++){
            if(grid[pos[0]][x] == player.getPosition().ordinal()){
                count++;
            }
            else {
                count = 0;
            }
            if(count == maxConnect){
                return true;
            }
        }


        count=0;
        //vertical
        for(int x = 0; x< grid.length;x++){
            if(grid[x][pos[1]] == player.getPosition().ordinal()){
                count++;
            }
            else {
                count = 0;
            }
            if(count == maxConnect){
                return true;
            }
        }

        int row = pos[0];
        int col = pos[1];
        //diagonal
        for (int r = 0; r < this.rows; r++) {
            int c = row + col - r; // row + col = r + c, for a diagonal
            if (c >= 0 && c < this.cols && this.grid[r][c] == player.getPosition().ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == maxConnect) {
                return true;
            }
        }
        // Check anti-diagonal
        count = 0;
        for (int r = 0; r < this.rows; r++) {
            int c = col - row + r; // row - col = r - c, for an anti-diagonal
            if (c >= 0 && c < this.cols && this.grid[r][c] == player.getPosition().ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == maxConnect) {
                return true;
            }
        }
        return false;
    }
}
