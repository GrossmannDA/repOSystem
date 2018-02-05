package com.company.presentation.model;

public class Card extends Model {

  private String cardName;
  private String cardDescription;
  private String comment;
  private int assignt_to_list;

  public Card(String cardName) {
    this.cardName = cardName;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
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

  public int getAssignt_to_list() {
    return assignt_to_list;
  }

  public void setAssignt_to_list(int assignt_to_list) {
    this.assignt_to_list = assignt_to_list;
  }
}
