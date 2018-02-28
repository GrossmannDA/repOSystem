package com.company.service;

import com.company.controller.BoardController;
import com.company.model.Screen;
import com.company.view.ScreenView;
import java.io.IOException;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SaveScreenServiceTest {

  @Test
  public void saveScreen() throws IOException, ClassNotFoundException {

    Screen screen = Screen.getInstance();
    String expectedBoardName = "BoardTest";
    ScreenView screenView;
    BoardController boardController = new BoardController();

    boardController.createBoard(expectedBoardName);

    SaveScreenService saveScreenService = new SaveScreenService();
    saveScreenService.saveScreen();


    String boardName = saveScreenService.readFile().getAllBoards().get(0).getBoardName();
    Assert.assertThat(boardName, Matchers.is(expectedBoardName));
  }

}
