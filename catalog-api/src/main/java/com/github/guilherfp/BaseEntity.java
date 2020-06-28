package com.github.guilherfp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@MappedSuperclass
public class BaseEntity extends PanacheEntityBase {

  @Id
  public UUID id;
  public boolean excluded;
  @Column(name = "created_at")
  private Instant createdAt;
  @Column(name = "updated_at")
  private Instant updatedAt;

  protected void initialize() {
    this.id = UUID.randomUUID();
    this.createdAt = Instant.now();
  }

  public UUID getId() {
    return id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void exclude() {
    this.excluded = true;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

}
