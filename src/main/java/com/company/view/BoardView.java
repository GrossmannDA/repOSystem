package com.company.view;

import com.company.model.Board;

public class BoardView {

  Board board;

  public BoardView(Board board) {
    this.board = board;
  }

  public String getBoardName() {
    return board.getBoardName();
  }
}
