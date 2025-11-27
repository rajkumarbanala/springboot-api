package com.example.demo.controller;

import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;
import com.example.demo.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
