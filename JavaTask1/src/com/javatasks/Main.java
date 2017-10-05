package com.javatasks;

public class Main {

    public static void main(String[] args) {
	ProductList list = new ProductList();
    UI ui = UI.getInstance(list);
    ui.startMenu();
    }
}
