package com.javatasks.products;


import java.math.BigDecimal;
import java.util.Scanner;

public class Ball extends Product {

    private String name;
    protected int size;

    Ball(int _id, BigDecimal _price, int _size) {
        super(_id,_price);
        size = _size;
        name = "Ball";
    }

    public String getName(){return name;}

    @Override
    public  void print() {
        System.out.println(name);
        super.print();
        System.out.println("Size: " + size);
    }

    @Override
    public void input() {
        super.input();

        System.out.print("Enter size: ");
        int buffer;
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt())
            buffer = in.nextInt();
        else {
            buffer = -1;
            in.next();
        }
        if (buffer < 0 && buffer > 6)
            this.size  = buffer;
        else {
            System.out.println("Entered wrong size!!!");
            this.size = -1;
            return;
        }
    }

    public void setSize(int _size) {
        if ((_size > 0)&&(_size < 6 ))  size = _size;
    }


    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Ball: " + super.toString() + " Size: " + size + "inch";
    }
}
