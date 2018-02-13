package com.company.view;

import com.company.model.Board;
import com.company.model.Screen;
import com.company.service.BoardService;
import com.company.service.ScreenService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ScreenViewTest {

  @Test
  public void getBoardPositionTest() {
    //given
    ScreenService screenService = new ScreenService();
    Screen screen = screenService.createScreen();
    BoardService boardService = new BoardService();
    Board board1 = boardService.createNewBoard("Board 1");
    Board board2 = boardService.createNewBoard("Board 2");
    screenService.addBoardToScreen(board1);
    screenService.addBoardToScreen(board2);
    int expectedBoardPosition1 = 0;
    int expectedBoardPosition2 = 1;
    int boardPostion1;
    int boardPostion2;

    ScreenView screenView = new ScreenView(screen);
    //when
    boardPostion1 = screenView.getBoardPosition(board1);
    boardPostion2 = screenView.getBoardPosition(board2);

    //then
    Assert.assertThat(boardPostion1, Matchers.is(expectedBoardPosition1));
    Assert.assertThat(boardPostion2, Matchers.is(expectedBoardPosition2));

  }

  @Test
  public void getBoardByPosition() {

    //given
    ScreenService screenService = new ScreenService();
    Screen screen = screenService.createScreen();
    BoardService boardService = new BoardService();
    Board board = boardService.createNewBoard("Board 1");
    screenService.addBoardToScreen(board);
    ScreenView screenView = new ScreenView(screen);
    int boardPosition = 0;

//when
    Board expectedBoard = screenView.getBoardByPosition(boardPosition);

    //then

    Assert.assertThat(board.getBoardName(), Matchers.is(expectedBoard.getBoardName()));
  }

}
