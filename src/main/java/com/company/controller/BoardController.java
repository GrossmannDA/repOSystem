package com.company.controller;

import com.company.service.BoardService;
import com.company.view.BoardView;
import java.io.IOException;
import java.util.Optional;

public class BoardController {
// hier sollen nur die services deklariert sein, keine Views!

  BoardService boardService = new BoardService();

  public BoardController() throws IOException, ClassNotFoundException {
  }

  public Optional<BoardView> createBoard(String boardName)
      throws IOException, ClassNotFoundException {


    return Optional.of(new BoardView(boardService.createBoard(boardName)));
  }

}
