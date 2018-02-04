package com.company.presentation.controller;

import com.company.presentation.model.Board;
import com.company.service.BoardService;
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
    final String boardName = "new board";
    BoardService boardService =
        new BoardService() {
          @Override
          public void create(String boardname) {
            System.out.println("Create was called;");
          }

          @Override
          public Board getBoard() {
            return new Board(boardName);
          }
        };
    BusinessLogic businessLogic = new BusinessLogic(boardService);

    // when
    businessLogic.createBoard("something else");

    // then
    Board board = businessLogic.getBoardService().getBoard();
    Assert.assertThat(board.getBoardName(), Matchers.is(boardName));
  }
}