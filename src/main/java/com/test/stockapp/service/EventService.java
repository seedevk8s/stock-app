package com.test.stockapp.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.stockapp.dto.EventStore;
import com.test.stockapp.events.StockAddedEvent;
import com.test.stockapp.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repo;
	public void addEvent(StockAddedEvent event) throws JsonProcessingException {

		EventStore eventStore = new EventStore();
		eventStore.setEventData(new ObjectMapper().writeValueAsString(event.getStockDetails()));
		eventStore.setEventType("STOCK_ADDED");
		eventStore.setEntityId(event.getStockDetails().getName());
		eventStore.setEventTime(LocalDateTime.now());
		repo.save(eventStore);
	}
}
