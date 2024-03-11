package com.example.springJunitTest.repository;

import com.example.springJunitTest.entity.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Teacher teacher = Teacher.builder()
                .teacherName("Donald")
                .teacherPhone("123456")
                .teacherEmail("don@gmail.com")
                .courseTaught("javascript")
                .build();
        testEntityManager.persist(teacher);
    }

    @Test
    @DisplayName("Get Data based on teacher name")
    public void whenFindById_thenReturnTeacher(){
        Teacher teacher = teacherRepository.findById(1L).get();
        assertEquals(teacher.getTeacherName(), "Donald");
    }
}