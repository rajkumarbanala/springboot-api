package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	List<Student> getStudents();
	Student getStudent(int studentId);
	Student createStudent(Student student);
	Student updateStudent(int studentID,Student student);
	boolean deleteStudent(int id);
}
