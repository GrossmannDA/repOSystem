package com.company.view;

import com.company.model.Board;
import com.company.model.Boardlist;
import com.company.model.Screen;
import java.util.ArrayList;

public class ScreenView {

  // soll keine Services enthalten

  private Screen screen;

  private ArrayList<String> boardName = new ArrayList<>();
  private ArrayList<String> cardNames = new ArrayList<>();
  private ArrayList<String> listNames = new ArrayList<>();

  public ScreenView(Screen screen) {

    this.screen = screen;
  }

  public ArrayList<String> getBoardName() {
    return boardName;
  }

  public ArrayList<String> getListNames() {
    return listNames;
  }

  public ArrayList<String> getCardNames() {
    return cardNames;
  }

  public ArrayList<String> getAllBoardsNames() {

    for (Board board : screen.getAllBoards()) {

      boardName.add(board.getBoardName());
    }

    return boardName;
  }

  public void getAllLists() {

    int boardSize = screen.getAllBoards().size();
    for (int boardIndex = 0; boardIndex < boardSize; boardIndex++) {
      String boardName = screen.getAllBoards().get(boardIndex).getBoardName();

      if (!screen.getAllBoards().get(boardIndex).getBoardlist().isEmpty()) {
        ArrayList<Boardlist> boardList =
            (ArrayList<Boardlist>) screen.getAllBoards().get(boardIndex).getBoardlist();

        for (int boardListIndex = 0; boardListIndex < boardList.size(); boardListIndex++) {
          listNames.add(
              "Boardname: "
                  + boardName
                  + " : "
                  + boardList.get(boardListIndex).getBoardlistName()
                  + " : "
                  + boardIndex
                  + boardListIndex);

          if (!boardList.get(boardListIndex).getListCard().isEmpty()) {
            int cardListSize = boardList.get(boardListIndex).getListCard().size();
            for (int cardIndex = 0; cardIndex < cardListSize; cardIndex++) {
              String crdName =
                  boardList.get(boardListIndex).getListCard().get(cardIndex).getCardName();
              String boardListName = boardList.get(boardListIndex).getBoardlistName();
              cardNames.add("Board: " + boardName + " List: " + boardListName + "Card: " + crdName);
            }
          }
        }
      }
    }
  }
}
