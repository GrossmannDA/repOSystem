package com.company.view;

import com.company.model.Card;

public class CardView {

  private final Card card;

  public CardView(Card card) {
    this.card = card;
  }

  public String getCardNameOnly() {
    return String.format("Card - \"%s\"", card.getCardName());
  }

  public String getCardNameWithDescription() {
    return String.format("Card - \"%s\": %s", card.getCardName(), card.getCardDescription());
  }
}
