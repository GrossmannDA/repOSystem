package company.controller.service;

import company.controller.dao.CardDAO;

import java.util.Optional;

public class CardService {

    private CardDAO cardDAO;

    public CardService(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    public Optional<com.company.model.Card> getCardById(int id) {
        return Optional.ofNullable(cardDAO.getCardById(1));
    }
}
