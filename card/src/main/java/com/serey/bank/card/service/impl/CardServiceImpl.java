package com.serey.bank.card.service.impl;

import com.serey.bank.card.entity.Card;
import com.serey.bank.card.repository.CardRepository;
import com.serey.bank.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getList() {
        return cardRepository.findAll();
    }

    @Override
    public List<Card> getByCustomerId(Long customerId) {
        return cardRepository.findByCustomerId(customerId);
    }
}

