package app;


import dao.CompanyDao;
import dao.MySessionFactory;
import dao.ProductsDao;
import dao.TransactionsDao;
import model.Company;
import model.Customer;
import model.Product;
import model.Supplier;
import spark.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;

import static spark.Spark.*;

public class App {

public static void main(String[] args){


    port(8108);
    org.apache.log4j.BasicConfigurator.configure();
    staticFiles.externalLocation(System.getProperty("user.dir") + "/src/main/resources/public");


    get("/", (req, res) -> {
        res.redirect("/index.html");
        return null;
    });





}
}
