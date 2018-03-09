package com.company.service;

import com.company.model.Board;
import com.company.model.Screen;
import com.company.persistance.PersistanceState;
import java.io.IOException;

// kann auch model zurückgeben. Normalerweise wird immer das Model zurückgegeben.
public class BoardService {

  // hier link to PersistanceState
  //PersistanceState persistanceState = PersistanceState.getInstance();
  // keine Status sollen hier gespeichert werden.
  Screen screen = PersistanceState.getInstance().getScreen();

  public BoardService() throws IOException, ClassNotFoundException {

  }

  public Board createBoard(String boardName) throws IOException, ClassNotFoundException {

    Board board = new Board(boardName);

    screen.getAllBoards().add(board);

    return board;
  }
}
