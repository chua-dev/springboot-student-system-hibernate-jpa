package com.springboot.studentdatajpa.repository;

import com.springboot.studentdatajpa.entity.Guardian;
import com.springboot.studentdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailAddress("adrian123@gmail.com")
                .firstName("adrian")
                .lastName("chee")
                //.guardianName("Guardian 1")
                //.guardianEmail("Guardian2@gmail.com")
                //.guardianMobile("9999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("jack12@gmail.ocm")
                .name("jacky")
                .mobile("010232312")
                .build();


        Student student = Student.builder()
                .firstName("eddie")
                .emailAddress("addie@gmail.com")
                .lastName("cgew")
                .guardian(guardian)
                .build();


        studentRepository.save(student);
    }

    @Test
    public void getAllStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Jack");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student List = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Javascript");

        System.out.println("students = " + studentList);
    }

    @Test
    public void printStudentLastNameNotNull() {
        List<Student> studentNotNull = studentRepository.findByLastNameNotNull();

        System.out.println("studentNotNull = " + studentNotNull);
    }

}