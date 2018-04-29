package com.company.view;

import com.company.model.Card;

public class CardView {
Card card;

  public CardView(Card card) {
    this.card = card;
  }

  public String getCardName() {

    return card.getCardName();
  }
}
