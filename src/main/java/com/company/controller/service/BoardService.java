package com.company.controller.service;

import com.company.model.Board;
import com.company.model.Boardlist;

public class BoardService {

  Board board;

  public Board createNewBoard(String boardName) {

    board = new Board(boardName);

    return board;

  }

  public void addBoardListToBoard(Board board, Boardlist boardlist) {

    board.addBoardlist(boardlist);
  }

  public void updateBoardName(Board board, String newBoardName) {
    board.setBoardName(newBoardName);
  }

  public void removeBoardListFromBoard(Board board, Boardlist boardlist) {

    board.getBoardlist().remove(boardlist);
  }
}
