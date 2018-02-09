package com.company.presentation.controller;

import static org.openjdk.tools.doclint.Entity.minus;

import com.company.Util;
import com.company.presentation.model.Board;
import com.company.presentation.model.Boardlist;
import com.company.presentation.view.Menu;
import com.company.presentation.view.Menupoints;
import com.company.service.BoardService;
import com.company.service.BoardlistFileService;
import com.company.service.CardFileService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Model Acsses occur only with Servises
 */
public class BusinessLogic {

  private BoardService boardService;
  private CardFileService cardFileService;
  private BoardlistFileService boardlistFileService;

  private Menu menu;
  private File file;
  private Check check;

  private static String KLAMMER_AUF = "[";
  private static String KLAMMER_ZU = "]";
  private String MINUS = "-";

  private String userInputString;
  private Print print;
  private Input input;

  public BusinessLogic() throws IOException {
    //  file = new File("SerTest.bin");
    menu = new Menu();
    check = new Check();

    boardService = new BoardService();
    boardlistFileService = new BoardlistFileService();
    cardFileService = new CardFileService();
    print = new Print(boardlistFileService, boardService, cardFileService);
    input = new Input();

  }

  public Input getInput() {
    return input;
  }

  public void setInput(Input input) {
    this.input = input;
  }

  public String getUserInputString() {
    return userInputString;
  }

  public void setUserInputString(String userInputString) {
    this.userInputString = userInputString;
  }

  public void runApplication() throws IOException, ClassNotFoundException {
    Util util = new Util();
    util.createFile();

    if (!check.fileIsEmpty(util.getFile())) {
      boardService.getScreen().setAllBoards((ArrayList<Board>) deserializeObjeckt(util.getFile()));
    }

    while (!String.valueOf(Menupoints.END.getAction()).equals(userInputString)) {

      userInputString = input.getInput();
      validateUserInput();
    }
    boardSerialize(util);
  }

  public void boardSerialize(Util util) throws IOException {

    if (boardService.getScreen().getAllBoards() != null) {
      serializeObjeckt(boardService.getScreen().getAllBoards(), util.getFile());
      System.out.println("Boardes are saved");
    }

    System.out.println("Programm was aboarded");
  }

  public void validateUserInput() throws IOException {
    String str_menu = KLAMMER_AUF + "1" + MINUS + "3" + KLAMMER_ZU;

    if (!check.isInputStringValid(userInputString, str_menu)) {

      System.out.println("Your input is not valid! Please repeat");
    }

    if (String.valueOf(Menupoints.CREATE_NEW_BOARD.getAction()).equals(userInputString)) {

      String boardname = input.queryBoardName();
      createBoard(boardname);
    }

    if (String.valueOf(Menupoints.CREATE_NEW_LIST.getAction()).equals(userInputString)) {

      if (check.isBoardAvalable(boardService.getScreen().getAllBoards())) {

        createList();

      } else {
        System.out.println("There are no boards avalable. Please create the board befor list");
      }

    }
    if (String.valueOf(Menupoints.CREATE_NEW_CARD.getAction()).equals(userInputString)) {

      createCard();
    }
  }

  public void createList() throws IOException {
    String boardlistname = input.queryNameOfTheList();

    System.out.println("To which Board do you want add this List?: ");

    String size = String.valueOf(boardService.getScreen().getAllBoards().size() - 1);
    String regex_size = KLAMMER_AUF + "0" + MINUS + size + KLAMMER_ZU;

    print.listAssignToBoardPrint();
    String userInputboardPosition = input.getInput();

    if (check.isInputStringValid(userInputboardPosition, regex_size)) {

      boardService.getScreen().setBoardPosition(Integer.valueOf(userInputboardPosition));
      int boardPosition = boardService.getScreen().getBoardPosition();

      Boardlist boardlist = createBoardlist(boardlistname);

      assignBoardListToBoard(boardPosition, boardlist);
      print.assignBoardlistToBoardPrint(boardPosition);
    }
  }

  public void addCardToBoardlist() {
    Board board = boardService.getScreen().getAllBoards()
        .get(boardService.getScreen().getBoardPosition());
    int boardlistPosition = board.getListPosition();
    Boardlist boardlist = board.getBoardlist().get(boardlistPosition);
    boardlist.addListCard(cardFileService.getCard());

  }

  public void getBoardAndBoardlist() {
    Board board = boardService.getScreen().getAllBoards()
        .get(boardService.getScreen().getBoardPosition());

    Boardlist boardlist = (Boardlist) board.getBoardlist();
  }

  public String inputCardName() throws IOException {
    System.out.println("Please input the name of the Card");
    String cardName = input.getInput();

    return cardName;
  }

  public void parseListAndBoardPosition(String userInputlistPosition) {

    char ch[] = userInputlistPosition.toCharArray();

    String boardPosition = String.valueOf(ch[0]);
    boardService.getScreen().setBoardPosition(Integer.valueOf(boardPosition));
    String listPosition = String.valueOf(ch[1]);
    boardService.getScreen().getAllBoards().get(Integer.valueOf(boardPosition))
        .setListPosition(Integer.valueOf(listPosition));
  }


  public Boardlist createBoardlist(String boardlistName) {
    boardlistFileService.create(boardlistName);

    return boardlistFileService.getBoardlist();
  }

  public void assignBoardListToBoard(int boardPosition, Boardlist boardlist) {
    boardService.getScreen().getAllBoards().get(boardPosition).addBoardlist(boardlist);
  }

  public void createBoard(String boardname) {
    boardService.create(boardname);

    System.out.println("Board was created  " + boardService.getBoard().toString());

  }

  public BoardService getBoardService() {
    return boardService;
  }


  void serializeObjeckt(Object object, File file) throws IOException {

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

  public void createCard() throws IOException {

    print.queryBoardAndBoardlistToAssignNewCardPrint();

    userInputString = input.getInput();
    // hier soll eine Prüfung inputValidation erfolgen

    parseListAndBoardPosition(userInputString);

    String cardname = inputCardName();

    cardFileService.createCard(cardname);

    try {

      //   getBoardAndBoardlist();

      addCardToBoardlist();

      print.cardWasAddedToPrint();

    } catch (IndexOutOfBoundsException e) {
      System.out.println("Wrong Input. Please Repeat");
    }


  }

}


