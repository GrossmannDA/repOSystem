package com.company.controller;

import com.company.model.Board;
import com.company.service.BoardService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardController {

  BoardService boardService = new BoardService();


  public Board createBoardAndSetBoardNameUI(String userInputBoardName) {
   return boardService.createNewBoard(userInputBoardName);

  }
}
