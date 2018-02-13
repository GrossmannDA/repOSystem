package com.company.model;

import java.util.ArrayList;

public class Card extends Model {

  private String cardName;
  private String cardDescription;
  private ArrayList<String> comment = new ArrayList<>();


  public Card(String cardName) {
    this.cardName = cardName;
  }

  public ArrayList<String> getComment() {
    return comment;
  }

  public String getCardDescription() {
    return cardDescription;
  }

  public void setCardDescription(String cardDescription) {
    this.cardDescription = cardDescription;
  }

  public String getCardName() {
    return cardName;
  }

  public void setCardName(String cardName) {
    this.cardName = cardName;
  }

  @Override
  public String toString() {
    return "Card{" +
        "cardName='" + cardName + '\'' +
        ", cardDescription='" + cardDescription + '\'' +
        ", comment='" + comment + '\'' +
        '}';
  }

  public void addComment(String comment) {
    this.comment.add(comment);
  }


}
