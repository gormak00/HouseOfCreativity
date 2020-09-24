package controller.dto;

import model.Groups;
import org.mapstruct.Mapper;

@Mapper
public interface GroupsMapper {
    static Groups toGroups(GroupsDto groupsDto) {
        Groups groups = new Groups();
        groups.setNumber(groupsDto.getNumber());
        groups.setName(groupsDto.getName());
        groups.setSection_number(groupsDto.getSectionNumber());
        return groups;
    }
}
