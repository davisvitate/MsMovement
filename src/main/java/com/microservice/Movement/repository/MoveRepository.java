package com.microservice.Movement.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.microservice.Movement.model.Movement;


import reactor.core.publisher.Flux;



public interface MoveRepository extends ReactiveMongoRepository<Movement, String> {
	
	@Query("{ 'clientperson.dni': ?0 }")
    Flux<Movement> findByDni(final String dni);

}
