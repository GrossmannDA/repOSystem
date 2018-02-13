package com.company.view;

import com.company.model.Board;
import com.company.model.Boardlist;
import com.company.service.BoardListService;
import com.company.service.BoardService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BoardViewTest {

  @Test
  public void getBoardNameTest() {
    //given
    BoardService boardService = new BoardService();
    Board board = boardService.createNewBoard("Board 1");
    BoardView boardView = new BoardView(board);
    String expectedBoardName;

    //when
    expectedBoardName = boardView.getBoardName();

    //then

    Assert.assertThat(board.getBoardName(), Matchers.is(expectedBoardName));

  }

  @Test
  public void getListPositionTest() {
    //given
    BoardService boardService = new BoardService();
    BoardListService boardListService = new BoardListService();
    Boardlist boardlist1 = boardListService.createNewBoardList("List 1");
    Boardlist boardlist2 = boardListService.createNewBoardList("List 2");
    Board board = boardService.createNewBoard("Board 1");
    BoardView boardView = new BoardView(board);
    int expectedListPosition1 = 0;
    int expectedListPosition2 = 1;
    int listPosition1;
    int listPosition2;

    boardService.addBoardListToBoard(board, boardlist1);
    boardService.addBoardListToBoard(board, boardlist2);

    //when
    listPosition1 = boardView.getListPosition(boardlist1);
    listPosition2 = boardView.getListPosition(boardlist2);

    //then

    Assert.assertThat(listPosition1, Matchers.is(expectedListPosition1));
    Assert.assertThat(listPosition2, Matchers.is(expectedListPosition2));

  }

  @Test
  public void getListByListPositionTest() {
    //given
    int listPositon = 0;
    BoardService boardService = new BoardService();
    BoardListService boardListService = new BoardListService();
    Boardlist boardlist1 = boardListService.createNewBoardList("List 1");
    Boardlist boardlist2 = boardListService.createNewBoardList("List 2");
    Board board = boardService.createNewBoard("Board 1");
    BoardView boardView = new BoardView(board);

    boardService.addBoardListToBoard(board, boardlist1);
    boardService.addBoardListToBoard(board, boardlist2);

    //when
    Boardlist boardlist = boardView.getListByListPosition(board, listPositon);

    //then
    Assert.assertThat(boardlist.getBoardlistName(), Matchers.is("List 1"));
  }

}
