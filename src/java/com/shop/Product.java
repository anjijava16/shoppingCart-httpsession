/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop;

/**
 *
 * @author son
 */
public class Product {
    private String name;
    private double  price;
    private int quantity;
    
    @Override
    public String toString(){
        return name+";"+price+";"+quantity;
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Product(String name, double price,int quantity){
        super();
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public Product(){
    
    }
    @Override
    public int hashCode(){
        final int prime =31;
        int result = 1;
        result = prime*result+((name==null)?0:name.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this ==obj) {
            return true;
        }
        if (obj ==null) {
            return false;
        }
        if (getClass()!=obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (name==null) {
            if (other.name!=null) {
                return false;
            }else if (!name.equals(other.name)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
