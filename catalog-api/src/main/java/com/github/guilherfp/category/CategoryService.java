package com.github.guilherfp.category;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class CategoryService {

  public void create(CategoryDTO dto) {
    Category category = new Category(dto.name, dto.description);
    category.persist();
  }

  public void update(UUID id, CategoryDTO dto) {
    Category category = Category.findById(id);
    category.setName(dto.name);
    category.setDescription(dto.description);
    category.persist();
  }

  public void delete(UUID id) {
    Category category = Category.findById(id);
    category.exclude();
  }
}
