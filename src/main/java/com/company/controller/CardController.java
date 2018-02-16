package com.company.controller;

import com.company.model.Card;
import com.company.controller.service.CardService;

public class CardController {

  CardService cardService = new CardService();

  public CardView createCardUI(String cardDescriptionUI) {
    Card newCard = cardService.createNewCard(cardDescriptionUI);

  }
}
