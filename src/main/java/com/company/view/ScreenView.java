package com.company.view;

import com.company.model.Board;
import com.company.model.Boardlist;
import com.company.model.Screen;
import com.company.service.SaveScreenService;
import java.io.IOException;
import java.util.ArrayList;

public class ScreenView {

  SaveScreenService saveScreenService = new SaveScreenService();
  ArrayList<String> boardsName = new ArrayList<>();
  ArrayList<String> boardListName = new ArrayList<>();
  ArrayList<Integer> boardLocation = new ArrayList<>();
  ArrayList<Integer> boardListLocation = new ArrayList<>();
  int count = 0;
  Screen screen;



  public ArrayList<String> getScreenBoardsName() throws IOException, ClassNotFoundException {

    Screen screen = saveScreenService.readFile();
    for (Board board : screen.getAllBoards()) {

      boardsName.add(board.getBoardName());
    }
    return boardsName;
  }

  public ArrayList<Integer> getScreenBoardsLocation() throws IOException, ClassNotFoundException {

    Screen screen = saveScreenService.readFile();
    for (Board board : screen.getAllBoards()) {

      boardLocation.add(board.getBoardId());
    }
    return boardLocation;
  }

  public ArrayList<String> getBoardListName() throws IOException, ClassNotFoundException {

    Screen screen = saveScreenService.readFile();
    for (Board board : screen.getAllBoards()) {

      for (Boardlist boardlist : board.getBoardlist()) {
        boardListName.add(boardlist.getBoardlistName());
      }
    }
    return boardListName;
  }

  public ArrayList<Integer> getBoardListLocation() throws IOException, ClassNotFoundException {

    screen = saveScreenService.readFile();
    for (Board board : screen.getAllBoards()) {

      for (Boardlist boardlist : board.getBoardlist()) {
        boardListLocation.add(count);
        count++;
      }
    }
    return boardListLocation;
  }

  public Screen getScreen() throws IOException, ClassNotFoundException {
    return saveScreenService.readFile();
  }


}
