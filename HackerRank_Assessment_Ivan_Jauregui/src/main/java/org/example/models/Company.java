package org.example.models;

import org.example.interfaces.ICompany;
import org.example.interfaces.IProduct;
import org.example.interfaces.IUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity responsible for user management, inventory stock control,
 * and centralized purchase order processing.
 */
public class Company implements ICompany {
    private List<IUser> users;
    private List<Node> products;

    /**
     * Initializes a new company with empty user and product lists.
     */
    public Company() {
        this.users = new ArrayList<>();
        this.products =  new ArrayList<>();
    }

    @Override
    public List<IUser> getUsers() {
        return users;
    }

    @Override
    public void setUsers(List<IUser> users) {
        this.users = users;
    }

    @Override
    public List<Node> getProducts() {
        return products;
    }

    @Override
    public void setProducts(List<Node> products) {
        this.products = products;
    }

    /**
     * Increments the stock of an existing product in the inventory
     * or registers it as new if it is not found.
     *
     * @param product  The product to be added or updated.
     * @param quantity The number of units to add into the inventory.
     */
    @Override
    public void addProduct(IProduct product, int quantity) {
        Node existingNode = findProductById(product.getId());

        if (existingNode != null) {
            existingNode.setQuantity(existingNode.getQuantity() + quantity);
        } else {
            products.add(new Node(product, quantity));
        }
    }

    /**
     * Executes the transactional purchase workflow. Performs atomic validations
     * of stock and client balance before processing the payment and inventory deduction.
     *
     * @param order The list of nodes representing the requested products and quantities.
     * @param user  The customer placing the order.
     */
    @Override
    public void makeOrder(List<Node> order, IUser user) {
        // 1. Validate stock availability for all items in the order
        for (Node orderNode : order) {
            Node productOrderNode = findProductById(orderNode.getProduct().getId());
            if (productOrderNode == null || orderNode.getQuantity() > productOrderNode.getQuantity()) {
                return;
            }
        }

        double highestShippingCost = 0;
        double totalItemCost = 0;

        // 2. Calculate total costs by accumulating product totals and consolidating the highest shipping cost
        for (Node orderNode : order) {
            totalItemCost += orderNode.getProduct().getPrice() * orderNode.getQuantity();

            if (orderNode.getProduct().getShippingCost() > highestShippingCost) {
                highestShippingCost = orderNode.getProduct().getShippingCost();
            }
        }

        double total = highestShippingCost + totalItemCost;

        // 3. Verify user solvency
        if (user.getBalance() < total) {
            return;
        }

        // 4. Confirm transaction: deduct balance, reduce stock, and add to the user's order history
        user.setBalance(user.getBalance() - total);

        for (Node orderNode : order) {
            Node productOrderNode = findProductById(orderNode.getProduct().getId());
            productOrderNode.setQuantity(productOrderNode.getQuantity() - orderNode.getQuantity());

            user.getOrders().add(new Node(productOrderNode.getProduct(), orderNode.getQuantity()));
        }
    }

    /**
     * Searches for a specific product node within the inventory list using its ID.
     *
     * @param productId The unique identifier of the product.
     * @return The matching product node, or null if it does not exist.
     */
    private Node findProductById(int productId) {
        for (Node node : products) {
            if (node.getProduct().getId() == productId) {
                return node;
            }
        }
        return null;
    }
}