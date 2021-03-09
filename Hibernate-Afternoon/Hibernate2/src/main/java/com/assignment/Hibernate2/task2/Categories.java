package com.assignment.Hibernate2.task2;

import javax.persistence.*;
import java.util.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;


@Entity
public class Categories {
  @Id
  @Column(name = "catid")
  private int categoryId;
  @Column(name = "catname", length = 10)
  private String categoryName;
  @ManyToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
  @JoinTable(name = "categories_items",
          joinColumns = @JoinColumn(referencedColumnName = "catid"),
          inverseJoinColumns = @JoinColumn(referencedColumnName = "itemid"))
  private Set<Item> items;

  public int getCategoryId() {
      return categoryId;
  }

  public void setCategoryId(int categoryId) {
      this.categoryId = categoryId;
  }

  public Set<Item> getItems() {
      return items;
  }

  public void setItems(Set<Item> items) {
      this.items = items;
  }

  public String getCategoryName() {
      return categoryName;
  }

  public void setCategoryName(String categoryname) {
      this.categoryName = categoryname;
  }

}