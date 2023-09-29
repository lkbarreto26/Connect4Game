package org.example;

import java.util.Scanner;





 public class Player {
    private String name;
    private String piece;


     private Color color;
     private Board board;
     private int putTokens;

     Player(Color color, Board board) {
         assert !color.isNull();
         assert board != null;

         this.color = color;
         this.board = board;
         this.putTokens = 0;
     }

     void play() {
         if (this.putTokens < Coordinate.DIMENSION) {
             this.putToken();
         }else{
             System.out.println("tablero lleno");
         }
     }

     private void putToken() {
         Coordinate coordinate;
         Error error;
         do {
             coordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
             error = this.getPutTokenError(coordinate);
         } while (!error.isNull());
         this.board.putToken(coordinate, this.color);
         this.putTokens++;
     }

     Coordinate getCoordinate(Message message){

         Coordinate coordinate = new Coordinate();
         coordinate.read(message.toString());
         return coordinate;
     }

     private Error getPutTokenError(Coordinate coordinate) {
         assert coordinate != null;

         Error error = Error.NULL;
         if (!this.board.isEmpty(coordinate)) {
             error = Error.NOT_EMPTY;
         }
         error.writeln();
         return error;
     }

    public String getName() {
        return name;
    }

    public String getPiece() {
        return piece;
    }

    public int makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ", elige una columna (1-7): ");
        int column = scanner.nextInt();
        return column - 1;
    }

     void writeWinner() {
         Message.PLAYER_WIN.writeln(this.color.name());
     }

     Color getColor() {
         return this.color;
     }

 }
