package com.company.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Create: 03.02.2018 The class Screen contains all Boards. It knows about each boardposition within
 * the Screen. Screen can contain 0..n Boards
 */

public class Screen implements Serializable{

  private int boardId;
  private ArrayList<Board> allBoards;


  public Screen() {
    allBoards = new ArrayList<>();
  }


  public int getBoardById() {
    return boardId;
  }


  public ArrayList<Board> getAllBoards() {

    return allBoards;
  }

  public void setAllBoards(ArrayList<Board> allBoards) {

    this.allBoards = allBoards;
  }


}
