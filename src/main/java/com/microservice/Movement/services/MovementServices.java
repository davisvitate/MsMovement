package com.microservice.Movement.services;



import org.springframework.stereotype.Service;

import com.microservice.Movement.model.Movement;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface MovementServices {

	
	public Flux<Movement> findAllMove();

	public Mono<Movement> findByIdMove(String id);

	public Mono<Movement> saveMove(Movement move);

	public Mono<Void> deleteMove(Movement move);
	
	

}
