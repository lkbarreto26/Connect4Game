package org.example;
import java.util.Scanner;


public class Connect4Game {
    private final Board board;

    //Player player1 = new Player("Jugador 1", "X");
   // Player player2 = new Player("Jugador 2", "O");
    Player currentPlayer;

    public Connect4Game(int numRows, int numColumns) {
        board = new Board(numRows, numColumns);
        currentPlayer = player1;
    }

    public boolean makeMove(int column) {
        return board.makeMove(column, currentPlayer);
    }

    public boolean checkForWin() {
        return false;//board.checkForWin(currentPlayer);
    }

    public boolean checkForDraw() {
        return board.isFull();
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void printBoard() {
        board.print();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void main(String[] args) {
        Connect4Game game = new Connect4Game(6, 7);
        game.printBoard();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Turno del  " + game.getCurrentPlayer().getName());
            System.out.print("Ingresa el número de columna (0-6) para hacer tu movimiento: ");

            int column = scanner.nextInt();

            if (column < 0 || column > 6) {
                System.out.println("Columna no válida. Inténtalo de nuevo.");
                continue;
            }

            if (!game.makeMove(column)) {
                System.out.println("Columna llena. Inténtalo de nuevo.");
                continue;
            }

            game.printBoard();

            if (game.checkForWin()) {
                System.out.println("¡El " + game.getCurrentPlayer().getName() + " ha ganado!");
                break;
            }

            if (game.checkForDraw()) {
                System.out.println("El juego ha terminado en empate.");
                break;
            }

            game.switchPlayer();
        }

        scanner.close();
    }
}



