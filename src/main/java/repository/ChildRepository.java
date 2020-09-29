package repository;

import model.Child;

import java.io.IOException;
import java.sql.*;

public class ChildRepository extends ConnectionToDB {
    private Connection con;

    public ChildRepository() throws IOException, SQLException {
        con = getConnectionFromDB();
    }

    public void addChild(Child child) throws SQLException {
        String SQL = "INSERT INTO child (first_name, last_name, patronymic, age, number_of_school, school_class, number_of_birth_certificate, date_of_birth_certificate, address, phone_number, full_name_dad, phone_number_dad, full_name_mum, phone_number_mum)\n" +
                "VALUES\n (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, child.getFirst_name());
        preparedStatement.setString(2, child.getLast_name());
        preparedStatement.setString(3, child.getPatronymic());
        preparedStatement.setInt(4, child.getAge());
        preparedStatement.setString(5, child.getNumber_of_school());
        preparedStatement.setString(6, child.getSchool_class());
        preparedStatement.setString(7, child.getNumber_of_birth_certificate());
        preparedStatement.setString(8, child.getDate_of_birth_certificate());
        preparedStatement.setString(9, child.getAddress());
        preparedStatement.setString(10, child.getPhone_number());
        preparedStatement.setString(11, child.getFull_name_dad());
        preparedStatement.setString(12, child.getPhone_number_dad());
        preparedStatement.setString(13, child.getFull_name_mum());
        preparedStatement.setString(14, child.getPhone_number_mum());

        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public ResultSet getAllChildren() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM child;");
        statement.close();
        con.close();
        return resultSet;
    }

    public int getChildIdByNumberOfBirthCertificate(String numberOfBirthCertificate) throws SQLException {
        int id = 0;
        String SQL = "SELECT id FROM child WHERE number_of_birth_certificate = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, numberOfBirthCertificate);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        resultSet.close();
        return id != 0 ? id : null;
    }

    public void removeChild(int id) throws SQLException {
        String SQL = "DELETE FROM child WHERE id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public void changeChild(Child child, int id) throws SQLException {
        String SQL = "UPDATE child " +
                "SET first_name = ?, " +
                "last_name= ?, " +
                "patronymic= ?, " +
                "age= ?, " +
                "number_of_school= ?, " +
                "school_class= ?, " +
                "number_of_birth_certificate= ?, " +
                "date_of_birth_certificate= ?, " +
                "address= ?, " +
                "phone_number= ?, " +
                "full_name_dad= ?, " +
                "phone_number_dad= ?, " +
                "full_name_mum= ?, " +
                "phone_number_mum= ? " +
                "WHERE id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, child.getFirst_name());
        preparedStatement.setString(2, child.getLast_name());
        preparedStatement.setString(3, child.getPatronymic());
        preparedStatement.setInt(4, child.getAge());
        preparedStatement.setString(5, child.getNumber_of_school());
        preparedStatement.setString(6, child.getSchool_class());
        preparedStatement.setString(7, child.getNumber_of_birth_certificate());
        preparedStatement.setString(8, child.getDate_of_birth_certificate());
        preparedStatement.setString(9, child.getAddress());
        preparedStatement.setString(10, child.getPhone_number());
        preparedStatement.setString(11, child.getFull_name_dad());
        preparedStatement.setString(12, child.getPhone_number_dad());
        preparedStatement.setString(13, child.getFull_name_mum());
        preparedStatement.setString(14, child.getPhone_number_mum());
        preparedStatement.setInt(15, id);

        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public ResultSet getAllChildrenFullNames() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT last_name, first_name, patronymic FROM child;");
        statement.close();
        con.close();
        return resultSet;
    }

    public ResultSet getChildIdByFullName(String lastName, String firstName, String patronymic) throws SQLException {
        String SQL = "SELECT id FROM child WHERE last_name = ? AND first_name = ? AND patronymic = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, lastName);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, patronymic);

        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        con.close();
        return resultSet;
    }

    public ResultSet getAllChildrenById(int childId) throws SQLException {
        String SQL = "SELECT * FROM child WHERE id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, childId);

        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        return resultSet;
    }

    public ResultSet getChildByFullName(String lastName, String firstName, String patronymic) throws SQLException {
        String SQL = "SELECT * FROM child WHERE last_name = ? AND first_name = ? AND patronymic = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, lastName);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, patronymic);

        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        con.close();
        return resultSet;
    }
}
