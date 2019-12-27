package com.microservice.Movement.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotEmpty;


@Document(collection="clientpersonM")
public class ClientPerson {
	
	@Id
	@NotEmpty
	private String Id;
	
	private String name;
	
	private String lastname;
	
	private String dni;
	
	
	
	public ClientPerson() {
		
	}

	public ClientPerson(String name) {
		
		this.name = name;
	}
		

	public ClientPerson(String name, String lastname, String dni) {
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
	}



	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

}
