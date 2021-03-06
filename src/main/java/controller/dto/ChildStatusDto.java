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
public class ChildStatusDto {
    @NotNull(message = "Empty childName field")
    private String childName;
    @NotNull(message = "Empty newGroupNumber field")
    private int newGroupNumber;

    private int oldGroupNumber;
    @NotNull(message = "Empty todayDate field")
    private String todayDate;
}
