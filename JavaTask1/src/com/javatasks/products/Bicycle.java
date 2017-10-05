package com.javatasks.products;


import java.math.BigDecimal;
import java.util.Scanner;

public class Bicycle extends Product {

    private String name;
    protected int maxWeight;
    protected int speed;

    Bicycle(int _id, BigDecimal _price, int _maxWeight, int _speed) {
        super(_id,_price);
        maxWeight = _maxWeight;
        speed = _speed;
        name = "Bicycle";
    }

    public String getName(){return name;}

    @Override
    public  void print() {
        System.out.println(name);
        super.print();
        System.out.println("Max weight: " + maxWeight);
        System.out.println("Speed: " + speed);
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Enter maximum weight: ");
        int buffer;
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt())
            buffer = in.nextInt();
        else {
            buffer = -1;
            in.next();
        }
        if (buffer < 0)
            this.maxWeight  = buffer;
        else {
            System.out.println("Entered wrong maximum weight!!!");
            maxWeight = -1;
            return;
        }
        System.out.print("Enter speed: ");
        if (in.hasNextInt())
            buffer = in.nextInt();
        else {
            buffer = -1;
            in.next();
        }
        if (buffer < 0)
            this.speed  = buffer;
        else {
            System.out.println("Entered wrong speed!!!");
            this.speed = -1;
            return;
        }
    }

    public void setMaxWeight(int _maxWeight) {
        if (_maxWeight > 0)  maxWeight = _maxWeight;
    }

    public void setSpeed(int _speed) {
        if (_speed > 0)  speed = _speed;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Bicycle: " + super.toString() + "Max weight: " + maxWeight + "kg." + " Speed: " + speed;
    }
}
