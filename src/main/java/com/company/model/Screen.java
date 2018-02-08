package com.company.model;

import java.util.ArrayList;

/**
 * Create: 03.02.2018 The class Screen contains all Boards. It knows about each boardposition within
 * the Screen. Screen can contain 0..n Boards
 */

public class Screen {

  private ArrayList<Board> allBoards;

  public Screen() {
    allBoards = new ArrayList<>();
  }

  public ArrayList<Board> getAllBoards() {
    return allBoards;
  }

  public void setAllBoards(ArrayList<Board> allBoards) {
    this.allBoards = allBoards;
  }
}
