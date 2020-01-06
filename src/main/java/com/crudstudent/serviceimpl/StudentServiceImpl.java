package com.crudstudent.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudstudent.model.Student;
import com.crudstudent.repository.StudentRepository;
import com.crudstudent.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student,Long id) {
		if(id != null) {
			student.setId(id);
		}
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);

	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.getOne(id);
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		Student s = this.getStudentById(id);
		s.setAge(student.getAge());
		s.setCity(student.getCity());
		s.setEmail(student.getEmail());
		s.setFirstName(student.getFirstName());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAll() {
		
		return studentRepository.findAll();
	}

}
