package com.company.service;

import com.company.model.Board;
import com.company.model.Screen;
import com.company.persistance.PersistanceState;

// kann auch model zurückgeben. Normalerweise wird immer das Model zurückgegeben.
public class BoardService {

  // hier link to PersistanceState
  // PersistanceState persistanceState = PersistanceState.getInstance();
  // keine Status sollen hier gespeichert werden.
  private Screen screen = PersistanceState.getInstance().getScreen();

  public Board createBoard(String boardName) {

    Board board = new Board(boardName);

    screen.getAllBoards().add(board);

    return board;
  }
}
