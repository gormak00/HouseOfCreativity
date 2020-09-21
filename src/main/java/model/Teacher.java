package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Teacher {
    //private int id;
    private String passport_number;
    private String first_name;
    private String last_name;
    private String patronymic;
    private String date_of_birth;
    private String sex;
    private String family_status;
    private String education;
    private String address;
    private String phone_number;
    private String specialization;
}
