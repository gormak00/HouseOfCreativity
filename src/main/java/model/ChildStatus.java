package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChildStatus {
    private int id;
    private int child_id;
    private int group_number;
    private String start_date;
    private String end_date;
}
