package controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChildDto {
    @NotNull(message = "Empty firstName field")
    @Size(message = "firstName is too long (max = 25)", max = 25)
    private String firstName;
    @NotNull(message = "Empty lastName field")
    @Size(message = "lastName is too long (max = 25)", max = 25)
    private String lastName;
    @NotNull(message = "Empty patronymic field")
    @Size(message = "patronymic is too long (max = 25)", max = 25)
    private String patronymic;
    @NotNull(message = "Empty age field")
    private int age;
    @NotNull(message = "Empty numberOfSchool field")
    @Size(message = "numberOfSchool is too long (max = 10)", max = 10)
    private String numberOfSchool;
    @NotNull(message = "Empty schoolClass field")
    @Size(message = "schoolClass is too long (max = 10)", max = 10)
    private String schoolClass;
    @NotNull(message = "Empty numberOfBirthCertificate field")
    @Size(message = "numberOfBirthCertificate is too long (max = 25)", max = 25)
    private String numberOfBirthCertificate;
    @NotNull(message = "Empty dateOfBirthCertificate field")
    @Size(message = "dateOfBirthCertificate is too long (max = 10)", max = 10)
    private String dateOfBirthCertificate;
    @NotNull(message = "Empty address field")
    @Size(message = "address is too long (max = 50)", max = 50)
    private String address;
    @NotNull(message = "Empty phoneNumber field")
    @Size(message = "phoneNumber is too long (max = 25)", max = 25)
    private String phoneNumber;
    @NotNull(message = "Empty fullNameDad field")
    @Size(message = "fullNameDad is too long (max = 50)", max = 50)
    private String fullNameDad;
    @NotNull(message = "Empty phoneNumberDad field")
    @Size(message = "phoneNumberDad is too long (max = 25)", max = 25)
    private String phoneNumberDad;
    @NotNull(message = "Empty fullNameMum field")
    @Size(message = "fullNameMum is too long (max = 50)", max = 50)
    private String fullNameMum;
    @NotNull(message = "Empty phoneNumberMum field")
    @Size(message = "phoneNumberMum is too long (max = 25)", max = 25)
    private String phoneNumberMum;
}
