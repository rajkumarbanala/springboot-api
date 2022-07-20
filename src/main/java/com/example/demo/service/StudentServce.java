package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;
import com.example.demo.dto.StudentGetResponseDTO;
import com.example.demo.dto.StudentListResponseDTO;
import com.example.demo.dto.StudentUpdateResponseDTO;

public interface StudentServce {

	public List<StudentListResponseDTO> getAllStudents();

	public StudentCreateResponseDTO addStudent(StudentCreateRequestDTO studentCreateRequestDTO);

	public StudentGetResponseDTO getStudent(int id);

	public StudentUpdateResponseDTO updateStudent(StudentCreateRequestDTO studentCreateRequestDTO,int id);

	public boolean deleteStudent(int id);

}
