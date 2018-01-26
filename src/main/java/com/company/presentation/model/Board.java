package com.company.presentation.model;

import com.company.presentation.model.Boardlist;
import com.company.presentation.model.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Board extends Model {

  private Long id;
  private String board_name;

  private List<Boardlist> boardlist = new ArrayList<>();


  public Board(String board_name) {
    this.board_name = board_name;
  }

  public void addBoardlist(Boardlist board_list) {

    boardlist.add(board_list);
  }

  public List<Boardlist> getBoardlist() {
    return boardlist;
  }

  @Override
  public String toString() {
    return "Board{" +
        "board_name='" + board_name + '\'' +

        '}';
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }
}
