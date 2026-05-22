package org.example.models;

import org.example.interfaces.IProduct;

public class Node {
    private IProduct product;
    private int quantity;

    public Node( IProduct product,int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public IProduct getProduct() {
        return product;
    }

    public void setProduct(IProduct product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
