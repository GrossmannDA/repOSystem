package com.company.controller;

import com.company.controller.state.ActualApplicationStateService;
import com.company.controller.state.RequestState;
import com.company.controller.state.ResponseState;
import com.company.view.CardView;
import com.company.view.CreateCardView;
import com.company.view.MenuView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

// singleton. dient nur zur Weiterleitung
public class DistributeController {

  // dieser service gehört nur zu diesem Controller
  ActualApplicationStateService actualApplicationStateService = new ActualApplicationStateService();
  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

  public DistributeController() throws IOException {
    // first initialisation > the main menu is shown
    String actualState = actualApplicationStateService.getUserState();
    if (actualState == null) {
      actualApplicationStateService.setUserState(ResponseState.START_APP_STATE.getState());
      MenuView menuView = new MenuView();
      menuView.startMenu();

    }
    requestMapping(bufferedReader.readLine());
  }

  public void requestMapping(String request) {
    CreateCardView createCardView = new CreateCardView();

    if (request.equals("1")) {
      actualApplicationStateService
          .setUserState(RequestState.REQUEST_CREATE_CARD_STATE.getRequestState());
      CardController cardController = new CardController();

      Optional<CardView> newCard = cardController.createNewCard("Card 1", 0, 0);
      if (newCard.isPresent()) {
        actualApplicationStateService
            .setUserState(ResponseState.CARD_CREATED_SUCCSES_STATE.getState());
      }

      if (actualApplicationStateService.getUserState()
          .equals(ResponseState.CARD_CREATED_SUCCSES_STATE.getState())) {
        createCardView.getCardCreatedSuccsesfullyNotification();
      }
      if (actualApplicationStateService.getUserState()
          .equals(ResponseState.CARD_CREATED_FALLURE_STATE.getState())) {
        createCardView.getCardCreatedFallureNotification();
      }

    }

  }

  public void respoceMapping() {

  }
}
