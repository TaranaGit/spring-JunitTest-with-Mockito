package com.example.springJunitTest.Controller;

import com.example.springJunitTest.entity.Teacher;
import com.example.springJunitTest.service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(TeacherController .class)
class TeacherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherService teacherService;

    private Teacher teacher;

    @BeforeEach
    void setUp() {
         teacher = Teacher.builder()
                 .teacherId(1L)
                .teacherName("Donald")
                .teacherPhone("123456")
                .teacherEmail("don@gmail.com")
                .courseTaught("javascript")
                .build();
    }

    @Test
    void saveTeacherInfo() throws Exception {
    Teacher inputTeacher = Teacher.builder()
            .teacherName("Donald")
            .teacherPhone("123456")
            .teacherEmail("don@gmail.com")
            .courseTaught("javascript")
            .build();

        Mockito.when(teacherService.saveTeacher(inputTeacher))
                .thenReturn(teacher);

        mockMvc.perform(MockMvcRequestBuilders.post("/teachers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "       \"teacherName\": \"Donald\",\n" +
                        "       \"teacherEmail\": \"don@gmail.com\",\n" +
                        "       \"teacherPhone\": \"123456\",\n" +
                        "       \"courseTaught\": \"javascript\"\n" +
                        "   }\n"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchTeacherById() throws Exception {
    Mockito.when(teacherService.fetchTeacherById(1L))
            .thenReturn(Optional.ofNullable(teacher));

    mockMvc.perform(MockMvcRequestBuilders.get("/teachers/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }


}