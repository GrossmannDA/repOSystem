package com.company.presentation.controller;

import com.company.Util;
import com.company.presentation.model.Board;
import com.company.presentation.model.Boardlist;
import com.company.presentation.model.Card;
import com.company.presentation.view.Menu;
import com.company.presentation.view.Menupoints;
import com.company.service.BoardService;
import com.company.service.BoardlistFileService;
import com.company.service.CardFileService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BL {

  BoardService boardService;
  CardFileService cardFileService;
  Board board;
  BoardlistFileService boardlistFileService;
  private String input;
  private Menu menu;
  private File file;
  private Check check;
  private Card card;
  private List<Board> allBoards;
  private int board_pos;
  private String list_pos;
  private String klammer_auf = "[";
  private String klammer_zu = "]";
  private String minus = "-";

  public BL() throws IOException, ClassNotFoundException {
    Util util = new Util();
    util.createFile();

    //  file = new File("SerTest.bin");
    menu = new Menu();
    check = new Check();
    allBoards = new ArrayList();
    boardService = new BoardService();
    boardlistFileService = new BoardlistFileService();
    cardFileService = new CardFileService();

    if (!check.fileIsEmpty(util.getFile())) {
      boardService.setAllBoards((List) deserializeObjeckt(util.getFile()));
    }
    while (!String.valueOf(Menupoints.END.getAction()).equals(input)) {

      input = getInput();
      validateUserInput(input);
    }

    if (boardService.getAllBoards() != null) {
      serializeObjeckt(boardService.getAllBoards(), util.getFile());
      System.out.println("Boardes are saved");
    }

    System.out.println("Programm was aboarded");
  }


  public void create(Object object) throws IOException {
    serializeObjeckt(object, file);
  }

  public void update() throws IOException, ClassNotFoundException {

    Board board = (Board) deserializeObjeckt(file);
    // board.addBoardlist(boardlist);
    System.out.println(board.toString());
  }

  public void delete(Object object) {

  }

  public void validateUserInput(String input) throws IOException, ClassNotFoundException {
    String str_menu = klammer_auf + "1" + minus + "3" + klammer_zu;

    if (!check.isInputStringValid(input, str_menu)) {

      System.out.println("Your input is not valid! Please repeat");
    }

    if (String.valueOf(Menupoints.CREATE_NEW_BOARD.getAction()).equals(input)) {

      System.out.println("Please input the name of the board");
      String boardname = getInput();

      boardService.create(boardname);

      //   create(new Board(getInput()));
      System.out.println("Board was created  " + boardService.getBoard().toString());

      // allBoards.add(boardService.getBoard());
      boardService.addAllBoards();
      // update();
    }

    if (String.valueOf(Menupoints.CREATE_NEW_LIST.getAction()).equals(input)) {

      if (check.isBoardAvalable(boardService.getAllBoards()) == true) {

        System.out.println("Please input the name of the List");

        String boardlistname = getInput();

        boardlistFileService.create(boardlistname);
        //Boardlist boarl = new Boardlist(boardlistname);

        System.out.println("To wich Board do you want add this List?: ");

        String size = String.valueOf(boardService.getAllBoards().size() - 1);
        String regex_size = klammer_auf + "0" + minus + size + klammer_zu;

        for (Board board_1 : boardService.getAllBoards()) {

          System.out.println(
              "Choose " + boardService.getAllBoards().indexOf(board_1) + " " + board_1.toString());

        }
        board_pos = Integer.valueOf(getInput());

        if (check.isInputStringValid(String.valueOf(board_pos), regex_size)) {

          boardService.getAllBoards().get(board_pos).addBoardlist(boardlistFileService.getBoardlist());

          System.out.println(
              "The List was assingt to Board: " + boardService.getAllBoards().get(board_pos)
                  .toString() + " " + boardlistFileService.getBoardlist().toString());
          // }
          //  } else {
          // System.out.println("Wrong Input. Please repeat.");
        }

        //create(new Boardlist(input));
        //   update();

      } else {
        System.out.println("There are no boards avalable. Please create the board befor list");
      }

    }
    if (String.valueOf(Menupoints.CREATE_NEW_CARD.getAction()).equals(input)) {
      int count = 0;
      ArrayList<Boolean> value = new ArrayList();

      System.out.println("Please choose the boardlist from the board");

      for (Board board : boardService.getAllBoards()) {
        System.out.println(board.toString());
        if (check.isListAvalable(board.getBoardlist())) {
          value.add(check.isListAvalable(board.getBoardlist()));
        }
        for (Boardlist boardlist : board.getBoardlist()) {

          System.out.println(
              "Input Boardnumber " + boardService.getAllBoards().indexOf(board) + " ListNumber " + board
                  .getBoardlist().indexOf(boardlist) + " to choose " + boardlist.toString() + " : "
                  + boardService.getAllBoards().indexOf(board) + board.getBoardlist().indexOf(boardlist));

          if (boardlist.getListCard().size() > 0) {

            for (Card card : boardlistFileService.getBoardlist().getListCard()) {
              System.out.println("      " + card.toString());
            }
          }

          //    boardlist.setAssignt_to_board(allBoards.indexOf(board));

        }
        // System.out.println(  allBoards.get(1).getBoardlist().get(0).toString());
      }

      if (value.contains(true)) {

        int listsize = value.size();
        String listsize_regex;
        // if (String.valueOf(listsize - 1).equals(0)) {
        //   listsize_regex ="0";
        //}else{
        listsize_regex = klammer_auf + "0" + minus + String.valueOf(listsize - 1) + klammer_zu;
        //}

        list_pos = getInput();

        char ch[] = list_pos.toCharArray();

        String boardPosition = String.valueOf(ch[0]);
        String listPosition = String.valueOf(ch[1]);

        // if (check.isInputStringValid(String.valueOf(boardPosition), listsize_regex)) {

        System.out.println("Please input the name of the Card");
        String cardname = getInput();

        //   card = new Card(cardname);
        cardFileService.createCard(cardname);
        try {

          Board board = boardService.getAllBoards().get(Integer.parseInt(boardPosition));
          Boardlist boardlist = board.getBoardlist().get(Integer.parseInt(listPosition));

          boardlistFileService.getBoardlist().addListCard(cardFileService.getCard());

          System.out.println("Card " + cardFileService.getCard().toString() + " was added to " + boardlistFileService
              .getBoardlist().toString());
        } catch (IndexOutOfBoundsException e) {
          System.out.println("Wrong Input. Please Repeat");
        }
      } else {
        System.out.println("No List exists. Please create the List befor Card");
      }
    }
  }

  public String getInput() throws IOException {

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    return this.input = keyboard.readLine();
  }
  public void serializeObjeckt(Object object, File file) throws IOException {

    FileOutputStream fo = new FileOutputStream(file);
    ObjectOutputStream so = new ObjectOutputStream(fo);

    so.writeObject(object);
    so.flush();
    so.close();
  }

  public Object deserializeObjeckt(File file) throws IOException, ClassNotFoundException {
    Object object;

    FileInputStream fi = new FileInputStream(file);
    ObjectInputStream si = new ObjectInputStream(fi);
    object = si.readObject();

    si.close();
    return object;
  }
}


