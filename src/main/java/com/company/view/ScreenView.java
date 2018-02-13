package com.company.view;

import com.company.model.Board;
import com.company.model.Screen;

public class ScreenView {

  Screen screen;

  public ScreenView(Screen screen) {
    this.screen = screen;
  }

  public int getBoardPosition(Board board) {

    return screen.getAllBoards().indexOf(board);
  }

  public Board getBoardByPosition(int boardPosition) {

    return screen.getAllBoards().get(boardPosition);

  }
}
