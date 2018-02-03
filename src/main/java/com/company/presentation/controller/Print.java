package com.company.presentation.controller;

import com.company.presentation.model.Board;
import com.company.presentation.model.Boardlist;
import com.company.presentation.model.Card;
import com.company.service.BoardService;
import com.company.service.BoardlistFileService;
import com.company.service.CardFileService;
import java.util.ArrayList;

public class Print {

  private BoardlistFileService boardlistFileService;
  private BoardService boardService;
  private CardFileService cardFileService;
  private int board_pos;
  private ArrayList<Boolean> value;
  private Check check;

  public Print(BoardlistFileService boardlistFileService,
      BoardService boardService, CardFileService cardFileService) {
    this.boardlistFileService = boardlistFileService;
    this.boardService = boardService;
    this.cardFileService = cardFileService;
    this.check = new Check();
  }


  public void cardPrint(Boardlist boardlist) {
    if (boardlist.getListCard().size() > 0) {

      for (Card card : boardlistFileService.getBoardlist().getListCard()) {
        System.out.println("      " + card.toString());
      }
    }
  }

  public void boardPrint(Board board) {
    System.out.println(board.toString());
  }

  public void queryCardAssignToBoardlistPrint(Board board, Boardlist boardlist) {
    System.out.println(
        "Input Boardnumber " + boardService.getScreen().getAllBoards().indexOf(board) + " ListNumber " + board
            .getBoardlist().indexOf(boardlist) + " to choose " + boardlist.toString() + " : "
            + boardService.getScreen().getAllBoards().indexOf(board) + board.getBoardlist().indexOf(boardlist));
  }

  public void listAssignToBoardPrint() {
    for (Board board_1 : boardService.getScreen().getAllBoards()) {

      System.out.println(
          "Choose " + boardService.getScreen().getAllBoards().indexOf(board_1) + " " + board_1.toString());

    }
  }

  public void assignBoardlistToBoardPrint() {
    System.out.println(
        "The List was assingt to Board: " + boardService.getScreen().getAllBoards().get(board_pos)
            .toString() + " " + boardlistFileService.getBoardlist().toString());
  }

  public void cardWasAddedToPrint() {

    System.out.println("Card " + cardFileService.getCard().toString() + " was added to "
        + boardlistFileService
        .getBoardlist().toString());
  }


  public void queryBoardAndBoardlistToAssignNewCardPrint() {

    System.out.println("Please choose the boardlist from the board");

    for (Board board : boardService.getScreen().getAllBoards()) {
      boardPrint(board);

        if (check.isListAvalableInTheSpecifikBoard(board)) {

          for (Boardlist boardlist : board.getBoardlist()) {

            queryCardAssignToBoardlistPrint(board, boardlist);

            cardPrint(boardlist);
          }

        } else {
          System.out.println("No List exists. Please create the List befor Card");
        }
    }
  }
}
