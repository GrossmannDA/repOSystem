package com.company.controller.state;

/**
 * Dieser Service dient zur Aktualisierung des Anwendungsstatus
 */

public class ActualApplicationStateService {


  private UserState userState = new UserState();

  public String getUserState() {

    return userState.getState();
  }

  public void setUserState(String appsState) {
    userState.setState(appsState);
  }
}
