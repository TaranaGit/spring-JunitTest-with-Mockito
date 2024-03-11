package com.example.springJunitTest.Controller;

import com.example.springJunitTest.entity.Teacher;
import com.example.springJunitTest.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public List<Teacher> fetchTeacherList(){
    return teacherService.fetchTeacherList();
    }

    @GetMapping("/teachers/{id}")
    public Optional<Teacher> fetchTeacherById(@PathVariable("id") Long teacherId){
        return teacherService.fetchTeacherById(teacherId);
    }

    @GetMapping("/teachers/name/{name}")
    public Teacher fetchTeacherByName(@PathVariable("name") String teacherName){
        return  teacherService.fetchTeacherByName(teacherName);
    }

    @PostMapping("/teachers")
    public Teacher saveTeacherInfo(@RequestBody Teacher teacher){
        return  teacherService.saveTeacher(teacher);
    }
    @DeleteMapping("/teachers/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long teacherId){
         teacherService.deleteTeacherById(teacherId);
    }
    @PutMapping("/teachers/{id}")
        public Teacher UpdateTeacherInfo(@PathVariable("id") Long teacherId,
                                         @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacherId, teacher);
    }

}
