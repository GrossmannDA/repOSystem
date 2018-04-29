package com.company.controller;

import com.company.service.SaveOrLoadScreenService;
import com.company.view.ScreenView;

public class HomeController {

  private ScreenView screenView;
  private SaveOrLoadScreenService saveOrLoadScreenService;

  public ScreenView getPersistScreenView() {
    saveOrLoadScreenService = new SaveOrLoadScreenService();
    screenView = new ScreenView(saveOrLoadScreenService.getPersistScreen());
    return screenView;
  }
}
