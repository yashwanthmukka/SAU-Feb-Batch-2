package com.assignment.Hibernate2.task1;

import java.util.*;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    private int catId;
    private String catName;

    @ManyToOne
    private Product prodObj;

    @ManyToMany(mappedBy = "catm2m")
    private List<Supplier> supplist = new ArrayList<>();


    public int getCatId() {
        return catId;
    }

    public List<Supplier> getSupplist() {
        return supplist;
    }

    public void setSupplist(List<Supplier> supplist) {
        this.supplist = supplist;
    }

    public Product getProdObj() {
        return prodObj;
    }

    public void setProdObj(Product prodObj) {
        this.prodObj = prodObj;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

}
