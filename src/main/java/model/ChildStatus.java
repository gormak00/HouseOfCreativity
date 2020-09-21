package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ChildStatus {
    private int id;
    private int child_id;
    private int group_number;
    private String start_date;
    private String end_date;
}
