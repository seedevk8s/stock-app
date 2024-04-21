package com.test.stockapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.stockapp.enity.Stock;
import com.test.stockapp.events.StockAddedEvent;
import com.test.stockapp.service.EventService;

@RestController
public class StockController {
	@Autowired
	private EventService service;
	@PostMapping("/stock")
	public void addStock(@RequestBody Stock stockRequest) throws JsonProcessingException {
		StockAddedEvent event = StockAddedEvent.builder().stockDetails(stockRequest).build();
		service.addEvent(event);
	}
}
