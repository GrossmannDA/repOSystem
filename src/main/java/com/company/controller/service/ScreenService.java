package com.company.controller.service;

import com.company.model.Board;
import com.company.model.Screen;

public class ScreenService {

  Screen screen;

  public Screen createScreen() {

    screen = new Screen();
    return screen;
  }

  public void addBoardToScreen(Board board) {

    screen.getAllBoards().add(board);
  }
}
