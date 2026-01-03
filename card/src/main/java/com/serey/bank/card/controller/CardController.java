package com.serey.bank.card.controller;

import com.serey.bank.card.dto.CardDTO;
import com.serey.bank.card.entity.Card;
import com.serey.bank.card.mapper.CardMapper;
import com.serey.bank.card.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardMapper cardMapper;

    @PostMapping
    public ResponseEntity<?> saveCard(@RequestBody CardDTO dto) {
        Card card = cardService.save(cardMapper.toCard(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(card);
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardService.getList());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Card>> getByCustomerId(
            @RequestHeader("sereybank-correlation-id") String correlationId,
            @PathVariable("customerId") Long customerId ) {
        log.debug("Correlation Id found: {}", correlationId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardService.getByCustomerId(customerId));
    }
}
