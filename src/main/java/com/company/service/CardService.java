package com.company.service;

import com.company.model.Card;

public class CardService {

  Card card;

  public Card createNewCard(String cardName) {
    return new Card(cardName);
  }


  public Card updateCardName(Card card, String updateName) {
    card.setCardName(updateName);
    return card;
  }

  public Card createCardComment(Card card, String cardComment) {
    card.addComment(cardComment);

    return card;
  }

  public Card updateCardComment(Card card, int selectedCardComment, String newComment) {

    String oldComment = card.getComment().get(selectedCardComment);

    card.getComment().set(selectedCardComment, newComment);

    return card;

  }

  public Card deleteCardComment(Card cardWithComment, int positionOfDeletadeComment) {

    cardWithComment.getComment().remove(positionOfDeletadeComment);

    return card;
  }

  public Card addDescription(Card card, String expectedDiscriprion) {

    card.setCardDescription(expectedDiscriprion);

    return card;
  }
}
