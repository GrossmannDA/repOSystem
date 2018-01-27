package com.company.presentation.controller;

import com.company.presentation.model.Board;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.io.IOException;

public class BusinessLogicTest {

  @org.junit.Before
  public void setUp() throws Exception {
  }

  @org.junit.After
  public void tearDown() throws Exception {
  }

  @org.junit.Test
  public void serializeObjecktTest() throws IOException, ClassNotFoundException {
    // given
    BusinessLogic businessLogic = new BusinessLogic();
    String boardName = "new board";

    // when
    businessLogic.createBoard(boardName);

    // then
    Board board = businessLogic.getBoardService().getBoard();
    Assert.assertThat(board.getBoardName(), Matchers.is(boardName));
  }
}