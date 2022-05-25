package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entity.Guardian;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;
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
                .emailId("yufanren@yahoo.com")
                .firstName("yufan")
                .lastName("ren")
//                .guardianName("huren")
//                .guardianEmail("huren@gmail.com")
//                .guardianMobile("12345678901")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Abbadon")
                .email("abbadon@yahoo.com")
                .mobile("16669999999")
                .build();

        Student student = Student.builder()
                .firstName("alice")
                .lastName("ren")
                .emailId("aliceren@yahoo.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> student =
                studentRepository.findByFirstNameContaining("ali");

        System.out.println("student = " + student);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("abbadon");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnFullName() {
        Student students =
                studentRepository.findByFirstNameAndLastName("alice", "ren");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
//        Student student =
//                studentRepository.getStudentByEmailAddress("yufanren@yahoo.com");

        String firstName =
                studentRepository.getStudentFirstnameByEmailAddress("yufanren@yahoo.com");

        System.out.println("student firstname = " + firstName);
    }

    @Test
    public void printStudentByEmailAddressNative() {

        Student student =
                studentRepository.getStudentByEmailAddressNative("yufanren@yahoo.com");

        System.out.println("student firstname = " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {

        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("yufanren@yahoo.com");

        System.out.println("student firstname = " + student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId(
                "fernando",
                "yufanren@yahoo.com");
    }
}