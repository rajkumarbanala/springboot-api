package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StudentRepository;
import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
@Service
@Transactional
public class StudentServiceImpl implements StudentServceI {
	@Autowired
	private StudentRepository repository;
	@Autowired
	private StudentMapper mapper;

	@Override
	public StudentCreateResponseDTO addStudent(StudentCreateRequestDTO studentCreateRequestDTO) {
		Student student = mapper.toEntity(studentCreateRequestDTO);
		student = repository.save(student);
		return mapper.toCreateResponseDTO(student);
	}

	@Override
	public StudentCreateResponseDTO getStudent(int id) {
		Student student = repository.findOne(id);
		return mapper.toCreateResponseDTO(student); 
	}

	@Override
	public StudentCreateResponseDTO updateStudent(StudentCreateRequestDTO studentCreateRequestDTO) {
		Student student = mapper.toEntity(studentCreateRequestDTO);
		student = repository.save(student);
		return mapper.toCreateResponseDTO(student);
	}

	@Override
	public void deleteStudent(int id) {
		repository.delete(id);
	}
	@Override
	public List<StudentCreateResponseDTO> getAllStudents() {
		List<Student> students = new ArrayList<>();
		 repository.findAll().forEach(students::add);
		 List<StudentCreateResponseDTO> dtos = new ArrayList<>();
		 for (Iterator iterator = students.iterator(); iterator.hasNext();) {
			Student s = (Student) iterator.next();
			dtos.add(mapper.toCreateResponseDTO(s));	
		}
		return dtos;
	}
}
