package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;
@Service
@Transactional
public class StudentServiceImpl {
	@Autowired
	private StudentRepository repository;
	
	public List<Student> getAllStudents() {
	    List<Student> students = new ArrayList<>();
	    repository.findAll()
	    .forEach(students::add);
	    return students;		
	}
	
	public void addStudent(Student student) {
		repository.save(student);
	}
	
	public Student getStudent(int id) {
		Student student  =  repository.findOne(id);
		return student;
		
	}
	public void updateStudent(int id, Student student) {
		repository.save(student);
	}

	public void deleteStudent(int id) {
		repository.delete(id);
	}


}
