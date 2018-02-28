package com.company.service;

import com.company.model.Boardlist;
import com.company.model.Screen;
import com.company.view.BoardListView;
import com.company.view.ScreenView;
import java.io.IOException;


public class ListService {
Screen screen = Screen.getInstance();
ScreenView screenView = new ScreenView();
BoardListView listView;
Boardlist boardlist;
  public BoardListView createList(String listName, int targetListDestination)
      throws IOException, ClassNotFoundException {

    boardlist = new Boardlist(listName);
    if(screenView.getScreenBoardsName().size() > 0){
      screenView.getScreen().getAllBoards().get(targetListDestination).addBoardlist(boardlist);
    }


    listView = new BoardListView(boardlist);

    return listView;
  }
}
