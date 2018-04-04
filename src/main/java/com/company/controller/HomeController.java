package com.company.controller;

import com.company.service.SaveOrLoadScreenService;
import com.company.view.print.MenuPrint;
import com.company.view.ScreenView;
import java.io.IOException;

public class HomeController {

  MenuPrint menuPrint;
  ScreenView screenView;
  SaveOrLoadScreenService saveOrLoadScreenService = new SaveOrLoadScreenService();

  public HomeController() throws IOException, ClassNotFoundException {
  }

  /**
   * This method load the saved screen
   * @return
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public ScreenView getPersistScreenView() throws IOException, ClassNotFoundException {
    screenView = new ScreenView(saveOrLoadScreenService.getPersistScreen());
    return screenView;
  }


}
