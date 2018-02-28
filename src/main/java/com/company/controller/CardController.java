package com.company.controller;

import com.company.service.CardService;
import com.company.view.CardView;

public class CardController {

  CardView cardView;
  CardService cardService = new CardService();

  public CardView createNewCard(String cardName, int boardLocation, int listLocation) {
    cardView = cardService.createCard(cardName, boardLocation, listLocation);
    return cardView;
  }
}
