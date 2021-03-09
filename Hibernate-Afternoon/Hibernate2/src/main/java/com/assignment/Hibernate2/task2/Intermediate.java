package com.assignment.Hibernate2.task2;

import org.hibernate.*;
import java.util.*;


public class Intermediate {
    public static void main(String args[]) {
        Session s = Util.getSession();

        Categories cat1 = new Categories();
        cat1.setCategoryId(1);
        cat1.setCategoryName("pizza");

        Categories cat2 = new Categories();
        cat2.setCategoryId(2);
        cat2.setCategoryName("burger");


        Item i1 = new Item();
        Item i2 = new Item();

        i1.setItemId(1);
        i1.setItemName("item1");

        i2.setItemId(2);
        i2.setItemName("item2");

        Set set = new HashSet();
        set.add(i1);
        set.add(i2);

        cat1.setItems(set);
        cat2.setItems(set);

        Transaction tx = s.beginTransaction();
        s.save(cat1);
        s.save(cat2);
        tx.commit();
        System.out.println("Many to Many has been resolved");
        s.close();
    }
}
