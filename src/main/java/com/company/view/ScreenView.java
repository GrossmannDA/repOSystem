package com.company.view;

import com.company.model.Board;
import com.company.model.Screen;
import java.util.ArrayList;

public class ScreenView {

// soll keine Services enthalten

  Screen screen;

  ArrayList<String> boardName = new ArrayList<>();

  public ScreenView(Screen screen) {

    this.screen = screen;
  }

  public ArrayList<String> getAllBoardsNames() {

    for (Board board : screen.getAllBoards()) {

      boardName.add(board.getBoardName());
    }

    return boardName;
  }
}
