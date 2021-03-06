package com.company.controller;

import com.company.controller.state.ActualApplicationStateService;
import com.company.service.CardService;
import com.company.view.CardView;
import java.util.Optional;

public class CardController {

  private CardView cardView;
  private CardService cardService = new CardService();
  private ActualApplicationStateService actualApplicationStateService =
      new ActualApplicationStateService();

  public Optional<CardView> createNewCard(String cardName, int boardLocation, int listLocation) {
    cardView = new CardView(cardService.createCard(cardName, boardLocation, listLocation));

    return Optional.of(cardView);
  }
}
