package com.company.service;

import com.company.model.Board;
import com.company.persistance.PersistanceState;

// kann auch model zurückgeben. Normalerweise wird immer das Model zurückgegeben.
public class BoardService {
// hier link to PersistanceState
PersistanceState persistanceState;
// keine Status sollen hier gespeichert werden.


  public Board createBoard(String boardName) {

    Board board = new Board(boardName);
    persistanceState.getScreen().getAllBoards().add(board);

    return board;

  }
}
