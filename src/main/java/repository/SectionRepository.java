package repository;

import controller.dto.SectionDto;
import model.Section;

import java.io.IOException;
import java.sql.*;

public class SectionRepository extends ConnectionToDB {
    private Connection con;

    public SectionRepository() throws IOException, SQLException {
        con = getConnectionFromDB();
    }

    public void addSection(Section section) throws SQLException {
        String SQL = "INSERT INTO section (number, name, teacher_id)\n" +
                "VALUES\n (?, ?, ?);";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, section.getNumber());
        preparedStatement.setString(2, section.getName());
        preparedStatement.setInt(3, section.getTeacher_id());

        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public ResultSet getAllSection() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM section;");
        statement.close();
        con.close();
        return resultSet;
    }

    public ResultSet getAllSectionDto() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT section.name, section.number, teacher.first_name, teacher.last_name, teacher.patronymic FROM section, teacher WHERE section.teacher_id = teacher.id;");
        statement.close();
        con.close();
        return resultSet;
    }

    public void removeSectionByNumber(int number) throws SQLException {
        String SQL = "DELETE FROM section WHERE number = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, number);
        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public void changeSection(Section section, SectionDto oldSectionDto) throws SQLException {
        String SQL = "UPDATE section " +
                "SET number = ?, " +
                "name = ?, " +
                "teacher_id = ? " +
                "WHERE number = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, section.getNumber());
        preparedStatement.setString(2, section.getName());
        preparedStatement.setInt(3, section.getTeacher_id());
        preparedStatement.setInt(4, oldSectionDto.getNumber());

        preparedStatement.execute();
        preparedStatement.close();
        con.close();
    }

    public ResultSet getAllSectionNumbers() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT number FROM section;");
        statement.close();
        con.close();
        return resultSet;
    }
}
