package com.assignment.Hibernate2.task1;

import org.hibernate.cfg.*;
import org.hibernate.*;
import org.hibernate.service.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {

	public static void main(String[] args) {
		Category cat1 = new Category();
        cat1.setCatId(1);
        cat1.setCatName("Drinks");

        Category cat2 = new Category();
        cat2.setCatId(2);
        cat2.setCatName("Milk");



        Product prod1 = new Product();
        prod1.setProdId(1);
        prod1.setProdName("Sugar");

        Product prod2 = new Product();
        prod2.setProdId(2);
        prod2.setProdName("Almond");



        Product prod3 = new Product();
        prod3.setProdId(4);
        prod3.setProdName("Cashew");

        Supplier sup1 = new Supplier();
        sup1.setSupplierId(1);
        sup1.setSupplierName("Supplier1");

        Supplier sup2 = new Supplier();
        sup2.setSupplierId(2);
        sup2.setSupplierName("Supplier2");


        cat1.getSupplist().add(sup1);
        cat1.getSupplist().add(sup2);
        cat2.getSupplist().add(sup1);
        cat2.getSupplist().add(sup2);

        cat1.setProdObj(prod1);
        cat2.setProdObj(prod1);


        prod1.getCatlist().add(cat1);
        prod1.getCatlist().add(cat2);



        sup1.getCatm2m().add(cat1);
        sup1.getCatm2m().add(cat2);
        sup2.getCatm2m().add(cat1);
        sup2.getCatm2m().add(cat2);

        Configuration config = (new Configuration().configure().addAnnotatedClass(Category.class)
                .addAnnotatedClass(Supplier.class)
                .addAnnotatedClass(Product.class));

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sfactory = config.buildSessionFactory(registry);
        Session session = sfactory.openSession();
        session.beginTransaction();

        session.save(cat1);
        session.save(cat2);

        session.save(prod1);
        session.save(prod2);
        session.save(prod3);

        session.save(sup1);
        session.save(sup2);
        session.getTransaction().commit();
    }

}
