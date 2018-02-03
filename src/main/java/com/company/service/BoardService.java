package com.company.service;

import com.company.data.boardDAO;
import com.company.presentation.model.Board;
import com.company.presentation.model.Screen;
import java.util.ArrayList;
import java.util.List;

public class BoardService implements boardDAO {

  private Screen screen;
  private Board board;

  public BoardService() {
    screen = new Screen();
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }


  public void create(String boardname) {

    board = new Board(boardname);
    screen.getAllBoards().add(board);
  }


  public void update(Board board) {

  }


  public void delete(Board board) {

  }

  public void setScreen(Screen screen) {
    this.screen = screen;
  }
  public Screen getScreen() {
    return screen;
  }
}
