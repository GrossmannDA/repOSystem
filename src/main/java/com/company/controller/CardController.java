package com.company.controller;

import com.company.model.Card;
import com.company.service.CardService;

public class CardController {
CardService cardService = new CardService();

  public Card createCardUI(String cardDescriptionUI) {

    return cardService.createNewCard(cardDescriptionUI);
  }
}
