package dao;

import model.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class CompanyDao {
    final Session session = MySessionFactory.getSession();

    public Supplier createSupplier(String city, String zipCode, String street, String bankAccount, String companyName){
        Supplier s = new Supplier();
        Address a = new Address();
        a.setCity(city);
        a.setZipCode(zipCode);
        a.setStreet(street);
        s.setAddress(a);
        s.setCompanyName(companyName);
        s.setBankAccount(bankAccount);
        org.hibernate.Transaction t = session.beginTransaction();
        session.save(s);
        t.commit();
        return s;

    }

    public Customer createCustomer(String city, String zipCode, String street, float discont, String companyName){
        Customer c = new Customer();
        c.setCompanyName(companyName);
        Address a = new Address();
        a.setCity(city);
        a.setZipCode(zipCode);
        a.setStreet(street);
        c.setAddress(a);
        c.setDiscount(discont);
        org.hibernate.Transaction t = session.beginTransaction();
        session.save(c);
        t.commit();
        return c;

    }
    public List<Tansaction> getTransactionForCompany(Company c){
        Query query = session.createQuery("from Tansaction where customer.id  = :customerId ");
        query.setParameter("customerId", c.getId());
        return query.list();
    }
}
