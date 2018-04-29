package com.company.service;

import com.company.model.Card;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CardServiceTest {

  @Test
  public void createCardTest() {

    // given
    String expectedCardName = "Card 1";
    int boardIntex = 0;
    int listIndex = 0;

    BoardService boardService = new BoardService();
    boardService.createBoard("Board 1");
    ListService listService = new ListService();
    listService.createBoardList("List 1", 0);

    // when
    CardService cardService = new CardService();
    Card card = cardService.createCard(expectedCardName, boardIntex, listIndex);

    // then
    Assert.assertThat(card.getCardName(), Matchers.is(expectedCardName));
  }
}
