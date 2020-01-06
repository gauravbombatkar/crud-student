package com.crudstudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudstudent.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
