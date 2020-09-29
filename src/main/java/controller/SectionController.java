package controller;

import controller.dto.SectionDto;
import controller.dto.SectionMapper;
import model.Section;
import repository.SectionRepository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectionController {
    private TeacherController teacherController;
    private SectionRepository sectionRepository;
    private List<SectionDto> allSectionsDto;
    private List<Integer> allSectionsNumbers;

    public void addSection(SectionDto sectionDto) throws IOException, SQLException {
        teacherController = new TeacherController();
        sectionRepository = new SectionRepository();
        int id = teacherController.getTeacherIdByFullName(sectionDto.getFullNameTeacher());
        Section section = SectionMapper.toSection(sectionDto, id);

        sectionRepository.addSection(section);
    }

    public List<SectionDto> getAllSection() throws IOException, SQLException {
        sectionRepository = new SectionRepository();
        allSectionsDto = new ArrayList<>();
        fromResultSetToSectionDtoList(sectionRepository.getAllSectionDto(), allSectionsDto);
        return allSectionsDto;
    }

    private void fromResultSetToSectionDtoList(ResultSet resultSet, List<SectionDto> resultList) throws SQLException {
        while (resultSet.next()) {
            SectionDto currentSectionDto = new SectionDto();
            currentSectionDto.setName(resultSet.getString(1));
            currentSectionDto.setNumber(resultSet.getInt(2));
            currentSectionDto.setFullNameTeacher(resultSet.getString(4) + " " + resultSet.getString(3) + " " + resultSet.getString(5));

            resultList.add(currentSectionDto);
        }
        resultSet.close();
    }

    public void removeSection(SectionDto sectionDto) throws IOException, SQLException {
        sectionRepository = new SectionRepository();
        sectionRepository.removeSectionByNumber(sectionDto.getNumber());
    }

    public void changeSection(SectionDto sectionDto, SectionDto oldSectionDto) throws IOException, SQLException {
        teacherController = new TeacherController();
        sectionRepository = new SectionRepository();
        int id = teacherController.getTeacherIdByFullName(sectionDto.getFullNameTeacher());
        Section section = SectionMapper.toSection(sectionDto, id);

        sectionRepository.changeSection(section, oldSectionDto);
    }

    public List<Integer> getAllSectionNumbers() throws IOException, SQLException {
        allSectionsNumbers = new ArrayList<>();
        sectionRepository = new SectionRepository();
        fromResultSetToSectionNumbersList(sectionRepository.getAllSectionNumbers(), allSectionsNumbers);
        return allSectionsNumbers;
    }

    private void fromResultSetToSectionNumbersList(ResultSet resultSet, List<Integer> resultList) throws SQLException {
        while (resultSet.next()) {
            resultList.add(resultSet.getInt(1));
        }
        resultSet.close();
    }
}
