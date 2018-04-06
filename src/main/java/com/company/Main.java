package com.company;

import com.company.controller.DistributeController;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) throws IOException {
    LOGGER.info("My first log");
    DistributeController distributeController = new DistributeController();
  }
}
