package com.company.service;

import com.company.model.Card;
import com.company.persistance.PersistanceState;

public class CardService {

  private Card card;

  private PersistanceState screen = PersistanceState.getInstance();

  public Card createCard(String cardName, int boardLocation, int listLocation) {

    card = new Card(cardName);

    screen
        .getScreen()
        .getAllBoards()
        .get(boardLocation)
        .getBoardlist()
        .get(listLocation)
        .addListCard(card);

    return card;
  }
}
