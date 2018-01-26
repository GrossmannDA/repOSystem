package com.company.service;

import com.company.data.boardlistDAO;
import com.company.presentation.model.Boardlist;

public class BoardlistFileService implements boardlistDAO {

  Boardlist boardlist;

  public Boardlist getBoardlist() {
    return boardlist;
  }

  public void create(String boardlistname) {
    boardlist = new Boardlist(boardlistname);
  }

}
