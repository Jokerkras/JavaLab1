
package com.javatasks.products;
import java.math.BigDecimal;
import java.util.Scanner;

public abstract class Product {

    protected int id;
    protected BigDecimal price;

    Product(int _id,BigDecimal _price) {
        id = _id;
        price = _price.setScale(2);
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice (BigDecimal _price) {
        price = _price.setScale(2);
    }

    public void setId (int _id) {
        id = _id;
    }

    public int getId () {
        return id;
    }

    public void input() {

    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Price: " + price);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Product product = (Product)obj;
        return this.id == product.id;
    }

    @Override
    public String toString() {
        return "ID: " + id + "Price: " + price;
    }
/*
    /**
     *
     * @param d
     * @param precise
     * @return

    protected BigDecimal roundPrice (double d, int precise) {
        precise = 10^precise;
        d = d*precise;
        int i = (int) Math.round(d);
        return (double) i/precise;
    }
    protected double roundPrice(double d) {
        return roundPrice(d, 2);
    }
*/

}
