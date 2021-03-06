package controller;

import controller.dto.TeacherDto;
import controller.dto.TeacherMapper;
import model.Teacher;
import repository.TeacherRepository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherController {
    private TeacherRepository teacherRepository;
    private List<Teacher> allTeachers;
    private List<String> fullNamesTeachers;
    private String[] subStr;
    private String firstName, lastName, patronymic;
    private static String delimeter = " ";

    public void addTeacher(TeacherDto teacherDto) throws IOException, SQLException {
        teacherRepository = new TeacherRepository();
        Teacher teacher = TeacherMapper.toTeacher(teacherDto);
        teacherRepository.addTeacher(teacher);
    }

    public List<Teacher> getAllTeachersList() throws IOException, SQLException {
        teacherRepository = new TeacherRepository();
        allTeachers = new ArrayList<>();
        fromResultSetToTeacherList(teacherRepository.getAllTeachers(), allTeachers);
        return allTeachers;
    }

    public void removeTeacher(Teacher teacher) throws IOException, SQLException {
        teacherRepository = new TeacherRepository();
        int id = teacherRepository.getTeacherIdByPassportNumber(teacher.getPassport_number());
        teacherRepository.removeTeacherById(id);
    }

    public void changeTeacher(TeacherDto teacherDto, Teacher oldTeacher) throws IOException, SQLException {
        Teacher teacher = TeacherMapper.toTeacher(teacherDto);
        teacherRepository = new TeacherRepository();
        int id = teacherRepository.getTeacherIdByPassportNumber(oldTeacher.getPassport_number());
        teacherRepository.changeTeacher(teacher, id);
    }

    private void fromResultSetToTeacherList(ResultSet resultSet, List<Teacher> resultList) throws SQLException {
        while (resultSet.next()) {
            Teacher currentTeacher = new Teacher();
            currentTeacher.setPassport_number(resultSet.getString(2));
            currentTeacher.setFirst_name(resultSet.getString(3));
            currentTeacher.setLast_name(resultSet.getString(4));
            currentTeacher.setPatronymic(resultSet.getString(5));
            currentTeacher.setDate_of_birth(resultSet.getString(6));
            currentTeacher.setSex(resultSet.getString(7));
            currentTeacher.setFamily_status(resultSet.getString(8));
            currentTeacher.setEducation(resultSet.getString(9));
            currentTeacher.setAddress(resultSet.getString(10));
            currentTeacher.setPhone_number(resultSet.getString(11));
            currentTeacher.setSpecialization(resultSet.getString(12));

            resultList.add(currentTeacher);
        }
        resultSet.close();
    }

    public int getTeacherIdByFullName(String fullName) throws SQLException, IOException {
        splitStringTo3Words(fullName);
        teacherRepository = new TeacherRepository();
        return teacherRepository.getTeacherIdByFullName(firstName, lastName, patronymic);
    }

    private void splitStringTo3Words(String fullWord) {
        subStr = fullWord.split(delimeter, 3); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
        lastName = subStr[0];
        firstName = subStr[1];
        patronymic = subStr[2];
    }

    public List<String> getFullNamesList() throws IOException, SQLException {
        teacherRepository = new TeacherRepository();
        fullNamesTeachers = new ArrayList<>();
        return fromResultSetToFullNamesList(teacherRepository.getAllFullNamesTeachers(), fullNamesTeachers);
    }

    private List<String> fromResultSetToFullNamesList(ResultSet resultSet, List<String> resultList) throws SQLException {
        while (resultSet.next()) {
            String fullName = resultSet.getString(2) + delimeter + resultSet.getString(1) + delimeter + resultSet.getString(3);

            resultList.add(fullName);
        }
        resultSet.close();
        return resultList;
    }
}
