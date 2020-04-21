package com.chisimdi.microservices.currencyexchangeservice.api;

import java.math.BigDecimal;

import com.chisimdi.microservices.currencyexchangeservice.model.ExchangeValue;
import com.chisimdi.microservices.currencyexchangeservice.service.ExchangeValueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
  @Autowired
  private Environment environment;
  @Autowired
  private ExchangeValueService exchangeValueService;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue getExchangeValue(@PathVariable String from,@PathVariable String to) {
    return exchangeValueService.findByFromAndTo(from, to);
  }
}