package com.company.controller;

import com.company.model.Card;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CardControllerTest {

  @Test
  public void createCardUITest(){
    //given
    String cardDescriptionUI = "My Card";
    CardController cardController = new CardController();

    //when
    Card card = cardController.createCardUI(cardDescriptionUI);

    //then
    Assert.assertThat(card.getCardName(), Matchers.is(cardDescriptionUI));

  }



}
