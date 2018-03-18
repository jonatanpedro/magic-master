package com.zeroquo.magicregister.handler;

import com.zeroquo.magicregister.domain.Card;
import com.zeroquo.magicregister.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardHandler extends BaseHandler<Card> {

    private CardRepository cardRepository;

    @Autowired
    public CardHandler(CardRepository cardRepository) {
        super(cardRepository);
        this.cardRepository = cardRepository;
    }
}

