package com.company.view;

import com.company.model.Boardlist;
import com.company.controller.service.BoardListService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ListViewTest {

  @Test
  public void getListName() {
    //given
    BoardListService boardListService = new BoardListService();
    String listTemplate = "List: ";
    String listName = "List 1";

    String expektedOutputListNameString = listTemplate + listName;
    Boardlist boardlist = boardListService.createNewBoardList(listName);
    ListView listView = new ListView(boardlist);

    //when
    String outputListNameString = listView.getBoardListName();

    //then
    Assert.assertThat(outputListNameString, Matchers.is(expektedOutputListNameString));

  }


}
