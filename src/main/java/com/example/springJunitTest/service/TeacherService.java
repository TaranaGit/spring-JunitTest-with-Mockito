package com.example.springJunitTest.service;

import com.example.springJunitTest.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    public Teacher saveTeacher(Teacher teacher);
    //returning bunch of teachers
    public List<Teacher>  fetchTeacherList();
    // return only one teacher info
    Optional<Teacher> fetchTeacherById(Long teacherId);
    // not returning anything
    public void deleteTeacherById(Long teacherId);

    Teacher updateTeacher(Long teacherId, Teacher teacher);

    Teacher fetchTeacherByName(String teacherName);
}
