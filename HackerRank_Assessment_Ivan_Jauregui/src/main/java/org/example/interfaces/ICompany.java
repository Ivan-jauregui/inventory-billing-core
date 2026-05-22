package org.example.interfaces;

import org.example.models.Node;

import java.util.List;

public interface ICompany {
    List<IUser> getUsers();
    void setUsers(List<IUser> users);

    List<Node> getProducts();
    void setProducts(List<Node> products);

    void addProduct(IProduct product , int quantity);

    void makeOrder(List<Node> order,IUser user);
}
