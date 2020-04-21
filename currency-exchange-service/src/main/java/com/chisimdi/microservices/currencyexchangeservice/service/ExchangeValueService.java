package com.chisimdi.microservices.currencyexchangeservice.service;

import com.chisimdi.microservices.currencyexchangeservice.dao.ExchangeValueDAO;
import com.chisimdi.microservices.currencyexchangeservice.model.ExchangeValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueService {
  @Autowired
  private ExchangeValueDAO exchangeValueDAO;

  public ExchangeValue findByFromAndTo(String from, String to) {
    return exchangeValueDAO.findByFromAndTo(from, to);
  }
}