package controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class SectionDto {
    @NotNull(message = "Empty number field")
    private int number;
    @NotNull(message = "Empty name field")
    private String name;
    @NotNull(message = "Empty teacherLastName field")
    private String teacherLastName;
}
