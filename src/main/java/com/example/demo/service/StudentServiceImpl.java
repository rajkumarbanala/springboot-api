package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StudentRepository;
import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;
import com.example.demo.dto.StudentGetResponseDTO;
import com.example.demo.dto.StudentListResponseDTO;
import com.example.demo.dto.StudentUpdateResponseDTO;
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
	public StudentGetResponseDTO getStudent(int id) {
		LOG.debug("getStudent()");

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (studentOptional.isPresent())
			return studentMapper.toGetResponseDTO(studentOptional.get());

		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public StudentUpdateResponseDTO updateStudent(StudentCreateRequestDTO createRequestDTO, int id) {
		LOG.debug("updateStudent()");

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (!studentOptional.isPresent())
			throw new RuntimeException("Student not found");

		Student studentDB = studentOptional.get();
		studentDB.setFirstName(createRequestDTO.getFirstName());
		studentDB.setLastName(createRequestDTO.getLastName());
		studentDB.setUserName(createRequestDTO.getUserName());
		studentDB.setPassword(createRequestDTO.getPassword());
		studentDB.setMobile(createRequestDTO.getMobile());
		studentDB.setEmail(createRequestDTO.getEmail());

		studentDB = studentRepository.save(studentDB);

		return studentMapper.toUpdateResponseDTO(studentDB);
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteStudent(int id) {
		LOG.debug("deleteStudent()");

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (studentOptional.isPresent()) {
			studentRepository.delete(studentOptional.get());
			return true;
		} else
			throw new RuntimeException("Student not found");
	}

	@Override
	public List<StudentListResponseDTO> getAllStudents() {
		LOG.debug("getAllStudents()");

		Iterable<Student> studentsListDB = studentRepository.findAll();

		List<StudentListResponseDTO> studentsListDTO = new ArrayList<>();

		studentsListDB.forEach(studentDB -> {
			studentsListDTO.add(studentMapper.toListResponseDTO(studentDB));
		});

		return studentsListDTO;
	}
}
