package com.company.service;

import com.company.data.boardDAO;
import com.company.presentation.model.Board;
import java.util.ArrayList;
import java.util.List;

public class BoardService implements boardDAO {

  private List<Board> allBoards = new ArrayList<>();

  private Board board;

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }


  public List<Board> getAllBoards() {
    return allBoards;
  }

  public void setAllBoards(List<Board> allBoards) {
    this.allBoards = allBoards;
  }

  public void addAllBoards() {
    allBoards.add(board);
  }

  public void create(String boardname) {

    board = new Board(boardname);
  }


  public void update(Board board) {

  }


  public void delete(Board board) {

  }
}
