package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentServiceImpl;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl service;
	
	@GetMapping
	public List<StudentCreateResponseDTO> getStudents() {
		return service.getAllStudents();	 
	}

	@GetMapping("/{id}")
	public StudentCreateResponseDTO getStudent(@PathVariable int id) {
		return service.getStudent(id);
	}
	
	@PostMapping
	public StudentCreateResponseDTO createStudent(@RequestBody  StudentCreateRequestDTO createRequestDTO) {
		 return service.addStudent(createRequestDTO);
	}

	@PutMapping
	public StudentCreateResponseDTO updateStudent(@RequestBody StudentCreateRequestDTO createRequestDTO) {
		return service.updateStudent(createRequestDTO);
		 
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable int id) {
		  service.deleteStudent(id);
	}
}
