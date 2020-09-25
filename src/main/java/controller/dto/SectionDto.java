package controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SectionDto {
    @NotNull(message = "Empty number field")
    private int number;
    @NotNull(message = "Empty name field")
    private String name;
    @NotNull(message = "Empty fullNameTeacher field")
    private String fullNameTeacher;
}
