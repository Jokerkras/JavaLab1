package com.javatasks.products;


import java.math.BigDecimal;
import java.util.Scanner;

public class Scooter extends Product {

    private String name;
    protected int height;

    Scooter(int _id, BigDecimal _price, int _height) {
        super(_id,_price);
        height = _height;
        name = "Scooter";
    }

    public String getName(){return name;}

    @Override
    public  void print() {
        System.out.println(name);
        super.print();
        System.out.println("Height: " + height);
    }

    public void input() {
        super.input();

        System.out.print("Enter height: ");
        int buffer;
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt())
            buffer = in.nextInt();
        else {
            buffer = -1;
            in.next();
        }
        if (buffer < 0)
            this.height  = buffer;
        else {
            System.out.println("Entered wrong height!!!");
            this.height = -1;
            return;
        }
    }

    public void setHeight(int _height) {
        if (_height > 0)  height = _height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Scooter: " + super.toString() + " Height: " + height + "sm.";
    }
}
