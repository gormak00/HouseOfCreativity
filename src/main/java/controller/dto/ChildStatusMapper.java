package controller.dto;

import model.ChildStatus;
import org.mapstruct.Mapper;

@Mapper
public interface ChildStatusMapper {
    static ChildStatus toChildStatus(ChildStatusDto childStatusDto, int childId) {
        ChildStatus childStatus = new ChildStatus();
        childStatus.setChild_id(childId);
        childStatus.setGroup_number(childStatusDto.getNewGroupNumber());
        childStatus.setStart_date(childStatusDto.getTodayDate());
        childStatus.setEnd_date(null);
        return childStatus;
    }
    static ChildStatus toChildStatus(ChildStatusDto childStatusDto, int childId, String endDate) {
        ChildStatus childStatus = new ChildStatus();
        childStatus.setChild_id(childId);
        childStatus.setGroup_number(childStatusDto.getNewGroupNumber());
        childStatus.setStart_date(childStatusDto.getTodayDate());
        childStatus.setEnd_date(endDate);
        return childStatus;
    }
}
