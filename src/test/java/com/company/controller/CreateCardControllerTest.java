package com.company.controller;

import com.company.model.Card;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class CreateCardControllerTest {

  @Test
  public void createCard() {
    CreateCardController controller = new CreateCardController();

    Card card = controller.createCard("new", "existingboardlist");

    Assert.assertThat(card.getCardName(), Matchers.is("new"));
  }
}