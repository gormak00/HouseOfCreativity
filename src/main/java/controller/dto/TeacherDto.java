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
public class TeacherDto {
    @NotNull(message = "Empty passportNumber field")
    @Size(message = "passportNumber is too long (max = 9)", max = 9)
    private String passportNumber;
    @NotNull(message = "Empty firstName field")
    @Size(message = "firstName is too long (max = 25)", max = 25)
    private String firstName;
    @NotNull(message = "Empty lastName field")
    @Size(message = "lastName is too long (max = 25)", max = 25)
    private String lastName;
    @NotNull(message = "Empty patronymic field")
    @Size(message = "patronymic is too long (max = 25)", max = 25)
    private String patronymic;
    @NotNull(message = "Empty dateOfBirth field")
    @Size(message = "dateOfBirth is too long (max = 10)", max = 10)
    private String dateOfBirth;
    @NotNull(message = "Empty sex field")
    @Size(message = "sex is too long (max = 10)", max = 10)
    private String sex;
    @NotNull(message = "Empty familyStatus field")
    @Size(message = "familyStatus is too long (max = 25)", max = 25)
    private String familyStatus;
    @NotNull(message = "Empty education field")
    @Size(message = "education is too long (max = 50)", max = 50)
    private String education;
    @NotNull(message = "Empty address field")
    @Size(message = "address is too long (max = 25)", max = 25)
    private String address;
    @NotNull(message = "Empty phoneNumber field")
    @Size(message = "phoneNumber is too long (max = 25)", max = 25)
    private String phoneNumber;
    @NotNull(message = "Empty specialization field")
    @Size(message = "specialization is too long (max = 100)", max = 100)
    private String specialization;
}
