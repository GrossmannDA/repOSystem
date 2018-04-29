package com.company;


import com.company.controller.DistributeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {

  private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    LOGGER.info("My first log");
    DistributeController distributeController = new DistributeController();
  }
}
