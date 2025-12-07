package com.serey.bank.card.service;

import com.serey.bank.card.entity.Card;

import java.util.List;

public interface CardService {
    Card save(Card card);
    List<Card> getList();
    List<Card> getByCustomerId(Long customerId);
}
