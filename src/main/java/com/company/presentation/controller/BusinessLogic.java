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

/**
 * Keeps all business logic and needs to be refactored
 */
public class BusinessLogic {

  private BoardService boardService;
  private CardFileService cardFileService;
  private Board board;
  private BoardlistFileService boardlistFileService;
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

  private String boardPosition;
  private String listPosition;

  public String getBoardPosition() {
    return boardPosition;
  }

  public void setBoardPosition(String boardPosition) {
    this.boardPosition = boardPosition;
  }

  public String getListPosition() {
    return listPosition;
  }

  public void setListPosition(String listPosition) {
    this.listPosition = listPosition;
  }
  private Print print;

  public BusinessLogic() throws IOException {
    //  file = new File("SerTest.bin");
    menu = new Menu();
    check = new Check();
    allBoards = new ArrayList();
    boardService = new BoardService();
    boardlistFileService = new BoardlistFileService();
    cardFileService = new CardFileService();
    print = new Print(boardlistFileService, boardService, cardFileService);
  }

  public void runApplication() throws IOException, ClassNotFoundException {
    Util util = new Util();
    util.createFile();

    if (!check.fileIsEmpty(util.getFile())) {
      boardService.setAllBoards((List) deserializeObjeckt(util.getFile()));
    }

    while (!String.valueOf(Menupoints.END.getAction()).equals(input)) {

      input = getInput();
      validateUserInput(input);
    }

    boardSerialize(util);
  }

  public void boardSerialize(Util util) throws IOException {

    if (boardService.getAllBoards() != null) {
      serializeObjeckt(boardService.getAllBoards(), util.getFile());
      System.out.println("Boardes are saved");
    }

    System.out.println("Programm was aboarded");
  }

  public void validateUserInput(String input) throws IOException {
    String str_menu = klammer_auf + "1" + minus + "3" + klammer_zu;

    if (!check.isInputStringValid(input, str_menu)) {

      System.out.println("Your input is not valid! Please repeat");
    }

    if (String.valueOf(Menupoints.CREATE_NEW_BOARD.getAction()).equals(input)) {

      String boardname = queryBoardName();

      createBoard(boardname);
    }

    if (String.valueOf(Menupoints.CREATE_NEW_LIST.getAction()).equals(input)) {

      if (check.isBoardAvalable(boardService.getAllBoards())) {

        String boardlistname = queryNameOfTheList();

        createBoardlist(boardlistname);

        System.out.println("To wich Board do you want add this List?: ");

        String size = String.valueOf(boardService.getAllBoards().size() - 1);
        String regex_size = klammer_auf + "0" + minus + size + klammer_zu;

        print.listAssignToBoardPrint();

        board_pos = Integer.valueOf(getInput());

        if (check.isInputStringValid(String.valueOf(board_pos), regex_size)) {

          assignBoardlistToBoard();
          print.assignBoardlistToBoardPrint();
        }

      } else {
        System.out.println("There are no boards avalable. Please create the board befor list");
      }

    }
    if (String.valueOf(Menupoints.CREATE_NEW_CARD.getAction()).equals(input)) {

      ArrayList<Boolean> value = new ArrayList();

      System.out.println("Please choose the boardlist from the board");

      for (Board board : boardService.getAllBoards()) {
        print.boardPrint(board);

        if (check.isListAvalable(board.getBoardlist())) {
          value.add(check.isListAvalable(board.getBoardlist()));
        }
        for (Boardlist boardlist : board.getBoardlist()) {

          print.queryCardAssignToBoardlistPrint(board, boardlist);

          print.cardPrint(boardlist);
        }
      }

      if (value.contains(true)) {

        int listsize = value.size();
        String listsize_regex;
        // if (String.valueOf(listsize - 1).equals(0)) {
        //   listsize_regex ="0";
        //}else{
        listsize_regex = klammer_auf + "0" + minus + String.valueOf(listsize - 1) + klammer_zu;
        //}

        // if (check.isInputStringValid(String.valueOf(boardPosition), listsize_regex)) {
        listPosition = getInput();
        parseListAndBoardPosition(listPosition);

        String cardname = inputCardName();

        //   card = new Card(cardname);
        cardFileService.createCard(cardname);
        try {

          getBoardAndBoardlist();

          addCardToBoardlist();

          print.cardWasAddedToPrint();

        } catch (IndexOutOfBoundsException e) {
          System.out.println("Wrong Input. Please Repeat");
        }
      } else {
        System.out.println("No List exists. Please create the List befor Card");
      }
    }
  }

  public String queryBoardName() throws IOException {
    System.out.println("Please input the name of the board");
    return getInput();
  }

  public String queryNameOfTheList() throws IOException {
    System.out.println("Please input the name of the List");

    return getInput();
  }


  public void addCardToBoardlist() {
    boardlistFileService.getBoardlist().addListCard(cardFileService.getCard());
  }

  public void getBoardAndBoardlist() {
    board = boardService.getAllBoards().get(Integer.parseInt(boardPosition));
    Boardlist boardlist = board.getBoardlist().get(Integer.parseInt(listPosition));
  }

  public String inputCardName() throws IOException {
    System.out.println("Please input the name of the Card");
    String input = getInput();

    return input;
  }

  public void parseListAndBoardPosition(String listPosition) {

    char ch[] = listPosition.toCharArray();
    this.boardPosition = String.valueOf(ch[0]);
    this.listPosition = String.valueOf(ch[1]);
  }

  public void assignBoardlistToBoard() {
    boardService.getAllBoards().get(board_pos).addBoardlist(boardlistFileService.getBoardlist());
  }

  public void createBoardlist(String boardlistname) {
    boardlistFileService.create(boardlistname);
  }

  public void createBoard(String boardname) {
    boardService.create(boardname);

    System.out.println("Board was created  " + boardService.getBoard().toString());


  }

  public BoardService getBoardService() {
    return boardService;
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


