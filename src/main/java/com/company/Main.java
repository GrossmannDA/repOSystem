package com.company;


import com.company.presentation.controller.BusinessLogic;
import com.company.service.BoardService;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    BusinessLogic businessLogic = new BusinessLogic(new BoardService());
    businessLogic.runApplication();
  }

}
