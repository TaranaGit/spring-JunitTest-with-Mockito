package com.example.springJunitTest.service;

import com.example.springJunitTest.entity.Teacher;
import com.example.springJunitTest.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> fetchTeacherList() {
        return teacherRepository.findAll() ;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Optional<Teacher> fetchTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId);
//        return  null;
    }

    @Override
    public void deleteTeacherById(Long teacherId) {
         teacherRepository.deleteById(teacherId);
    }

    @Override
    public Teacher updateTeacher(Long teacherId, Teacher teacher) {
        // first get the information of the id and then update
        Teacher depDB = teacherRepository.findById(teacherId).get();

        if(Objects.nonNull(teacher.getTeacherName()) &&
        !"".equalsIgnoreCase(teacher.getTeacherName()))
        {
        depDB.setTeacherName(teacher.getTeacherName());
        }

        if(Objects.nonNull(teacher.getTeacherPhone()) &&
                !"".equalsIgnoreCase(teacher.getTeacherPhone()))
        {
            depDB.setTeacherPhone(teacher.getTeacherPhone());
        }

        if(Objects.nonNull(teacher.getTeacherEmail()) &&
                !"".equalsIgnoreCase(teacher.getTeacherEmail()))
        {
            depDB.setTeacherEmail(teacher.getTeacherEmail());
        }

        if(Objects.nonNull(teacher.getCourseTaught()) &&
                !"".equalsIgnoreCase(teacher.getCourseTaught()))
        {
            depDB.setCourseTaught(teacher.getCourseTaught());
        }
        return teacherRepository.save(depDB);
    }

    @Override
    public Teacher fetchTeacherByName(String teacherName) {
        return teacherRepository.findByTeacherName(teacherName);

    }
}
