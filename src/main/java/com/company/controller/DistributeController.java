package com.company.controller;

import com.company.controller.state.ActualApplicationStateService;
import com.company.controller.state.RequestState;
import com.company.controller.state.ResponseState;
import com.company.view.BoardListView;
import com.company.view.CardView;
import com.company.view.ScreenView;
import com.company.view.print.BoardPrint;
import com.company.view.print.CreateCardPrint;
import com.company.view.print.ListPrint;
import com.company.view.print.MenuPrint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

// singleton. dient nur zur Weiterleitung
public class DistributeController {

  // dieser service gehört nur zu diesem Controller
  private ActualApplicationStateService actualApplicationStateService = new ActualApplicationStateService();
  private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private HomeController homeController = new HomeController();

  public DistributeController() throws IOException, ClassNotFoundException {
    // first initialisation > the main menu is shown
    String actualState = actualApplicationStateService.getUserState();
    if (actualState == null) {
      actualApplicationStateService.setUserState(ResponseState.START_APP_STATE.getState());
      MenuPrint menuPrint = new MenuPrint();
      menuPrint.startMenu();

    }

    String userInput = "";
    while (!userInput.equals("999")) {
      userInput = bufferedReader.readLine();
      requestMapping(userInput);
    }
  }

  private void requestMapping(String request) throws IOException, ClassNotFoundException {
    CreateCardPrint createCardPrint = new CreateCardPrint();

    if (request.equals("1")) {
      actualApplicationStateService
          .setUserState(RequestState.REQUEST_CREATE_CARD_STATE.getRequestState());
      CardController cardController = new CardController();
      System.out.println("Please input the Cardname");

      String cardName = bufferedReader.readLine();

      ArrayList<String> lists = homeController.getPersistScreenView().getAllListsAndBoarsNames();
      ArrayList<String> output = homeController.getPersistScreenView().getAllListsAndBoarsNames();

      System.out.println("Please input the Destiantion for you card: ");
      for (String destiantion : output) {

        System.out.println(destiantion);
      }

      String input = bufferedReader.readLine();

      char[] boardChar = input.toCharArray();

      int boardIndex = Integer.parseInt(String.valueOf(boardChar[0]));
      int listIndex = Integer.parseInt(String.valueOf(boardChar[1]));

      Optional<CardView> newCard = cardController.createNewCard(cardName, boardIndex, listIndex);
      ScreenView screenView = homeController.getPersistScreenView();

      for (String actCardName : screenView.getCardNames()) {
        System.out.println(actCardName);
      }
      if (newCard.isPresent()) {
        actualApplicationStateService
            .setUserState(ResponseState.CARD_CREATED_SUCCSES_STATE.getState());


      }

      if (actualApplicationStateService.getUserState()
          .equals(ResponseState.CARD_CREATED_SUCCSES_STATE.getState())) {
        createCardPrint.getCardCreatedSuccsesfullyNotification();


      }
      if (actualApplicationStateService.getUserState()
          .equals(ResponseState.CARD_CREATED_FALLURE_STATE.getState())) {
        createCardPrint.getCardCreatedFallureNotification();
      }
    }

    if (request.equals("2")) {

      BoardController boardController = new BoardController();
      BoardPrint boardPrint = new BoardPrint();

      System.out.println("Please give the name of the board");
      String boardName = bufferedReader.readLine();

      if (boardController.createBoard(boardName).isPresent()) {

        boardPrint.getBoardCreatedSuccsesfullyNotification();
      } else {
        boardPrint.getBoardCreatedFallureNotification();
      }

    }
    if (request.equals("3")) {

      ListController listController = new ListController();
      System.out.println("Please input the Listname");
      String listName = bufferedReader.readLine();

      System.out.println("Please input the Destination");
      ArrayList<String> boardNames = homeController.getPersistScreenView().getAllBoardsNames();
      for (int i = 0; i < boardNames.size(); i++) {

        System.out
            .println(homeController.getPersistScreenView().getAllBoardsNames().get(i) + " : " + i);
      }

      String destination = bufferedReader.readLine();
      int intDestination = Integer.parseInt(destination);
      ListPrint listPrint = new ListPrint();

      Optional<BoardListView> boardListView = listController.createList(listName, intDestination);
      if (boardListView.isPresent()) {

        ArrayList<String> lists = homeController.getPersistScreenView().getAllListsAndBoarsNames();
        for (String list : lists) {
          System.out.println(list);
        }
        listPrint.getListCreatedSuccsesfullyNotification();
      } else {
        listPrint.getListCreatedFallureNotification();
      }
    }

    if (request.equals("999")) {
      ScreenController screenController = new ScreenController();

      screenController.saveScreen();
    }

  }

}
