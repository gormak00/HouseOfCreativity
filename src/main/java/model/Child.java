package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Child {
    private int id;
    private String first_name;
    private String last_name;
    private String patronymic;
    private int age;
    private String number_of_school;
    private String school_class;
    private String number_of_birth_certificate;
    private String date_of_birth_certificate;
    private String address;
    private String phone_number;
    private String full_name_dad;
    private String phone_number_dad;
    private String full_name_mum;
    private String phone_number_mum;

}
