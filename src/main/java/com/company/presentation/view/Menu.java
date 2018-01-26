package com.company.presentation.view;

import java.io.IOException;

public class Menu {

  String input;

  public Menu() throws IOException {

    System.out.println("Please choose the point.");

    Menupoints createNewBoard = Menupoints.CREATE_NEW_BOARD;
    System.out.println(createNewBoard.getMenupoint());

    Menupoints createNewList = Menupoints.CREATE_NEW_LIST;
    System.out.println(createNewList.getMenupoint());

    Menupoints createNewCard = Menupoints.CREATE_NEW_CARD;
    System.out.println(createNewCard.getMenupoint());

    Menupoints end = Menupoints.END;
    System.out.println(end.getMenupoint());
  }


}
