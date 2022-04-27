package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;
@Transactional
@Repository
public class StudentRepositoryImpl implements StudentRepository {
	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents() {

		String hql = "FROM Student";
		List<Student> result = entityManager.createQuery(hql, Student.class).getResultList();
		return result;
		
	}

	@Override
	public Student getStudent(int studentId) {
		return entityManager.find(Student.class, studentId);
	}

	@Override
	public Student createStudent(Student student) {
		entityManager.persist(student);
		Student s = getLastInsertedStudent();
		return s;
	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		Student studentFromDB = getStudent(studentId);
		studentFromDB.setFirstName(student.getFirstName());
		studentFromDB.setLastName(student.getLastName());;
		studentFromDB.setUserName(student.getUserName());
		studentFromDB.setPassword(student.getPassword());
		studentFromDB.setMobile(student.getMobile());
		studentFromDB.setEmail(student.getEmail());
		
		entityManager.flush();
		Student updatedStudent = getStudent(studentId);
		
		return updatedStudent;
	}

	@Override
	public boolean deleteStudent(int id) {
		Student student = getStudent(id);
		entityManager.remove(student);
	
		//we are checking here that whether entityManager contains earlier deleted student or not
		// if contains then student is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(student);
		if(status){
			return false;
		}
		return true;
	}
	private Student getLastInsertedStudent(){
		String hql = "from Student order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Student student = (Student)query.getSingleResult();
		return student;
	}

}
