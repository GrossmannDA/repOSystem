package com.company.controller;

import com.company.view.BoardListView;
import com.company.view.BoardView;
import com.company.view.CardView;
import java.io.IOException;
import javax.swing.text.html.ListView;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class DistributeControllerTest {

  String menuPoint;


  @Test
  public void createCardTest() throws IOException, ClassNotFoundException {
    createBoard();
    createList();
    menuPoint = "1";
    String cardName = "Card 1";
    int boardLocation = 0;
    int listLocation = 0;

    DistributeController distributeController = new DistributeController(menuPoint);

    CardView cardView = distributeController.createCard(cardName, boardLocation, listLocation);

    Assert.assertThat(cardView.getCardName(), Matchers.is(cardName));

  }

  /**
   * This method is a precondition for creating BoardList
   */
  public void createBoard() throws IOException {
    menuPoint = "2";

    String boardName = "Board 1";

    DistributeController distributeController = new DistributeController(menuPoint);
    BoardView boardView = distributeController.createBoard(boardName);

  }
  /**
   * This method is a precondition for creating Card
   */
  public void createList() throws IOException, ClassNotFoundException {
    menuPoint ="3";

    String listName = "List 1";
    int listDestination = 0;

    DistributeController distributeController = new DistributeController(menuPoint);
    BoardListView listView = distributeController.createList(listName, listDestination);
  }

  @Test
  public void createBoardTest() throws IOException {
    menuPoint = "2";

    String boardName = "Board 1";

    DistributeController distributeController = new DistributeController(menuPoint);
    BoardView boardView = distributeController.createBoard(boardName);

    Assert.assertThat(boardView.getBoardName(), Matchers.is(boardName));


  }

  @Test
  public void createListTest() throws IOException, ClassNotFoundException {

    createBoard();
    menuPoint ="3";

    String listName = "List 1";
    int listDestination = 0;

    DistributeController distributeController = new DistributeController(menuPoint);
    BoardListView listView = distributeController.createList(listName, listDestination);

    Assert.assertThat(listView.getListName(),Matchers.is(listName));

  }

}
