package com.company.service;

import com.company.model.Screen;
import com.company.persistance.PersistanceState;
import java.io.IOException;

public class SaveOrLoadScreenService {
  // hier wird der screenLoad geladen
  private Screen screenLoad;

  public SaveOrLoadScreenService() {

    if (screenLoad == null) {
      screenLoad = PersistanceState.getInstance().getScreen();
    }
  }

  public Screen getPersistScreen() {
    return screenLoad;
  }

  public void save() throws IOException {
    PersistanceState.getInstance().persist();
  }
}
