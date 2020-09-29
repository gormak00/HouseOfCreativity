package controller;

import lombok.Getter;
import model.Child;
import model.ChildStatus;
import repository.ChildRepository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class ExtraController {
    private ChildStatusController childStatusController;
    private ChildController childController;
    private ChildRepository childRepository;
    private List<ChildStatus> childStatusList;
    private List<Integer> childIdByDateList;
    private List<Child> allChildrenByIdList, childList;
    private String[] subStr;
    private String firstName, lastName, patronymic;
    private static String delimeter = " ";
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");

    public List<Child> createChildGroupByDateTable(Date date, int groupNumber) throws IOException, SQLException, ParseException {
        childStatusController = new ChildStatusController();
        childController = new ChildController();
        childStatusList = new ArrayList<>();
        childStatusList = childStatusController.getAllChildrenByGroup(groupNumber);
        System.out.println(childStatusList.size());
        createChildIdByDateList(date);
        allChildrenByIdList = new ArrayList<>();
        allChildrenByIdList = childController.getAllChildrenById(childIdByDateList);
        System.out.println(allChildrenByIdList.size());
        System.out.println(childIdByDateList.size());
        return allChildrenByIdList;
    }

    private void createChildIdByDateList(Date date) throws ParseException {
        childIdByDateList = new ArrayList<>();
        for (ChildStatus currentChS : childStatusList) {
            Date chSStartDate = formatter.parse(currentChS.getStart_date());
            Date chSEndDate = null;
            if (currentChS.getEnd_date() != null) chSEndDate = formatter.parse(currentChS.getEnd_date());
            if (chSStartDate.getTime() < date.getTime() && (chSEndDate == null || chSEndDate.getTime() > date.getTime())) {
                childIdByDateList.add(currentChS.getChild_id());
            }
        }
    }

    public void createFullChildInfoByFullNameTable(String fullName) throws IOException, SQLException {
        childList = new ArrayList<>();
        childRepository = new ChildRepository();
        childController = new ChildController();
        splitStringTo3Words(fullName);
        fromResultSetToChildList(childRepository.getChildByFullName(lastName, firstName, patronymic), childList);
        childStatusList = new ArrayList<>();
        childStatusController = new ChildStatusController();
        childStatusList = childStatusController.getChildStatusListByChildId(childList.get(0).getId());
    }

    private void splitStringTo3Words(String fullWord) {
        subStr = fullWord.split(delimeter, 3); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
        lastName = subStr[0];
        firstName = subStr[1];
        patronymic = subStr[2];
        System.out.println(firstName + " " + lastName + " " + patronymic);
    }

    private void fromResultSetToChildList(ResultSet resultSet, List<Child> childList) throws SQLException {
        while (resultSet.next()) {
            Child currentChild = new Child();
            currentChild.setId(resultSet.getInt(1));
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
            childList.add(currentChild);
        }
        resultSet.close();
    }
}
