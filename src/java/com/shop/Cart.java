/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop;

import java.util.ArrayList;

/**
 *
 * @author son
 */
public class Cart {
    private ArrayList<Product>lstcart;
    public Cart(){
        lstcart = new ArrayList<Product>();
    }
    
    //add product to cart
    public void AddProduct(Product product){
        if (lstcart.contains(product)) {
            Product newProduct = lstcart.get(lstcart.indexOf(product));
            newProduct.setQuantity(newProduct.getQuantity()+product.getQuantity());
        }else{
            lstcart.add(product);
        }
    }
    
    public Product getProduct(int i){
        if (i<0||(i>lstcart.size()-1))
            return null;
        else{
            return lstcart.get(i);
        }
    }
    
    public int numberProduct(){
        return lstcart.size();
    }
    //total pricing
    public double totalPricing(){
        double money=0d;
        for(Product product:lstcart){
            money += (product.getPrice()*product.getQuantity());
        }
        return money;
    }
}
