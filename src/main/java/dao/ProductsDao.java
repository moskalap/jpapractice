package dao;

import model.*;
import org.hibernate.*;
import org.hibernate.engine.spi.RowSelection;
import org.hibernate.query.ParameterMetadata;
import org.hibernate.query.Query;
import org.hibernate.query.QueryParameter;
import org.hibernate.query.QueryProducer;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;
import sun.java2d.loops.TransformBlit;

import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Parameter;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Stream;

public class ProductsDao {
    final Session session = MySessionFactory.getSession();
    public Product createProduct(String productName, int units, Supplier supplier ){
        Product p = new Product(productName, units);
        org.hibernate.Transaction t = session.beginTransaction();
        supplier.getProducts().add(p);
        session.save(p);
        t.commit();
        return p;
    }
    public Product findProductById(int id){
      return session.get(Product.class, id);
    }
    public void removeProduct(int id){
        session.delete(findProductById(id));
    }

    public void updatePrice(int productId, BigDecimal newPrice){
        org.hibernate.Transaction t = session.beginTransaction();
        Product p  = findProductById(productId);
        p.setUnitPrice(newPrice);
        session.merge(p);
        t.commit();
    }

}
