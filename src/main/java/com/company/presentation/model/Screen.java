package com.company.presentation.model;

import java.util.ArrayList;

/**
 * Create: 03.02.2018
 * The class Screen contains all Boards.
 * It knows about each boardposition within the Screen.
 * Screen can contain 0..n Boards
 */

public class Screen {

  private int boardPosition;
  private ArrayList<Board> allBoards;

  public Screen() {
    allBoards = new ArrayList<>();
  }

  public int getBoardPosition() {
    return boardPosition;
  }

  public void setBoardPosition(int boardPosition) {
    this.boardPosition = boardPosition;
  }


  public ArrayList<Board> getAllBoards() {
    return allBoards;
  }

  public void setAllBoards(ArrayList<Board> allBoards) {
    this.allBoards = allBoards;
  }
}
