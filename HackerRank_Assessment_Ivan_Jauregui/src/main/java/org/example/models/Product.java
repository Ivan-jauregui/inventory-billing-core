package org.example.models;

import org.example.interfaces.IProduct;

public class Product implements IProduct {
    private int id;
    private String name;
    private double price;
    private double shippingCost;

    public Product(int id, String name, double price, double shippingCost) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shippingCost = shippingCost;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public double getShippingCost() {
        return 0;
    }

    @Override
    public double setShippinCost(double shippinCost) {
        return 0;
    }
}
