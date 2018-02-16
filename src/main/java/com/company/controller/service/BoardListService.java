package com.company.controller.service;

import com.company.model.Boardlist;
import com.company.model.Card;

public class BoardListService {

  Boardlist boardlist;

  public Boardlist createNewBoardList(String boardListName) {

    return new Boardlist(boardListName);
  }

  public void addCardToBoardList(Card card, Boardlist boardlist) {
    boardlist.addListCard(card);

  }

  public void removeCardFromBoardList(Card card, Boardlist boardlist) {
    boardlist.getListCard().remove(card);
  }


  public void updateBoardListName(Boardlist boardlist, String newBoardListName) {

    boardlist.setBoardlistName(newBoardListName);
  }
}
