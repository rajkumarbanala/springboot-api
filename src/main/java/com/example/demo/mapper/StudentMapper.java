package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;
import com.example.demo.entity.Student;

@Mapper
public interface StudentMapper {
	public Student toEntity(StudentCreateRequestDTO studentCreateRequestDTO);
	public StudentCreateResponseDTO toCreateResponseDTO(Student student);
}
