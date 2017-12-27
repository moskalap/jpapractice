package dao;

import model.Customer;
import model.Product;
import model.Tansaction;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class TransactionsDao {
    static final Session session = MySessionFactory.getSession();

    public Tansaction makeTransaction(Product p, Customer c, int quantity){
        Tansaction t = new Tansaction();
        t.setProduct(p);
        t.setQuantity(quantity);
        t.setCustomer(c);
        org.hibernate.Transaction thx = session.beginTransaction();
        session.save(t);
        thx.commit();
        return t;

    }
    public Tansaction findTransactionByNumber(int transationNo){
        return session.get(Tansaction.class, transationNo);
    }

    public void removeTansactionByNumber(int transactionNo){
        Transaction thx = session.beginTransaction();
        session.delete(findTransactionByNumber(transactionNo));
        thx.commit();
    }

    public double countTransactionsForCustomer(Customer customer){
        Query query = session.createQuery("from Tansaction where customer.id  = :customerId ");
        query.setParameter("customerId", customer.getId());
        List<Tansaction> list = query.list();
        return list.stream().mapToDouble(transaction ->
                transaction.getProduct().getUnitPrice().multiply(
                        BigDecimal.valueOf(transaction.getQuantity())).doubleValue()).sum()*(1 - customer.getDiscount());


    }


}
