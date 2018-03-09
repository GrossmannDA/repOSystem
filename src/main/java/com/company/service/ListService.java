package com.company.service;

import com.company.model.Boardlist;
import com.company.persistance.PersistanceState;
import com.company.view.BoardListView;
import com.company.view.ScreenView;
import java.io.IOException;


public class ListService {
PersistanceState screen = PersistanceState.getInstance();
ScreenView screenView = new ScreenView(screen.getScreen());
BoardListView listView;
Boardlist boardlist;

  public ListService() throws IOException, ClassNotFoundException {
  }

  public Boardlist createBoardList(String boardListName, int location){

    boardlist =  new Boardlist(boardListName);
    screen.getScreen().getAllBoards().get(location).addBoardlist(boardlist);

    return boardlist;
  }
}
