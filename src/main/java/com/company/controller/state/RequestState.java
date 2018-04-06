package com.company.controller.state;

public enum RequestState {
  REQUEST_CREATE_CARD_STATE("200");

  String requestState;

  RequestState(String requestState) {
    this.requestState = requestState;
  }

  public String getRequestState() {
    return requestState;
  }

  public void setRequestState(String requestState) {
    this.requestState = requestState;
  }
}
