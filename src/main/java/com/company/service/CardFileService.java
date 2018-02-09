package com.company.service;

import com.company.data.CardDAO;
import com.company.presentation.model.Card;

public class CardFileService implements CardDAO {

  Card card;

  public Card getCard() {
    return card;
  }

  public void createCard(String cardName) {
    card = new Card(cardName);
  }
}
