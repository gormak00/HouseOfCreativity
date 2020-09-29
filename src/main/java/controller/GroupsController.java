package controller;

import controller.dto.GroupsDto;
import controller.dto.GroupsMapper;
import javafx.scene.Group;
import model.Groups;
import repository.GroupsRepository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupsController {
    private GroupsRepository groupsRepository;
    private List<Groups> allGroups;

    public void addGroup(GroupsDto groupsDto) throws IOException, SQLException {
        groupsRepository = new GroupsRepository();
        Groups groups = GroupsMapper.toGroups(groupsDto);
        groupsRepository.addGroup(groups);
    }

    public void removeGroup(Groups groups) throws SQLException, IOException {
        groupsRepository = new GroupsRepository();
        groupsRepository.removeGroups(groups);
    }

    public List<Groups> getAllGroups() throws SQLException, IOException {
        allGroups = new ArrayList<>();
        groupsRepository = new GroupsRepository();
        fromResultSetToAllGroupsSet(groupsRepository.getAllGroups(), allGroups);
        return allGroups;
    }

    private void fromResultSetToAllGroupsSet(ResultSet resultSet, List<Groups> resultList) throws SQLException {
        while (resultSet.next()) {
            Groups currentGroups = new Groups();
            currentGroups.setNumber(resultSet.getInt(1));
            currentGroups.setName(resultSet.getString(2));
            currentGroups.setSection_number(resultSet.getInt(3));

            resultList.add(currentGroups);
        }
        resultSet.close();
    }

    public Groups getGroupByNumber(int groupNumber) throws IOException, SQLException {
        groupsRepository = new GroupsRepository();
        allGroups = new ArrayList<>();
        fromResultSetToAllGroupsSet(groupsRepository.getGroupByNumber(groupNumber), allGroups);
        return allGroups.get(0);
    }
}
