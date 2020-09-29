package controller.dto;

import model.Teacher;
import org.mapstruct.Mapper;

@Mapper
public interface TeacherMapper {
    static Teacher toTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setPassport_number(teacherDto.getPassportNumber());
        teacher.setFirst_name(teacherDto.getFirstName());
        teacher.setLast_name(teacherDto.getLastName());
        teacher.setPatronymic(teacherDto.getPatronymic());
        teacher.setDate_of_birth(teacherDto.getDateOfBirth());
        teacher.setSex(teacherDto.getSex());
        teacher.setFamily_status(teacherDto.getFamilyStatus());
        teacher.setEducation(teacherDto.getEducation());
        teacher.setAddress(teacherDto.getAddress());
        teacher.setPhone_number(teacherDto.getPhoneNumber());
        teacher.setSpecialization(teacherDto.getSpecialization());
        return teacher;
    }

    ;
}
