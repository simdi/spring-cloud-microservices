package com.chisimdi.microservices.currencyconversionservice.api;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.chisimdi.microservices.currencyconversionservice.model.CurrencyConversion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
  private String EXCHANGE_CONVERSION_URL = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

  @GetMapping("/")
  public String home() {
    return "Welcome";
  }
 
  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{qty}")
  public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal qty) {
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);
    ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(EXCHANGE_CONVERSION_URL, CurrencyConversion.class, uriVariables);
    CurrencyConversion response = responseEntity.getBody(); 

    return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), qty, qty.multiply(response.getConversionMultiple()), response.getPort());
  }
}