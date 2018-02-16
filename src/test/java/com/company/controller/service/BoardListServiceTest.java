package com.company.controller.service;

import com.company.model.Boardlist;
import com.company.model.Card;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BoardListServiceTest {

  @Test
  public void createNewBoardList() {
    //given
    BoardListService boardListService = new BoardListService();
    String boardListName = "List 1";
    //when
    Boardlist boardlist = boardListService.createNewBoardList(boardListName);

    //then
    Assert.assertThat(boardlist.getBoardlistName(), Matchers.is(boardListName));

  }

  @Test
  public void addCardToBoardListTest() {
    //given
    CardService cardService = new CardService();
    String expectedCardName = "Card 1";
    String expectedListName = "List 1";
    Card card = cardService.createNewCard(expectedCardName);
    BoardListService boardListService = new BoardListService();
    Boardlist boardlist = boardListService.createNewBoardList(expectedListName);

    //when
    boardListService.addCardToBoardList(card, boardlist);

    //then
    Assert.assertThat(boardlist.getListCard().get(0).getCardName(), Matchers.is(expectedCardName));

  }

  @Test
  public void removeCardFromBoardListTest() {
    //given
    CardService cardService = new CardService();
    String expectedCardName = "Card 1";
    String expectedListName = "List 1";
    Card card = cardService.createNewCard(expectedCardName);
    BoardListService boardListService = new BoardListService();
    Boardlist boardlist = boardListService.createNewBoardList(expectedListName);
    boardListService.addCardToBoardList(card, boardlist);

    //when

    boardListService.removeCardFromBoardList(card, boardlist);

    //then
    Assert.assertTrue("No Card is avalible", boardlist.getListCard().isEmpty());
  }

  @Test
  public void updateListName() {
    //given

    BoardListService boardListService = new BoardListService();
    String boardListName = "List 1";
    Boardlist boardlist = boardListService.createNewBoardList(boardListName);
    String expectedBoardListName = "List 2";

    //when

    boardListService.updateBoardListName(boardlist, expectedBoardListName);

    //then
    Assert.assertThat(boardlist.getBoardlistName(), Matchers.is(expectedBoardListName));
  }

}
