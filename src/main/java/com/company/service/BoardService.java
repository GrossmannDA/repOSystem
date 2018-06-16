package com.company.service;

import com.company.model.Board;
import com.company.model.Screen;
import com.company.persistance.PersistanceState;

import java.util.Optional;

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

  public Optional<Board> findBoardByName(String name) {
    for (Board board : screen.getAllBoards()) {
      if (board.getBoardName().equals(name)) {
        return Optional.of(board);
      }
    }

    return Optional.empty();
  }
}
