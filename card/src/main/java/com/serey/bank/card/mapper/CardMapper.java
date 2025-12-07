package com.serey.bank.card.mapper;

import com.serey.bank.card.dto.CardDTO;
import com.serey.bank.card.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    Card toCard(CardDTO dto);
}