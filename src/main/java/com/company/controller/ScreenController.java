package com.company.controller;

import com.company.service.SaveOrLoadScreenService;
import java.io.IOException;

public class ScreenController {

  //alle möglichen services
  SaveOrLoadScreenService saveOrLoadScreenService = new SaveOrLoadScreenService();

  public ScreenController() throws IOException, ClassNotFoundException {
  }

  public void saveScreen() throws IOException, ClassNotFoundException {

    saveOrLoadScreenService.save();
  }
}
