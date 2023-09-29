package org.example;

public class Board {
    private char[][] grid;
    private int numRows;
    private int numColumns;

    public Board(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        grid = new char[numRows][numColumns];
        initialize();
    }

    private void initialize() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                grid[row][col] = ' ';
            }
        }
    }

    public void putToken( Coordinate coordinate, Color color){
        System.out.println("esta es la coordenadaaaa");
        System.out.println(coordinate);
    }

    public boolean makeMove(int column, Player player) {

        System.out.println("este es el player piece ");
        System.out.println(player);
        System.out.println(player.getPiece());
        for (int row = numRows - 1; row >= 0; row--) {
            if (grid[row][column] == ' ') {
                grid[row][column] = (player.getPiece()=="X") ? 'X' : 'O';
                return true;
            }
        }
        return false;
    }

    public boolean checkForWin(Color color) {
        //verificar victoria en filas, columnas y diagonales

        return false;
    }

    public boolean isEmpty(Coordinate coordinate){
        return true;
    }

    public boolean isFull() {
        for (int col = 0; col < numColumns; col++) {
            if (grid[0][col] == ' ') {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                System.out.print(grid[row][col] + "|");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}

