package com.microservice.Movement.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;
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

	@Override
	public Flux<Movement> findByDni(String dni) {
		// TODO Auto-generated method stub
		return moverepo.findByDni(dni);
	}

	@Override
	public Mono<Movement> findByID(String id) {
		// TODO Auto-generated method stub
		return moverepo.findById(id);
	}

	@Override
	public Flux<Movement> findDesc(String description) {
		// TODO Auto-generated method stub
		return moverepo.findDescription(description);
	}
	


//	@Override
//	public Flux<Movement> getRangeMovement(String num_count, String from, String to) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//
//			Date first = df.parse(from);
//			Date last = df.parse(to);
//			System.out.println(first.toString() + " " + last);
//
//			// return repoMov.findAllDateRangeByNro_cuenta(nro_cuenta, first, last);
//			return moverepo.findByFechaBetween(first, last).filter(moves -> moves.getNum_count().equals(num_count));
//
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			// e.printStackTrace();
//			return null;
//		}
//		return null;
		
//	}

	
	

	

}
