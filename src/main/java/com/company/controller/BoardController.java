package com.company.controller;

import com.company.model.Board;
import com.company.controller.service.BoardService;

public class BoardController {

  BoardService boardService = new BoardService();


  public Board createBoardAndSetBoardNameUI(String userInputBoardName) {
   return boardService.createNewBoard(userInputBoardName);

  }
}
