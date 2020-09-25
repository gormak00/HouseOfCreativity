package controller;

import controller.dto.ChildStatusDto;
import controller.dto.ChildStatusMapper;
import model.Child;
import model.ChildStatus;
import model.Groups;
import model.Teacher;
import repository.ChildRepository;
import repository.ChildStatusRepository;
import repository.GroupsRepository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChildStatusController {
    private ChildStatusRepository childStatusRepository;
    private ChildRepository childRepository;
    private GroupsRepository groupsRepository;
    private String[] subStr;
    private String firstName, lastName, patronymic;
    private static String delimeter = " ";
    private List<Integer> childGroupsList, allGroupsList, notChildGroupsList;

    public List<Integer> getFreeGroupsByChild(String fullNameOfChild) throws IOException, SQLException {
        if (fullNameOfChild.equals("Не выбрано")) return null;
        createChildGroupsList(fullNameOfChild);
        createAllGroupsList();
        createNotChildGroupsList(allGroupsList, childGroupsList);
        System.out.println(allGroupsList.size());
        System.out.println(childGroupsList.size());
        System.out.println(notChildGroupsList.size());
        return notChildGroupsList;

    }

    private void createNotChildGroupsList(List<Integer> allGroupsList, List<Integer> childGroupsList){
        boolean equal = false;
        notChildGroupsList = new ArrayList<>();
        for (int number: allGroupsList) {
            for (int number2: childGroupsList){
                if (number == number2){
                    equal = true;
                }
            }
            if (equal == false) notChildGroupsList.add(number);
            equal = false;
        }
    }

    private void createAllGroupsList() throws IOException, SQLException {
        groupsRepository = new GroupsRepository();
        allGroupsList = new ArrayList<>();
        fromResultSetToGroupsList(groupsRepository.getAllGroups(), allGroupsList);
    }

    private void createChildGroupsList(String fullNameOfChild) throws SQLException, IOException {
        childStatusRepository = new ChildStatusRepository();
        splitStringTo3Words(fullNameOfChild);
        childGroupsList = new ArrayList<>();
        fromResultSetToGroupsList(this.childStatusRepository.getGrupsNumbersFromFullNameChild(lastName, firstName, patronymic), childGroupsList);
    }

    private void splitStringTo3Words(String fullWord) {
        subStr = fullWord.split(delimeter, 3); // Разбить строку str с порогом равным 3, который означает, как много подстрок, должно быть возвращено.
        lastName = subStr[0];
        firstName = subStr[1];
        patronymic = subStr[2];
        System.out.println(firstName + " " + lastName + " " + patronymic);
    }

    private void fromResultSetToGroupsList(ResultSet resultSet, List<Integer> resultList) throws SQLException {
        while (resultSet.next()) {
            resultList.add(resultSet.getInt(1));
        }
        resultSet.close();
    }

    private int fromResultSetToInt(ResultSet resultSet) throws SQLException {
        int id = 0;
        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        resultSet.close();
        return id;
    }

    public void addChildStatus(ChildStatusDto childStatusDto) throws IOException, SQLException {
        childStatusRepository = new ChildStatusRepository();
        splitStringTo3Words(childStatusDto.getChildName());
        childRepository = new ChildRepository();
        int id = fromResultSetToInt(childRepository.getChildIdByFullName(lastName, firstName, patronymic));
        ChildStatus childStatus = ChildStatusMapper.toChildStatus(childStatusDto, id);
        childStatusRepository.addChildStatus(childStatus);
    }
}
