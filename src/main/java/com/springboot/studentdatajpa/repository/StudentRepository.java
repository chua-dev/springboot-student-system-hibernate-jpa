package com.springboot.studentdatajpa.repository;

import com.springboot.studentdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom Jpa Method EG: Get student by firstName
    List<Student> findByFirstName(String firstName);

    // Custom Jpa Method First Name Containing
    List<Student> findByFirstNameContaining(String name);

    // LastNameNotNull
    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);
}
