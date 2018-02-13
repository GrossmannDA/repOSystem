package com.company.service;

import com.company.model.Board;
import com.company.model.Boardlist;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BoardServiceTest {

  @Test
  public void createNewBoard() {
    //given
    BoardService boardService = new BoardService();
    String boardName = "Board 1";

    //when
    Board board = boardService.createNewBoard(boardName);

    //then
    Assert.assertThat(board.getBoardName(), Matchers.is(boardName));
  }

  @Test
  public void addBoardListToBoard() {
    //given
    BoardListService boardListService = new BoardListService();
    Boardlist boardlist = boardListService.createNewBoardList("List 1");
    BoardService boardService = new BoardService();
    Board board = boardService.createNewBoard("Board 1");

    // when
    boardService.addBoardListToBoard(board, boardlist);

    //then
    Assert.assertThat(board.getBoardlist().size(), Matchers.is(1));
  }

  @Test
  public void updateBoardName() {
    //given
    BoardService boardService = new BoardService();
    String boardName = "Board 1";
    Board board = boardService.createNewBoard(boardName);
    String expectedBoardName = "Board 2";

    //when

    boardService.updateBoardName(board, expectedBoardName);

    //then
    Assert.assertThat(board.getBoardName(), Matchers.is(expectedBoardName));

  }

  @Test
  public void removeBoardListFromBoard() {
    //given
    BoardListService boardListService = new BoardListService();
    Boardlist boardlist = boardListService.createNewBoardList("List 1");
    BoardService boardService = new BoardService();
    Board board = boardService.createNewBoard("Board 1");
    boardService.addBoardListToBoard(board, boardlist);

    //when
    boardService.removeBoardListFromBoard(board, boardlist);

    //then
    Assert.assertThat(board.getBoardlist().size(), Matchers.is(0));

  }


}
