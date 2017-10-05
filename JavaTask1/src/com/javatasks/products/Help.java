package com.javatasks.products;

import java.math.BigDecimal;
import java.util.Scanner;

public class Help {

    public static final String ERROR_MESSAGE = "Incorrect value. Try again:";

    public static int getInt(String message, int min, int max){
        System.out.print(message);
        int buffer = -1;
        Scanner in = new Scanner(System.in);

        while (buffer < min || buffer > max) {
            if(buffer != -1)
                System.out.print("Repeat enter min - " + min + ", max - " + max);
            if (in.hasNextInt())
                buffer = in.nextInt();
            else {
                System.out.println(ERROR_MESSAGE);
                in.next();
            }
        }
        return buffer;
    }

    public static BigDecimal getBigDecimal(String message, BigDecimal min, BigDecimal max){
        System.out.print(message);
        BigDecimal buffer =new BigDecimal(-1);
        Scanner in = new Scanner(System.in);

        while (buffer.compareTo(min) < 0 || buffer.compareTo(max) > 0) {
            if (in.hasNextBigDecimal())
                buffer = in.nextBigDecimal();
            else
                in.next();
            //System.out.print(ERROR_MESSAGE);
        }
        return buffer;
    }

    public static Product inputBicycle(){
        int _id = getInt("Enter ID: ", 1, Integer.MAX_VALUE);
        BigDecimal _price = getBigDecimal("Enter price: ", new BigDecimal(1), new BigDecimal(1000000));
        int _maxWeight = getInt("Enter max weight: ",1,120);
        int _speed = getInt("Enter speed: ",1,21);

        return new Bicycle(_id, _price,_maxWeight, _speed);
    }

    public static Product inputBall(){
        int _id = getInt("Enter ID: ", 1, Integer.MAX_VALUE);
        BigDecimal _price = getBigDecimal("Enter price: ",new BigDecimal(1), new BigDecimal(1000000));
        int _size = getInt("Enter size: ",1,5);

        return new Ball(_id, _price,_size);
    }

    public static Product inputScooter(){
        int _id = getInt("Enter ID: ", 1, Integer.MAX_VALUE);
        BigDecimal _price = getBigDecimal("Enter price: ",new BigDecimal(1), new BigDecimal(1000000));
        int _height = getInt("Enter height: ",1,120);

        return new Scooter(_id, _price,_height);
    }
}
