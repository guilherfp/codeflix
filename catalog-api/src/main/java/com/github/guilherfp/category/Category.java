package com.github.guilherfp.category;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.github.guilherfp.BaseEntity;

/**
 * @author guilherfp
 */
@Entity
@Table(name = "category")
public class Category extends BaseEntity {

  private String name;
  private String description;

  protected Category() {
    super();
  }

  public Category(String name, String description) {
    this.name = name;
    this.description = description;
    initialize();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
