package com.company.view;

import com.company.model.Card;
import com.company.controller.service.CardService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CardViewTest {


  @Test
  public void getCardNameTest() {
    //given
    CardService cardService = new CardService();
    String cardName = "Card 1";
    Card card = cardService.createNewCard(cardName);
    String templateCardName = "Card name: ";
    String expectedOutput = templateCardName + cardName;

    //when
    CardView cardView = new CardView(card);
    //then
    Assert.assertThat(cardView.getCardName(), Matchers.is(expectedOutput));

  }

  @Test
  public void userInputCreateCard() {
    //given
    String userInput = "3";


  }

}
