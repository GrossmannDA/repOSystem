package com.company.presentation.model;

import java.io.Serializable;

public class Model implements Serializable{

  private static final long serialVersionUID = 5873411587451394152L;
  private  Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
