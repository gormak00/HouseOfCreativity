package repository;

import model.Groups;

import java.io.IOException;
import java.sql.*;

public class GroupsRepository extends ConnectionToDB {
    Connection con;

    public GroupsRepository() throws IOException, SQLException {
        con = getConnectionFromDB();
    }

    public void addGroup(Groups groups) throws SQLException {
        String SQL = "INSERT INTO groups (number, name, section_number)\n" +
                "VALUES\n (?, ?, ?);";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, groups.getNumber());
        preparedStatement.setString(2, groups.getName());
        preparedStatement.setInt(3, groups.getSection_number());

        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public void removeGroups(Groups groups) throws SQLException {
        String SQL = "DELETE FROM groups WHERE number = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, groups.getNumber());
        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public ResultSet getAllGroups() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM groups;");
        statement.close();
        con.close();
        return resultSet;
    }

    public ResultSet getGroupByNumber(int groupNumber) throws SQLException {
        String SQL = "SELECT * FROM groups WHERE number = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, groupNumber);

        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        con.close();
        return resultSet;
    }
}
