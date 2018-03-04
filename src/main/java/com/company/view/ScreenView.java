package com.company.view;

import com.company.model.Board;
import com.company.model.Boardlist;
import com.company.model.Screen;
import com.company.persistance.PersistanceState;
import java.io.IOException;
import java.util.ArrayList;

public class ScreenView {

// soll keine Services enthalten


  ArrayList<String> boardsName = new ArrayList<>();
  ArrayList<String> boardListName = new ArrayList<>();
  ArrayList<Integer> boardLocation = new ArrayList<>();
  ArrayList<Integer> boardListLocation = new ArrayList<>();
  int count = 0;
  PersistanceState screenState = PersistanceState.getInstance() ;

  public ScreenView() throws IOException, ClassNotFoundException {

    screenState.loadState();
  }

  public ArrayList<String> getScreenBoardsName() throws IOException, ClassNotFoundException {

    for (Board board : screenState.getScreen().getAllBoards()) {

      boardsName.add(board.getBoardName());
    }
    return boardsName;
  }

  public ArrayList<Integer> getScreenBoardsLocation() throws IOException, ClassNotFoundException {

    screenState.getScreen().getAllBoards();
    for (Board board : screenState.getScreen().getAllBoards()) {

      boardLocation.add(board.getBoardId());
    }
    return boardLocation;
  }

  public ArrayList<String> getBoardListName() throws IOException, ClassNotFoundException {

    for (Board board : screenState.getScreen().getAllBoards()) {

      for (Boardlist boardlist : board.getBoardlist()) {
        boardListName.add(boardlist.getBoardlistName());
      }
    }
    return boardListName;
  }

  public ArrayList<Integer> getBoardListLocation() throws IOException, ClassNotFoundException {


    for (Board board : screenState.getScreen().getAllBoards()) {

      for (Boardlist boardlist : board.getBoardlist()) {
        boardListLocation.add(count);
        count++;
      }
    }
    return boardListLocation;
  }

  public Screen getScreen() throws IOException, ClassNotFoundException {
    return screenState.getScreen();
  }


}
