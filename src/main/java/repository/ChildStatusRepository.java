package repository;

import model.ChildStatus;

import java.io.IOException;
import java.sql.*;

public class ChildStatusRepository extends ConnectionToDB{
    private Connection con;
    public ChildStatusRepository() throws IOException, SQLException {
        con = getConnectionFromDB();
    }

    public ResultSet getGrupsNumbersFromFullNameChild(String lastName, String firstName, String patronymic) throws SQLException {
        String SQL = "SELECT group_number FROM child_status WHERE end_date IS null AND child_id = (SELECT id FROM child WHERE last_name = ? AND first_name = ? AND patronymic = ?);";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, lastName);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, patronymic);

        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        con.close();
        return resultSet;
    }

    public void addChildStatus(ChildStatus childStatus) throws SQLException {
        String SQL = "INSERT INTO child_status (child_id, group_number, start_date, end_date)\n" +
                "VALUES\n (?, ?, ?, null);";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, childStatus.getChild_id());
        preparedStatement.setInt(2, childStatus.getGroup_number());
        preparedStatement.setString(3, childStatus.getStart_date());

        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public void setEndDateByChildIdAndGroup(int id, int oldGroupNumber, String todayDate) throws SQLException {
        String SQL = "UPDATE child_status " +
                "SET end_date = ? " +
                "WHERE child_id = ? AND group_number = ? AND end_date IS null;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, todayDate);
        preparedStatement.setInt(2, id);
        preparedStatement.setInt(3, oldGroupNumber);

        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public ResultSet getAllChildrenByGroupNumber(int groupNumber) throws SQLException {
        String SQL = "SELECT * FROM child_status WHERE group_number = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, groupNumber);

        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        con.close();
        return resultSet;
    }

    public ResultSet getAllChildStatusByChildId(int childId) throws SQLException {
        String SQL = "SELECT * FROM child_status WHERE child_id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, childId);

        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        con.close();
        return resultSet;
    }
}
