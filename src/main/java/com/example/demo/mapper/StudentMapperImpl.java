package com.example.demo.mapper;

import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;
@Component
public class StudentMapperImpl implements StudentMapper {

	@Override
	public Student toEntity(StudentCreateRequestDTO studentCreateRequestDTO) {
		Student s= new Student();
		s.setId(studentCreateRequestDTO.getId());
		s.setFirstName(studentCreateRequestDTO.getFirstName());
		s.setLastName(studentCreateRequestDTO.getLastName());
		s.setUserName(studentCreateRequestDTO.getUserName());
		s.setEmail(studentCreateRequestDTO.getEmail());
		s.setPassword(studentCreateRequestDTO.getPassword());
		s.setMobile(studentCreateRequestDTO.getMobile());
		return s;
	}
	@Override
	public StudentCreateResponseDTO toCreateResponseDTO(Student student) {
		StudentCreateResponseDTO studentCreateResponseDTO = new StudentCreateResponseDTO();
		studentCreateResponseDTO.setId(student.getId());
		studentCreateResponseDTO.setFirstName(student.getFirstName());
		studentCreateResponseDTO.setLastName(student.getLastName());
		studentCreateResponseDTO.setUserName(student.getUserName());
		studentCreateResponseDTO.setEmail(student.getEmail());
		studentCreateResponseDTO.setPassword(student.getPassword());
		return studentCreateResponseDTO;
	
		
	}
}
