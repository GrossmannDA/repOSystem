package com.company.service;

import com.company.model.Boardlist;
import com.company.persistance.PersistanceState;

public class ListService {
  private PersistanceState screen = PersistanceState.getInstance();
  private Boardlist boardlist;

  public ListService() {}

  public Boardlist createBoardList(String boardListName, int location) {

    boardlist = new Boardlist(boardListName);
    screen.getScreen().getAllBoards().get(location).addBoardlist(boardlist);

    return boardlist;
  }
}
