package org.example.models;

import org.example.interfaces.IUser;

import java.util.List;

public class User implements IUser {
    private int id;
    private String name;
    private double balance;
    private List<Node> orders;

    public User(int id, String name, double balance, List<Node> orders) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.orders = orders;
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
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance=balance;
    }

    @Override
    public List<Node> getOrders() {
        return orders;
    }

    @Override
    public void setOrders(List<Node> orders) {
        this.orders=orders;
    }
}
