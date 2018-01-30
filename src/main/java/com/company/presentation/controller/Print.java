package com.company.presentation.controller;

import com.company.presentation.model.Board;
import com.company.presentation.model.Boardlist;
import com.company.presentation.model.Card;
import com.company.service.BoardService;
import com.company.service.BoardlistFileService;
import com.company.service.CardFileService;

public class Print {

  private BoardlistFileService boardlistFileService;
  private BoardService boardService;
  private CardFileService cardFileService;
  private int board_pos;

  public Print(BoardlistFileService boardlistFileService,
      BoardService boardService, CardFileService cardFileService) {
    this.boardlistFileService = boardlistFileService;
    this.boardService = boardService;
    this.cardFileService = cardFileService;
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
        "Input Boardnumber " + boardService.getAllBoards().indexOf(board) + " ListNumber " + board
            .getBoardlist().indexOf(boardlist) + " to choose " + boardlist.toString() + " : "
            + boardService.getAllBoards().indexOf(board) + board.getBoardlist().indexOf(boardlist));
  }

  public void listAssignToBoardPrint() {
    for (Board board_1 : boardService.getAllBoards()) {

      System.out.println(
          "Choose " + boardService.getAllBoards().indexOf(board_1) + " " + board_1.toString());

    }
  }

  public void assignBoardlistToBoardPrint() {
    System.out.println(
        "The List was assingt to Board: " + boardService.getAllBoards().get(board_pos)
            .toString() + " " + boardlistFileService.getBoardlist().toString());
  }

  public void cardWasAddedToPrint() {

    System.out.println("Card " + cardFileService.getCard().toString() + " was added to "
        + boardlistFileService
        .getBoardlist().toString());
  }


}
