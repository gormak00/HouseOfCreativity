package repository;

import model.Teacher;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class TeacherRepository extends ConnectionToDB {
    private Connection con;
    private List<Teacher> allTeachers;

    public TeacherRepository() throws IOException, SQLException {
        con = getConnectionFromDB();
    }

    public void addTeacher(Teacher teacher) throws SQLException {
        String SQL = "INSERT INTO teacher (passport_number, first_name, last_name, patronymic, date_of_birth, sex, family_status, education, address, phone_number, specialization)\n" +
                "VALUES\n (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, teacher.getPassport_number());
        preparedStatement.setString(2, teacher.getFirst_name());
        preparedStatement.setString(3, teacher.getLast_name());
        preparedStatement.setString(4, teacher.getPatronymic());
        preparedStatement.setString(5, String.valueOf(teacher.getDate_of_birth()));
        preparedStatement.setString(6, teacher.getSex());
        preparedStatement.setString(7, teacher.getFamily_status());
        preparedStatement.setString(8, teacher.getEducation());
        preparedStatement.setString(9, teacher.getAddress());
        preparedStatement.setString(10, teacher.getPhone_number());
        preparedStatement.setString(11, teacher.getSpecialization());

        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public ResultSet getAllTeachers() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from teacher");
        statement.close();
        con.close();
        return resultSet;
    }

    public int getTeacherIdByPassportNumber(String passportNumber) throws SQLException {
        int id = 0;
        String SQL = "SELECT id FROM teacher WHERE passport_number = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, passportNumber);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        resultSet.close();
        return id != 0 ? id : null;
    }

    public void removeTeacherById(int id) throws SQLException {
        String SQL = "DELETE FROM teacher WHERE id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public void changeTeacher(Teacher teacher, int id) throws SQLException {
        String SQL = "UPDATE teacher " +
                "SET passport_number = ?, " +
                "first_name= ?, " +
                "last_name= ?, " +
                "patronymic= ?, " +
                "date_of_birth= ?, " +
                "sex= ?, " +
                "family_status= ?, " +
                "education= ?, " +
                "address= ?, " +
                "phone_number= ?, " +
                "specialization= ? " +
                "WHERE id = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, teacher.getPassport_number());
        preparedStatement.setString(2, teacher.getFirst_name());
        preparedStatement.setString(3, teacher.getLast_name());
        preparedStatement.setString(4, teacher.getPatronymic());
        preparedStatement.setString(5, teacher.getDate_of_birth());
        preparedStatement.setString(6, teacher.getSex());
        preparedStatement.setString(7, teacher.getFamily_status());
        preparedStatement.setString(8, teacher.getEducation());
        preparedStatement.setString(9, teacher.getAddress());
        preparedStatement.setString(10, teacher.getPhone_number());
        preparedStatement.setString(11, teacher.getSpecialization());
        preparedStatement.setInt(12, id);

        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public int getTeacherIdByFullName(String firstName, String lastName, String patronymic) throws SQLException {
        int id = 0;
        String SQL = "SELECT id FROM teacher WHERE first_name = ? AND last_name = ? AND patronymic = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, patronymic);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        resultSet.close();
        return id != 0 ? id : null;
    }

    public ResultSet getAllFullNamesTeachers() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select first_name, last_name, patronymic from teacher");
        statement.close();
        con.close();
        return resultSet;
    }
}
