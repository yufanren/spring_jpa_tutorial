package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entity.Course;
import com.dailycodebuffer.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course = Course.builder()
                .title("TBD")
                .credit(3)
                .build();

        Course course2 = Course.builder()
                .title("TBD2")
                .credit(3)
                .build();

        List<Course> courseList = List.of(course, course2);

        Teacher teacher =
                Teacher.builder()
                        .firstName("steve")
                        .lastName("segal")
//                        .courses(courseList)
                        .build();

        teacherRepository.save(teacher);
    }
}