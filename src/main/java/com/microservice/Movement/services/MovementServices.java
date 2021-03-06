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
	
	public Flux<Movement> findByDni(String dni);
	
	
	public Mono<Movement> findByID(String id);
	
	public Flux<Movement> findDesc(String description);
	
	//public Flux<Movement> getRangeMovement(String num_count,String from, String to);
	
	
	

}
