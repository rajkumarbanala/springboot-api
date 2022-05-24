package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StudentRepository;
import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentServce {
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	@Transactional(readOnly = false)
	public StudentCreateResponseDTO addStudent(StudentCreateRequestDTO studentCreateRequestDTO) {
		LOG.debug("addStudent()");
		
		Student student = studentMapper.toEntity(studentCreateRequestDTO);
		
		student = studentRepository.save(student);
		
		return studentMapper.toCreateResponseDTO(student);
	}

	@Override
	public StudentCreateResponseDTO getStudent(int id) {
		LOG.debug("getStudent()");
		
		Optional<Student> studentOptional = studentRepository.findById(id);
		
		if(studentOptional.isPresent())
			return studentMapper.toCreateResponseDTO(studentOptional.get());
		
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public StudentCreateResponseDTO updateStudent(StudentCreateRequestDTO createRequestDTO, int id) {
		LOG.debug("updateStudent()");

		Student student = studentMapper.toEntity(createRequestDTO);
		Optional<Student> studentOptional = studentRepository.findById(id);
		if (studentOptional.isPresent()) {
			studentOptional.get().setFirstName(student.getFirstName());
			studentOptional.get().setLastName(student.getLastName());
			studentOptional.get().setUserName(student.getUserName());
			studentOptional.get().setPassword(student.getPassword());
			studentOptional.get().setMobile(student.getMobile());
			studentOptional.get().setEmail(student.getEmail());

			student = studentRepository.save(studentOptional.get());
			
		}
		return studentMapper.toCreateResponseDTO(student);
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteStudent(int id) {
		LOG.debug("deleteStudent()");
		
		Optional<Student> studentOptional = studentRepository.findById(id);
		
		if(studentOptional.isPresent()) {
			studentRepository.delete(studentOptional.get());
			return true;
		} else
			throw new RuntimeException("Student not found");
	}

	@Override
	public List<StudentCreateResponseDTO> getAllStudents() {
		LOG.debug("getAllStudents()");
		
		List<Student> students = new ArrayList<>();
		List<StudentCreateResponseDTO> dtos = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		students.stream().forEach(k -> {
			dtos.add(studentMapper.toCreateResponseDTO(k));
		});

		return dtos;
	}
}
