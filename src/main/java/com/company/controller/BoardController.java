package com.company.controller;

import com.company.service.BoardService;
import com.company.view.BoardView;

public class BoardController {
// hier sollen nur die services deklariert sein, keine Views!

  BoardService boardService = new BoardService();

  public BoardView createBoard(String boardName) {
    return new BoardView(boardService.createBoard(boardName));
  }

}
