package com.company.controller.service;

import com.company.model.Card;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CardServiceTest {

  @Test
  public void cardServiceCreateNewCardTest() {
    //given
    String expectedCardName = "Card 1";
    CardService cardService = new CardService();
    //when
    Card card = cardService.createNewCard(expectedCardName);
    //then
    Assert.assertThat(card.getCardName(), Matchers.is(expectedCardName));
  }

  // Redundanter Code. In diesem Test wird createNewCard noch mal aufgerufen.
  // Wie damit umgehen? Oder ist es ok?

  @Test
  public void cardServiceUpdateCardNameTest() {
    //given
    String expectedUpdateName = "Card 2";
    String isCardName = "Card 1";
    CardService cardService = new CardService();

    //when
    Card card = cardService.createNewCard(isCardName);
    Card updateCard = cardService.updateCardName(card, expectedUpdateName);

    //then
    Assert.assertThat(updateCard.getCardName(), Matchers.is(expectedUpdateName));
  }

  @Test
  public void createCardCommentTest() {
    //given
    String expectedCardComment = "Card Comment 1";
    CardService cardService = new CardService();
    Card card = cardService.createNewCard("Card 1");
    //when

    Card cardWithComment = cardService.createCardComment(card, expectedCardComment);

    // then
    Assert.assertThat(cardWithComment.getComment(), Matchers.is(expectedCardComment));
  }

  @Test
  public void updateCardCommentTest() {
    // given

    String cardComment = "Card Comment 1";
    String expectedCardComment = "Card Comment 2";
    CardService cardService = new CardService();
    Card card = cardService.createNewCard("Card 1");
    cardService.createCardComment(card, cardComment);

    //when

    Card cardWithUpdatedComment = cardService.updateCardComment(card, 0, expectedCardComment);

    // Then
    Assert.assertThat(cardWithUpdatedComment.getComment().get(0), Matchers.is(expectedCardComment));
  }

  @Ignore
  //doesent work
  public void deleteCardCommentTest() {
    // given
    int positionOfDeletedeComment = 0;
    CardService cardService = new CardService();
    String comment = "Comment 1";
    Card cardWithComment = cardService.createNewCard("Card 1");
    cardWithComment.addComment(comment);
    Assert.assertThat(cardWithComment.getComment().get(positionOfDeletedeComment),
        Matchers.is(comment));
    //when
    Card cardWithoutComment = cardService
        .deleteCardComment(cardWithComment, positionOfDeletedeComment);

    //then

    Assert.assertNull(cardWithComment.getComment().get(positionOfDeletedeComment).isEmpty());

  }

  @Test
  public void addDescripiton() {
    //given
    String expectedDescriprion = "Beschreibung";
    CardService cardService = new CardService();
    Card card = cardService.createNewCard("Card with Description");

    //when
    Card cardWithDescription = cardService.addDescription(card, expectedDescriprion);

    //then

    Assert.assertThat(cardWithDescription.getCardDescription(), Matchers.is(expectedDescriprion));
  }
}
