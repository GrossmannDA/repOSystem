package com.company.view;

import com.company.model.Board;
import com.company.model.Boardlist;

public class BoardView {

  Board board;

  public BoardView(Board board) {
    this.board = board;


  }

  public String getBoardName() {

    return board.getBoardName();
  }

  public int getListPosition(Boardlist boardlist) {

    return board.getBoardlist().indexOf(boardlist);
  }

  public Boardlist getListByListPosition(Board board, int listPosition) {

    return board.getBoardlist().get(listPosition);
  }


}
