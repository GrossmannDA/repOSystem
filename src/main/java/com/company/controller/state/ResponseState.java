package com.company.controller.state;

public enum ResponseState {
  START_APP_STATE("0"),
  CARD_CREATED_SUCCSES_STATE("100"),
  CARD_CREATED_FALLURE_STATE("-100"),
  ;
  String state;

  ResponseState(String state) {

    this.state = state;
  }

  public String getState() {
    return state;
  }
}
