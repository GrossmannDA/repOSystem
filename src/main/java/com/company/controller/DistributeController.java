package com.company.controller;

import com.company.model.Screen;
import com.company.service.SaveScreenService;
import com.company.view.BoardListView;
import com.company.view.BoardView;
import com.company.view.CardView;
import com.company.view.ScreenView;
import java.io.IOException;


public class DistributeController {

  CardController cardContrtoller;
  CardView cardView;
  SaveScreenService saveScreenService;

  BoardView boardView;
  ScreenView screenView;

  BoardListView listView;
  BoardController boardController;
  ListController listController;
  public DistributeController(String menuPoint) throws IOException {

    if (menuPoint.equals("1")) {
      cardContrtoller = new CardController();
    }
    if (menuPoint.equals("2")) {
      boardController = new BoardController();
      System.out.println("Please give the Boardname: ");
    }

    if (menuPoint.equals("3")) {
      listController = new ListController();
    }
    if (menuPoint.equals("999")) {
      saveScreenService = new SaveScreenService();

      saveScreenService.saveScreen();

      System.out.println("The screen was saved!");
    }

  }

  public BoardView getBoardView() {
    return boardView;
  }

  public CardView createCard(String cardName, int boardLocation, int listLocation) {

    cardView = cardContrtoller.createNewCard(cardName, boardLocation, listLocation);

    return cardView;
  }

  public BoardView createBoard(String boardName) {

    boardView = boardController.createBoard(boardName);

    return boardView;
  }

  public BoardListView createList(String listName, int listDestination)
      throws IOException, ClassNotFoundException {
    listView = listController.createList(listName, listDestination);

    return  listView;
  }
}
