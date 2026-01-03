package com.serey.bank.account.service.client;

import com.serey.bank.account.dto.CardResponseDTO;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

//@FeignClient(name = "card")
public interface CardFeignClient {

    @GetMapping("/api/cards/{customerId}")
    List<CardResponseDTO> getCardInfo(@RequestHeader("sereybank-correlation-id") String correlationID,
                                      @PathVariable Long customerId);
}
