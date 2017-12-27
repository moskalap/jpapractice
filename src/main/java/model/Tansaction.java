package model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
public class Tansaction {
    @Id
    @GeneratedValue()
    private int id;
    private int quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Customer customer;

    public Tansaction(int quantity, Product product, Customer customer) {
        this.quantity = quantity;
        this.product = product;
        this.customer = customer;
    }

    public Tansaction() {

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
