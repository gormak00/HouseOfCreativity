package controller.dto;

import model.Child;
import org.mapstruct.Mapper;

@Mapper
public interface ChildMapper {
    static Child toChild(ChildDto childDto) {
        Child child = new Child();
        child.setFirst_name(childDto.getFirstName());
        child.setLast_name(childDto.getLastName());
        child.setPatronymic(childDto.getPatronymic());
        child.setAge(childDto.getAge());
        child.setNumber_of_school(childDto.getNumberOfSchool());
        child.setSchool_class(childDto.getSchoolClass());
        child.setNumber_of_birth_certificate(childDto.getNumberOfBirthCertificate());
        child.setDate_of_birth_certificate(childDto.getDateOfBirthCertificate());
        child.setAddress(childDto.getAddress());
        child.setPhone_number(childDto.getPhoneNumber());
        child.setFull_name_dad(childDto.getFullNameDad());
        child.setPhone_number_dad(childDto.getPhoneNumberDad());
        child.setFull_name_mum(childDto.getFullNameMum());
        child.setPhone_number_mum(childDto.getPhoneNumberMum());
        return child;
    }
}
