package com.microservice.Movement.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;




import com.microservice.Movement.model.Movement;
import com.microservice.Movement.services.MovementServices;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/api/movement")
public class MovementController {
	
	
	
	@Autowired
	private MovementServices service;
	
	@GetMapping("/movement")
	public Mono<ResponseEntity<Flux<Movement>>> lista(){
		return Mono.just(
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(service.findAllMove())
				);
	}
	
	
	@PostMapping("/createM")
	public Mono<ResponseEntity<Map<String, Object>>> createMove(@Valid @RequestBody Mono<Movement> monoMovement){
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		return monoMovement.flatMap(move->{
			return service.saveMove(move).map(c->{
				respuesta.put("movement", c);
				respuesta.put("mensaje", "Movimiento creado con exito");
				return ResponseEntity
						.created(URI.create("/api/movement/createM".concat(c.getId())))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(respuesta);
						
					
			});
		}).onErrorResume(t -> {
			return Mono.just(t).cast(WebExchangeBindException.class)
					.flatMap(e -> Mono.just(e.getFieldErrors()))
					.flatMapMany(Flux::fromIterable)
					.map(fieldError -> "El campo "+fieldError.getField() + " " + fieldError.getDefaultMessage())
					.collectList()
					.flatMap(list -> {
						respuesta.put("errors", list);
						respuesta.put("status", HttpStatus.BAD_REQUEST.value());
						return Mono.just(ResponseEntity.badRequest().body(respuesta));
					});
							
		});
		

	}
	
	
	

}
