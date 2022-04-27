package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;
@Service
@org.springframework.transaction.annotation.Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<Student> getStudents() {
		return repository.getStudents();
	}

	@Override
	public Student getStudent(int studentId) {
		return repository.getStudent(studentId);
	}

	@Override
	public Student createStudent(Student student) {
		return repository.createStudent(student);
	}

	@Override
	public Student updateStudent(int studentID, Student student) {
		return repository.updateStudent(studentID, student);
	}

	@Override
	public boolean deleteStudent(int id) {
		return repository.deleteStudent(id);
	}

	

}
