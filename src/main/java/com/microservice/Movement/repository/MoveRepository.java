package com.microservice.Movement.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


import com.microservice.Movement.model.Movement;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface MoveRepository extends ReactiveMongoRepository<Movement, String> {
	
	@Query("{ 'client.dni': ?0 }")
    Flux<Movement> findByDni(final String dni);
	
	
	
	@Query("{ '_id': ?0 }")
    Mono<Movement> findById(final String id);
	
	@Query("{ 'description': ?0 }")
    Flux<Movement> findDescription(final String description);
	
	//public Flux<Movement> findByFechaBetween(Date from, Date to);

}
