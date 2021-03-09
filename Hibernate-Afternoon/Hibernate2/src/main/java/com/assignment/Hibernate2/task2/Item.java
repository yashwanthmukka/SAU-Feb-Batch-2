package com.assignment.Hibernate2.task2;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

public class Item {
	@Id
    @Column(name = "itemid")
    private int itemId;
    @Column(name = "itemname", length = 10)
    private String itemName;
    @ManyToMany(targetEntity = Categories.class, mappedBy = "items")
    private Set<Categories> categories;

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
