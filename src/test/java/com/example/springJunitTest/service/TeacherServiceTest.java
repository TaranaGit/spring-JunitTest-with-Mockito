package com.example.springJunitTest.service;

import com.example.springJunitTest.entity.Teacher;
import com.example.springJunitTest.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @MockBean
    private TeacherRepository teacherRepository;

    @BeforeEach
    void setUp() {
        Teacher teacher = Teacher.builder()
                .teacherId(1L)
                .teacherName("Donald")
                .teacherPhone("123456")
                .teacherEmail("don@gmail.com")
                .courseTaught("javascript")
                .build();
        Mockito.when(teacherRepository.findByTeacherName("Donald"))
                .thenReturn(teacher);
    }
    @Test
    @DisplayName("Get Data based on valid Teacher Name")
    public void whenValidTeacherName_thenTeacherShouldFound(){
    String teacherName = "Donald";
        Teacher foundTeacherName = teacherService.fetchTeacherByName(teacherName);
        assertEquals(teacherName, foundTeacherName.getTeacherName());
    }

}