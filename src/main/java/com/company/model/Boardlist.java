package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Boardlist extends Model {

  private String boardlistName;

  private List<Card> listCard = new ArrayList<>();
  private int listId;

  public Boardlist(String boardlistName) {
    this.boardlistName = boardlistName;
  }

  public int getListId() {
    return listId;
  }

  public void setListId(int listId) {
    this.listId = listId;
  }

  public List<Card> getListCard() {
    return listCard;
  }

  public void addListCard(Card card) {
    listCard.add(card);
  }

  public String getBoardlistName() {
    return boardlistName;
  }

  public void setBoardlistName(String boardlistName) {
    this.boardlistName = boardlistName;
  }

  @Override
  public String toString() {
    return "Boardlist{" + "boardlistName='" + boardlistName + '\'' + '}';
  }
}
