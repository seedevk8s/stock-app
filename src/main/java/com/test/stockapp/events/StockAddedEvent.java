package com.test.stockapp.events;

import com.test.stockapp.enity.Stock;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StockAddedEvent implements StockEvent {
	private Stock stockDetails;
	
}
