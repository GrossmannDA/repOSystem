package com.company.service;

import com.company.model.Board;
import com.company.model.Screen;
import com.company.view.BoardView;

public class BoardService {
  Screen screen = Screen.getInstance();
  Board board;
  BoardView boardView;

  public BoardView createBoard(String boardName) {

    board = new Board(boardName);
    screen.getAllBoards().add(board);

    boardView = new BoardView(board);

    return boardView;

  }
}
