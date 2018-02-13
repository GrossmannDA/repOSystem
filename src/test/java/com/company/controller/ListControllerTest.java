package com.company.controller;

import com.company.model.Boardlist;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ListControllerTest {

  @Test
  public void createListAndSetListnameUI(){

    //given
    ListController listController = new ListController();
    String userInputListName = "My List";

    //when
    Boardlist boardlist = listController.createListAndSetListnameUI(userInputListName);

    //then
    Assert.assertThat(boardlist.getBoardlistName(), Matchers.is(userInputListName));
  }



}
