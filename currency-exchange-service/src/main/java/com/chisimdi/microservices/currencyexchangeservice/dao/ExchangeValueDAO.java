package com.chisimdi.microservices.currencyexchangeservice.dao;

import com.chisimdi.microservices.currencyexchangeservice.model.ExchangeValue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueDAO extends JpaRepository<ExchangeValue, Long> {
  ExchangeValue findByFromAndTo(String from, String to);
}