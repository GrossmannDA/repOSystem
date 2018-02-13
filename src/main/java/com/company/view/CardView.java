package com.company.view;

import com.company.model.Card;

public class CardView {

  Card card;

  public CardView(Card card) {
    this.card = card;
  }

  public String getCardName() {

    return "Card name: " + card.getCardName();
  }

  public void getMenuPointBoard(){
    System.out.println("3. Create Board: 3");
  }
}
