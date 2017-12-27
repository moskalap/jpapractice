package app;

import dao.MySessionFactory;
import model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
public static void main(String[] args){
    final Session session = MySessionFactory.getSession();
    Transaction thx = session.beginTransaction();
    session.save(new Product("asdas",2));
    thx.commit();
    session.close();

}
}
