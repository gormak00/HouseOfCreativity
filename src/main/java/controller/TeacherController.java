package controller;

import controller.dto.TeacherDto;
import controller.dto.TeacherMapper;
import model.Teacher;
import repository.TeacherRepository;

import java.io.IOException;
import java.sql.SQLException;

public class TeacherController {
    private TeacherRepository teacherRepository;

    public void addTeacher(TeacherDto teacherDto) throws IOException, SQLException {
        teacherRepository = new TeacherRepository();
        Teacher teacher = TeacherMapper.toTeacher(teacherDto);
        teacherRepository.addTeacher(teacher);
    }
}
