package com.company.service;

import com.company.data.BoardlistDAO;
import com.company.presentation.model.Boardlist;

public class BoardlistFileService implements BoardlistDAO {

  Boardlist boardlist;

  public Boardlist getBoardlist() {

    return boardlist;
  }

  public void create(String boardlistname) {

    boardlist = new Boardlist(boardlistname);
  }

}
