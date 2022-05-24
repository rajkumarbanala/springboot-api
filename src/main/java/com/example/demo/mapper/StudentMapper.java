package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;
import com.example.demo.dto.StudentGetResponseDTO;
import com.example.demo.dto.StudentListResponseDTO;
import com.example.demo.dto.StudentUpdateRequestDTO;
import com.example.demo.dto.StudentUpdateResponseDTO;
import com.example.demo.entity.Student;

@Mapper
public interface StudentMapper {
	
	public Student toEntity(StudentCreateRequestDTO studentCreateRequestDTO);
	
	public Student toEntity(StudentUpdateRequestDTO studentUpdateRequestDTO);

	public StudentCreateResponseDTO toCreateResponseDTO(Student student);
	
	public StudentUpdateResponseDTO toUpdateResponseDTO(Student student);
	
	public StudentGetResponseDTO toGetResponseDTO(Student student);
	
	public StudentListResponseDTO toListResponseDTO(Student student);
}
