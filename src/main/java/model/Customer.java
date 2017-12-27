package model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends Company{
    @OneToMany
    private ArrayList<Transaction> transactions = new ArrayList();
    private float discount;

    public Customer() {
    }

    public Customer(int id, String companyName, Address address) {
        super(id, companyName, address);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
