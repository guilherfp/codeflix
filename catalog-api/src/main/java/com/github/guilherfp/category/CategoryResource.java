package com.github.guilherfp.category;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/api/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

  @Inject
  private CategoryService categoryService;

  @GET
  public List<Category> list() {
    return Category.listAll();
  }

  @POST
  @Transactional
  public void add(CategoryDTO dto) {
    this.categoryService.create(dto);
  }

  @PUT
  @Path("{id}")
  @Transactional
  public void update(@PathParam("id") UUID id, CategoryDTO dto) {
    this.categoryService.update(id, dto);
  }


  @DELETE
  @Path("{id}")
  @Transactional
  public void delete(@PathParam("id") UUID id) {
    this.categoryService.delete(id);
  }
}