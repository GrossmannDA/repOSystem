package com.company.model;

import java.io.Serializable;

public class Model implements Serializable {

  private static final long serialVersionUID = 5873411587451394152L;
  protected Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
