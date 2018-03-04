package com.company.controller;

import com.company.controller.state.ActualApplicationStateService;
import com.company.service.CardService;
import com.company.view.CardView;
import java.util.Optional;

public class CardController {

  CardView cardView;
  CardService cardService = new CardService();
  ActualApplicationStateService actualApplicationStateService = new ActualApplicationStateService();

  public Optional<CardView>  createNewCard(String cardName, int boardLocation, int listLocation) {
    cardView = cardService.createCard(cardName, boardLocation, listLocation);
    /*if(!cardView.equals(null)) {
      actualApplicationStateService
          .setPersistanceState(ResponseState.CARD_CREATED_SUCCSES_STATE.getState());
    }else
    {
      actualApplicationStateService.setPersistanceState(ResponseState.CARD_CREATED_FALLURE_STATE.getState());
   } */
    return Optional.ofNullable(cardView);
  }
}
