package com.company.controller;

import com.company.model.Board;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BoardControllerTest {


  public BoardControllerTest() {

  }
  @Test
  public void createBoardAndSetBoardNameUITest(){

    //given
    String userInputBoardName= "Board1";
    BoardController boardController = new BoardController();

    //when
   Board board= boardController.createBoardAndSetBoardNameUI(userInputBoardName);

    //then
    Assert.assertThat(board.getBoardName(), Matchers.is(userInputBoardName));
  }


}
