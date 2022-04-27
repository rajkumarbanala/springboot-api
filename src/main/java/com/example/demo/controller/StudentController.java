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

import com.example.demo.entity.Student;

import com.example.demo.service.StudentServiceImpl;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl service;

	@GetMapping
	public List<Student> getStudents() {
		return service.getAllStudents();	 
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Integer id) {
		return service.getStudent(id);
	}
	
	@PostMapping
	public void createStudent(@RequestBody Student student) {
		 service.addStudent(student);
	}

	@PutMapping("/{id}")
	public void updateStudent(@PathVariable Integer id, @RequestBody Student student) {

		 service.updateStudent(id, student);
		 
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable int id) {
		  service.deleteStudent(id);
	}
}
