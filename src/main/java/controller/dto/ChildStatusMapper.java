package controller.dto;

import model.ChildStatus;
import org.mapstruct.Mapper;

@Mapper
public interface ChildStatusMapper {
    static ChildStatus toChildStatus(ChildStatusDto childStatusDto, int childId, String todayDate) {
        ChildStatus childStatus = new ChildStatus();
        childStatus.setChild_id(childId);
        childStatus.setGroup_number(childStatusDto.getGroupNumber());
        childStatus.setStart_date(todayDate);
        childStatus.setEnd_date(null);
        return childStatus;
    }
}
