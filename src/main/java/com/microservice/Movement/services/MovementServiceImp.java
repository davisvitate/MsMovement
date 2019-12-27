package com.microservice.Movement.services;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.microservice.Movement.model.Movement;
import com.microservice.Movement.repository.MoveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementServiceImp implements MovementServices {
	
	
	
	@Autowired
	MoveRepository moverepo;
	
	
	@Override
	public Flux<Movement> findAllMove() {
		// TODO Auto-generated method stub
		return moverepo.findAll();
	}

	@Override
	public Mono<Movement> findByIdMove(String id) {
		// TODO Auto-generated method stub
		return moverepo.findById(id);
	}

	@Override
	public Mono<Movement> saveMove(Movement move) {
		// TODO Auto-generated method stub
		return moverepo.save(move);
	}

	@Override
	public Mono<Void> deleteMove(Movement move) {
		// TODO Auto-generated method stub
		return moverepo.delete(move);
	}
	
	

	

	

	

	

	

}