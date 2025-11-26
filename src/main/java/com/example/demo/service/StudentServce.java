package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentCreateRequestDTO;
import com.example.demo.dto.StudentCreateResponseDTO;

public interface StudentServce {

	public List<StudentCreateResponseDTO> getAllStudents();

	public StudentCreateResponseDTO addStudent(StudentCreateRequestDTO studentCreateRequestDTO);

	public StudentCreateResponseDTO getStudent(int id);

	public StudentCreateResponseDTO updateStudent(StudentCreateRequestDTO studentCreateRequestDTO);

	public boolean deleteStudent(int id);

}
