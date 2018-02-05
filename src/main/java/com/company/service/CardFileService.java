package com.company.service;

import com.company.data.cardDAO;
import com.company.presentation.model.Card;

public class CardFileService implements cardDAO {

  Card card;

  public Card getCard() {
    return card;
  }

  public void createCard(String cardName) {
    card = new Card(cardName);
  }
}
