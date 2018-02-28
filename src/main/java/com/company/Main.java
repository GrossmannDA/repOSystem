package com.company;


import com.company.controller.DistributeController;
import com.company.view.ScreenView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    DistributeController distributeController;
    String menuPoint = "";
    String boardLocation;
    String listLocation;
    String cardName;
    String userInput;
    ScreenView screenView = new ScreenView();

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    while (!menuPoint.equals("999")) {
      System.out.println("What do you want to do next?");
      System.out.println("1: Create Card");
      System.out.println("2: Create Board");
      System.out.println("3: Create List");
      System.out.println("999: Save");

      menuPoint = bufferedReader.readLine();

      distributeController = new DistributeController(menuPoint);

      if (menuPoint.equals("1")) {
        System.out.println("Please give the location for the new card: ");
        screenView.getScreen();
        int size = screenView.getScreenBoardsName().size();

        for (int i = 0; i < size; i++) {
          System.out.println("" + screenView.getScreenBoardsName().get(i) + " : " + i);

        }
        boardLocation = bufferedReader.readLine();

        int sizeList = screenView.getBoardListName().size();
        if (sizeList > 0) {
          for (int i = 0; i < sizeList; i++) {
            System.out.println(
                "Please choose the List: " + screenView.getBoardListName().get(i) + " : " + i);
          }

          listLocation = bufferedReader.readLine();
        } else {
          System.out.println("No List in this Board avalible.");
        }
      }
      if (menuPoint.equals("2")) {
        distributeController.createBoard(bufferedReader.readLine());
        System.out.println(
            "Board successfully created:  " + distributeController.getBoardView().getBoardName());
      }

      if(menuPoint.equals("3")){
        System.out.println("Please give the Location for the new List");

        int size = screenView.getScreenBoardsName().size();

        for (int c = 0; c < size; c++) {
          System.out.println("" + screenView.getScreenBoardsName().get(c) + " : " + c);

        }
        boardLocation = bufferedReader.readLine();

       int boardLocationInt = Integer.valueOf(boardLocation);

        System.out.println("Please give the Listname");

        userInput = bufferedReader.readLine();

        distributeController.createList(userInput, boardLocationInt);

      }
    }

  }
}
