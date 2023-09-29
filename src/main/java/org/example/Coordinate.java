
package org.example;
import java.util.Scanner;




class Coordinate  {

    public static final int DIMENSION = 6;

    Coordinate column;

    Coordinate() {
        super();
    }

    Coordinate( int column) {
        super();
    }

    public Coordinate read(String message){
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);

        this.column= new Coordinate( scanner.nextInt());

        return this.column;


    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        return getClass() == obj.getClass();
    }

}

