package com.company.view;

import com.company.model.Boardlist;

public class BoardListView {

  Boardlist boardlist;

  public BoardListView(Boardlist boardlist) {

    this.boardlist = boardlist;
  }


  public String getListName() {
    return boardlist.getBoardlistName();
  }

}
