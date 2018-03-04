package com.company.service;

import com.company.model.Card;
import com.company.persistance.PersistanceState;
import com.company.view.CardView;

public class CardService {

  Card card;
  CardView cardView;
  PersistanceState persistanceState;

  public CardView createCard(String cardName, int boardLocation, int listLocation) {

    card = new Card(cardName);
    cardView = new CardView(card);

    persistanceState.getScreen().getAllBoards().get(boardLocation).getBoardlist().get(listLocation).addListCard(card);

    return cardView;
  }
}
