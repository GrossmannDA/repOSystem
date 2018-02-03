package com.company.presentation.controller;

import com.company.presentation.model.Board;
import java.io.IOException;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

// Spezific Test Start: ctrl + shift+F10
public class BusinessLogicTest {

  private static BusinessLogic businessLogic;

  @org.junit.BeforeClass
  public static void setUp() throws Exception {

    businessLogic = new BusinessLogic();
  }


  @org.junit.Test
  public void serializeObjecktTest() throws IOException, ClassNotFoundException {
    // given

    String boardName = "new board";

    // when
    businessLogic.createBoard(boardName);

    // then
    Board board = businessLogic.getBoardService().getBoard();
    Assert.assertThat(board.getBoardName(), Matchers.is(boardName));
  }

  @Test
  public void parseListAndBoardPosition() {
    String input = "98";

    businessLogic.parseListAndBoardPosition(input);
    //Assert.assertThat(businessLogic.getBoardPosition(), Matchers.is("9"));
    //Assert.assertThat(businessLogic.getListPosition(), Matchers.is("8"));

  }


  @Test
  public void createBoardlist() {
  }

  @Test
  public void createBoard() {
  }
}