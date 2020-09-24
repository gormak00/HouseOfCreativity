package controller.dto;

import model.Section;
import org.mapstruct.Mapper;

@Mapper
public interface SectionMapper {
    static Section toSection(SectionDto sectionDto, int teacherId) {
        Section section = new Section();
        section.setNumber(sectionDto.getNumber());
        section.setName(sectionDto.getName());
        section.setTeacher_id(teacherId);
        return section;
    }
}
