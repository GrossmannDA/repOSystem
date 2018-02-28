package com.company.service;

import com.company.model.Card;
import com.company.model.Screen;
import com.company.view.CardView;

public class CardService {

  Card card;
  CardView cardView;
  Screen screen;
  public CardView createCard(String cardName, int boardLocation, int listLocation) {

    card = new Card(cardName);
    cardView = new CardView(card);
    screen= Screen.getInstance();

    screen.getAllBoards().get(boardLocation).getBoardlist().get(listLocation).addListCard(card);

    return cardView;
  }
}
