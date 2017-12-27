package model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;

public class Transaction {

    private int transactionNumber;
    private int quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Customer customer;

    public Transaction(int transactionNumber, int quantity, Product product, Customer customer) {
        this.transactionNumber = transactionNumber;
        this.quantity = quantity;
        this.product = product;
        this.customer = customer;
    }

    public Transaction() {

    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
