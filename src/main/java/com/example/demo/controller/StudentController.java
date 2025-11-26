package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.service.StudentServiceImpl;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentServiceImpl service;

	@GetMapping
	public List<StudentCreateResponseDTO> getStudents() {
		LOG.debug("getStudents()");

		return service.getAllStudents();
	}

	@GetMapping("/{id}")
	public StudentCreateResponseDTO getStudent(@PathVariable int id) {
		LOG.debug("getStudent()");

		return service.getStudent(id);
	}

	@PostMapping
	public StudentCreateResponseDTO createStudent(@RequestBody StudentCreateRequestDTO createRequestDTO) {
		LOG.debug("createStudent()");

		return service.addStudent(createRequestDTO);
	}

	@PutMapping
	public StudentCreateResponseDTO updateStudent(@RequestBody StudentCreateRequestDTO createRequestDTO) {
		LOG.debug("updateStudent()");
		
		return service.updateStudent(createRequestDTO);

	}

	@DeleteMapping("/{id}")
	public boolean deleteStudent(@PathVariable int id) {
		LOG.debug("deleteStudent()");
		
		return service.deleteStudent(id);
	}
}
