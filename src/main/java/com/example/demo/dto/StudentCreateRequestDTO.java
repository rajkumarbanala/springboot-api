package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class StudentCreateRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private int id;

	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("mobile")
	private double mobile;
	
}
