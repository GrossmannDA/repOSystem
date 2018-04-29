package com.company.controller;

import com.company.service.BoardService;
import com.company.view.BoardView;
import java.util.Optional;

public class BoardController {
  // hier sollen nur die services deklariert sein, keine Views!

  private BoardService boardService = new BoardService();

  public Optional<BoardView> createBoard(String boardName) {

    return Optional.of(new BoardView(boardService.createBoard(boardName)));
  }
}
