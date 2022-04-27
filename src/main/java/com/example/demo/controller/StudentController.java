package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = service.getStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") String id) {
		Student student = service.getStudent(Integer.parseInt(id));
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student s = service.createStudent(student);
		return new ResponseEntity<Student>(s, HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {

		Student st = service.updateStudent(id, student);
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
		boolean isDeleted = service.deleteStudent(id);
		if (isDeleted) {
			String responseContent = "Student has been deleted successfully";
			return new ResponseEntity<String>(responseContent, HttpStatus.OK);
		}
		String error = "Error while deleting Stuent from database";
		return new ResponseEntity<String>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
