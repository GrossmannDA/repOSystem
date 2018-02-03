package com.company.presentation.model;

import java.util.ArrayList;
import java.util.List;

public class Board extends Model {

  private String boardName;
  private int listPosition;

  private List<Boardlist> boardlist = new ArrayList<>();


  public Board(String boardName) {
    this.boardName = boardName;
  }

  public void addBoardlist(Boardlist board_list) {

    boardlist.add(board_list);
  }

  public List<Boardlist> getBoardlist() {
    return boardlist;
  }

  @Override
  public String toString() {
    return "Board{" +
        "boardName='" + boardName + '\'' +

        '}';
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getBoardName() {
    return boardName;
  }

  public int getListPosition() {
    return listPosition;
  }

  public void setListPosition(int listPosition) {
    this.listPosition = listPosition;
  }
}
