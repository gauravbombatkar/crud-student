package com.crudstudent.service;

import java.util.List;

import com.crudstudent.model.Student;

/**
 * @author Gaurav Bombatkar
 */

public interface StudentService {
	
	public Student createStudent(Student student,Long id);
	
	public void deleteStudentById(Long id);
	
	public Student getStudentById(Long id);
	
	public Student updateStudent(Long id,Student student);
	
	public List<Student> getAll();
	

}
