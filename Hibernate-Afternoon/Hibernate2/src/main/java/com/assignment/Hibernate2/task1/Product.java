package com.assignment.Hibernate2.task1;

import javax.persistence.*;
import java.util.*;

@Entity
public class Product {
    @Id
    private int prodId;
    private String prodName;

    @OneToMany (mappedBy = "prodObj")
    private List<Category> catlist = new ArrayList<>();

    public List<Category> getCatlist() {
        return catlist;
    }

        public void setCatlist(List<Category> catlist) {
        this.catlist = catlist;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
