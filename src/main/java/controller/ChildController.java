package controller;

import controller.dto.ChildDto;
import controller.dto.ChildMapper;
import lombok.NoArgsConstructor;
import model.Child;
import repository.ChildRepository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ChildController {
    private ChildRepository childRepository;
    private List<Child> allChildren;

    public void addChild(ChildDto childDto) throws SQLException, IOException {
        childRepository = new ChildRepository();
        Child child = ChildMapper.toChild(childDto);
        childRepository.addChild(child);
    }

    public List<Child> getAllChildren() throws SQLException, IOException {
        childRepository = new ChildRepository();
        allChildren = new ArrayList<>();
        fromResultSetToChildList(childRepository.getAllChildren(), allChildren);
        return allChildren;
    }

    public void removeChild(Child child) throws IOException, SQLException {
        childRepository = new ChildRepository();
        int id = childRepository.getChildIdByNumberOfBirthCertificate(child.getNumber_of_birth_certificate());
        childRepository.removeChild(id);
    }

    public void changeChild(ChildDto childDto, Child oldChild) throws IOException, SQLException {
        Child child = ChildMapper.toChild(childDto);
        childRepository = new ChildRepository();
        int id = childRepository.getChildIdByNumberOfBirthCertificate(oldChild.getNumber_of_birth_certificate());
        childRepository.changeChild(child, id);
    }

    private void fromResultSetToChildList(ResultSet resultSet, List<Child> resultList) throws SQLException {
        while (resultSet.next()) {
            Child currentChild = new Child();
            currentChild.setFirst_name(resultSet.getString(2));
            currentChild.setLast_name(resultSet.getString(3));
            currentChild.setPatronymic(resultSet.getString(4));
            currentChild.setAge(resultSet.getInt(5));
            currentChild.setNumber_of_school(resultSet.getString(6));
            currentChild.setSchool_class(resultSet.getString(7));
            currentChild.setNumber_of_birth_certificate(resultSet.getString(8));
            currentChild.setDate_of_birth_certificate(resultSet.getString(9));
            currentChild.setAddress(resultSet.getString(10));
            currentChild.setPhone_number(resultSet.getString(11));
            currentChild.setFull_name_dad(resultSet.getString(12));
            currentChild.setPhone_number_dad(resultSet.getString(13));
            currentChild.setFull_name_mum(resultSet.getString(14));
            currentChild.setPhone_number_mum(resultSet.getString(15));

            resultList.add(currentChild);
        }
        resultSet.close();
    }
}
