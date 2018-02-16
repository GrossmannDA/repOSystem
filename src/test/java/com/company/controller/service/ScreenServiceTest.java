package com.company.controller.service;

import com.company.model.Board;
import com.company.model.Screen;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ScreenServiceTest {

  @Test
  public void createScreen() {
    //given
    ScreenService screenService = new ScreenService();

    //when
    Screen screen = screenService.createScreen();

    //then
    Assert.assertNotNull(screen);
  }

  @Test
  public void addBoardToScreen() {
    //given
    ScreenService screenService = new ScreenService();
    Screen screen = screenService.createScreen();
    BoardService boardService = new BoardService();
    Board board = boardService.createNewBoard("Board 1");

    //when
    screenService.addBoardToScreen(board);

    //then
    Assert.assertThat(screen.getAllBoards().size(), Matchers.is(1));

  }

}
