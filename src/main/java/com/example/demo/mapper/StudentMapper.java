package com.example.demo.mapper;

import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;
import com.example.demo.entity.Student;
import org.mapstruct.Mapper;

//@Mapper
public interface StudentMapper {
	public Student toEntity(StudentCreateRequestDTO studentCreateRequestDTO);
	public StudentCreateResponseDTO toCreateResponseDTO(Student student);
}
