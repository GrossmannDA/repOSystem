package com.company.service;

import com.company.model.Boardlist;
import com.company.persistance.PersistanceState;
import com.company.view.BoardListView;
import com.company.view.ScreenView;
import java.io.IOException;


public class ListService {
PersistanceState screen = PersistanceState.getInstance();
ScreenView screenView = new ScreenView();
BoardListView listView;
Boardlist boardlist;

  public ListService() throws IOException, ClassNotFoundException {
  }

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
