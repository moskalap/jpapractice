package model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Customer extends Company{
    @OneToMany
    private Set<Tansaction> transactions = new HashSet<>();
    private float discount;

    public Customer() {
    }

    public Customer(int id, String companyName, Address address) {
        super(id, companyName, address);
    }

    public Set<Tansaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Tansaction> transactions) {
        this.transactions = transactions;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
