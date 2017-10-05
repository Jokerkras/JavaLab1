package com.javatasks;

import com.javatasks.products.Bicycle;
import com.javatasks.products.Help;
import com.javatasks.products.Product;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class UI {

    //Singleton
    public static  UI instance;
    private static ProductList productList;

    private UI(ProductList _productList) {
        productList = _productList;
    }

    public static UI getInstance(ProductList _productList) {
        if (instance==null) {
            instance = new UI(_productList);
        }
        return instance;
    }

    public void startMenu(){
        int buffer = -1;

        while(buffer!=0)
        {
            System.out.println("1) Add product");
            System.out.println("2) Remove product");
            System.out.println("3) Remove some products");
            System.out.println("4) Change product");
            System.out.println("5) Show list");
            System.out.println("6) Sort list");
            System.out.println("7) Filter list");
            System.out.println("0) Exit");

            buffer = Help.getInt("Enter a number: ", 0,7);

            switch (buffer)
            {
                case 1:
                    add();
                    break;
                case 2:
                    remove(Help.getInt("Enter id: ",1,Integer.MAX_VALUE));
                    break;
                case 3:
                    removeSome(getListToRemove());
                case 4:
                    change();
                    break;
                case 5:
                    show();
                    break;
                case 6:
                    sort();
                    break;
                case 7:
                    filter();
                    break;
                case 0: return;
                default: System.out.println(Help.ERROR_MESSAGE);
            }
        }
    }

    private void change() {

    }

    private void remove(int id) {
        productList.remove(id);
    }

    private List<Integer> getListToRemove(){
        List<Integer> listToRemove = new LinkedList<Integer>();
        int buffer = Help.getInt("Enter number(each number start with a new line, 0 - end):\n",1,Integer.MAX_VALUE);
        while (buffer != 0){
            listToRemove.add(new Integer(buffer));
            buffer = Help.getInt("",1,Integer.MAX_VALUE);
        }
        return listToRemove;
    }

    private void removeSome(List<Integer> ids){
        productList.remove(ids);
    }

    private void add() {
        System.out.println("1) Add bicycle");
        System.out.println("2) Add scooter");
        System.out.println("3) Add ball");
        System.out.println("0) Cancel");
        int buffer = Help.getInt("Enter: ", 0, 3);

        Product newProduct = null;
        switch(buffer) {
            case 1:
                newProduct = Help.inputBicycle();
                break;
            case 2:
                newProduct = Help.inputScooter();
                break;
            case 3:
                newProduct = Help.inputBall();
                break;
            case 0:
                break;
        }
        if(newProduct != null) {productList.add(newProduct);}
    }

    private void show() {
        productList.show();
    }

    private void sort() {
        System.out.println("1)By id");
        System.out.println("2)By price");
        System.out.println("0)Cancel");
        int buffer = Help.getInt("Enter: ",0,2);
        switch(buffer){
            case 1:
                productList.sortById();
                break;
            case 2:
                productList.sortByPrice();
                break;
            case 0:
                break;
        }
    }

    private void filter() {
        BigDecimal min = Help.getBigDecimal("Enter min price: ", new BigDecimal(1), new BigDecimal(1000000));
        BigDecimal max = Help.getBigDecimal("Enter max price: ", min, new BigDecimal(1000000));
        ProductList filteredList = new ProductList(productList.FilterBy(min,max));
        filteredList.show();
    }


}
