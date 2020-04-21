package com.chisimdi.microservices.limitsservice.api;

import com.chisimdi.microservices.limitsservice.bean.LimitConfiguration;
import com.chisimdi.microservices.limitsservice.service.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigController {
  @Autowired
  private Configuration configuration;

  @GetMapping("/limits")
  public LimitConfiguration getLimitsFromConfigurations() {
    return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
  }
}