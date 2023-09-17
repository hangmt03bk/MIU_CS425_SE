package edu.mum.cs.cs425.eregistrar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs425.eregistrar.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
