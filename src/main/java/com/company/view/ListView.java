package com.company.view;

import com.company.model.Boardlist;

public class ListView {

  Boardlist boardlist;

  public ListView(Boardlist boardlist) {
    this.boardlist = boardlist;
  }

  public String getBoardListName() {
    return "List: " + boardlist.getBoardlistName();
  }

  public void getMenuPointList(){
    System.out.println("2. Create List: 2");
  }
}
