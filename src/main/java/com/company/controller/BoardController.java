package com.company.controller;

import com.company.service.BoardService;
import com.company.view.BoardView;

public class BoardController {

  BoardService boardService = new BoardService();
  BoardView boardView;

  public BoardView createBoard(String boardName) {

    boardView = boardService.createBoard(boardName);
    return boardView;

  }
}
