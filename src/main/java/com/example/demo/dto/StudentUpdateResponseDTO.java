package com.example.demo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentUpdateResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String firstName;

	private String lastName;

	private String userName;

	private String password;

	private String email;

	private double mobile;

}
