package com.company.controller;

import com.company.service.SaveOrLoadScreenService;
import java.io.IOException;

public class ScreenController {

  // alle möglichen services
  private SaveOrLoadScreenService saveOrLoadScreenService = new SaveOrLoadScreenService();

  public void saveScreen() throws IOException {

    saveOrLoadScreenService.save();
  }
}
