package com.javatasks;

import com.javatasks.products.*;
import com.javatasks.products.comparators.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProductList {
    private LinkedList<Product> productList;

    {
        productList = new LinkedList<Product>();
    }

    ProductList() {

    }

    ProductList(LinkedList<Product> _productList){
        productList = _productList;
    }

    ProductList(Product product) {
        productList.add(product);
    }

    public void add(Product product) {
        for(Product x : productList) {
            if(x.equals(product)) return;
        }
        productList.add(product);
    }

    public Product get(int index) {
        return productList.get(index);
    }

    @Override
    public String toString() {
        String s = "";
        int i = 0;
        for (Product product : productList)
            s += (++i + ") " + product.toString() + "\n");
        return s;
    }

    public void remove(int id) {
        productList.remove(getProductById(id));
    }

    public void remove(List<Integer> ids) {
        for (int i : ids)
            remove(i);
    }

    private Product getProductById(int id){
        Product outProduct = null;
        for(Product x: productList){
            if(x.getId() == id)
                outProduct = x;
        }
        return outProduct;
    }

    public void change(int index, Product product) {
        productList.remove(index);
        productList.add(index, product);
    }

    public void sortByPrice() {
        Collections.sort(productList, new ProductPriceComparator());
    }

    public void  sortById() {
        Collections.sort(productList, new ProductIdComparator());
    }

    public LinkedList<Product> FilterBy(BigDecimal minPrice, BigDecimal maxPrice){
        LinkedList<Product> filteredList = (LinkedList<Product>)productList.clone();
        filteredList.removeIf(x -> (x.getPrice().compareTo(minPrice) < 0) || (x.getPrice().compareTo(maxPrice) > 0));
        return filteredList;
    }

    public void show(){
        int index = 1;
        for(Product x: productList){
            System.out.println("" + (index++) + ")");
            x.print();
        }
    }
}
