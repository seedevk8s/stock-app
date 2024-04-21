package com.test.stockapp.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.test.stockapp.dto.EventStore;
import java.time.LocalDateTime;

@Component
public interface EventRepository extends CrudRepository<EventStore, Long>{
	Iterable<EventStore> findByEntityId(String entityId);
	Iterable<EventStore> findByEntityIdAndEventTimeLessThanEqual(String entityId,LocalDateTime date);
}
