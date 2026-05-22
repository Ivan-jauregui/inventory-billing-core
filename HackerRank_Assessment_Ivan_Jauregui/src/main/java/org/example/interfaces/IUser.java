package org.example.interfaces;

import org.example.models.Node;

import java.util.List;

public interface IUser {
    int getId();
    void setId(int id);

    String getName();
    void setName(String name);

    double getBalance();
    void setBalance(double balance);

    List<Node> getOrders();
    void setOrders(List<Node> orders);

}
