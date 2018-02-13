package com.company.controller;

import com.company.model.Boardlist;
import com.company.service.BoardListService;

public class ListController {

  BoardListService boardListService = new BoardListService();

  public Boardlist createListAndSetListnameUI(String userInputListName) {
    return boardListService.createNewBoardList(userInputListName);
  }
}
