package repository;

import model.Teacher;

import java.io.IOException;
import java.sql.*;

public class TeacherRepository extends ConnectionToDB {
    private Connection con;
    private Statement stmt;
    public TeacherRepository() throws IOException, SQLException {
        con = getConnectionFromDB();
        stmt = con.createStatement();
    }

    public void addTeacher(Teacher teacher) throws SQLException {
        String SQL = "INSERT INTO teacher (passport_number, first_name, last_name, patronymic, date_of_birth, sex, family_status, education, address, phone_number, specialization)\n" +
                "VALUES\n (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11);";
        PreparedStatement pstmt = con.prepareStatement(SQL);
        pstmt.setString(1, teacher.getPassport_number());
        pstmt.setString(2, teacher.getFirst_name());
        pstmt.setString(3, teacher.getLast_name());
        pstmt.setString(4, teacher.getPatronymic());
        pstmt.setString(5, teacher.getDate_of_birth());
        pstmt.setString(6, teacher.getSex());
        pstmt.setString(7, teacher.getFamily_status());
        pstmt.setString(8, teacher.getEducation());
        pstmt.setString(9, teacher.getAddress());
        pstmt.setString(10, teacher.getPhone_number());
        pstmt.setString(11, teacher.getSpecialization());

        pstmt.close();
        /*ResultSet rs = stmt.executeQuery("select * from teacher");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                    + rs.getString(3));
        }
        rs.close();
        stmt.close();*/
        con.close();
    }
}
