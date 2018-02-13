package com.company.view;

import com.company.controller.BoardController;
import com.company.controller.ListController;
import com.company.model.Board;
import com.company.model.Boardlist;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeneralView {

  String input;
  Board board;
  BoardController boardController = new BoardController();
  ListController listController =new ListController();
  Boardlist boardList;
  BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
  BoardView boardView;
  ListView listView;
  CardView cardView;

  public GeneralView() throws IOException {
    menuPoints();

    while (!input.equals("999")) {
      input = keyboard.readLine();

      if (input.equals("1")) {
        System.out.println("Please give the name of the board");
        board = boardController.createBoardAndSetBoardNameUI(keyboard.readLine());
        boardView = new BoardView(board);

        System.out.println(
            "The board with the name " + "'" + boardView.getBoardName() + "'" + " was created.");
      }
      if (input.equals("2")){
        System.out.println("Please give the name of the boardlist");
        boardList = listController.createListAndSetListnameUI(keyboard.readLine());
        listView = new ListView(boardList);

        System.out.println("To wich board do you wand add the List? ");



      }
    }
  }

  public void menuPoints() {

    System.out.println("1: Create Board");
    System.out.println("2: Create List");
    System.out.println("3: Create Card");
    System.out.println("999: Save and End");
  }


}
