package view.table;

import controller.TeacherController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import model.Teacher;

import java.io.IOException;
import java.sql.SQLException;

@Getter
public class TeacherTable {
    private TableView<Teacher> table;
    private TableColumn<Teacher, String> passportNumberColumn, firstNameColumn, lastNameColumn, patronymicColumn, dateOfBirthColumn, sexColumn, familyStatusColumn, educationColumn, addressColumn, phoneNumberColumn, specializationColumn;
    private TeacherController teacherController;

    public TeacherTable() throws IOException, SQLException {
        teacherController = new TeacherController();
        ObservableList<Teacher> allTeachers = FXCollections.observableArrayList(teacherController.getAllTeachersList());

        table = new TableView<Teacher>(allTeachers);
        table.setPrefWidth(800);
        table.setPrefHeight(500);
        table.setLayoutX(0.0);
        table.setLayoutY(0.0);

        createColumn(passportNumberColumn, "Паспорт", "passport_number");
        createColumn(firstNameColumn, "Имя", "first_name");
        createColumn(lastNameColumn, "Фамилия", "last_name");
        createColumn(patronymicColumn, "Отчество", "patronymic");
        createColumn(dateOfBirthColumn, "Дата рождения", "date_of_birth");
        createColumn(sexColumn, "Пол", "sex");
        createColumn(familyStatusColumn, "Семейный статус", "family_status");
        createColumn(educationColumn, "Образование", "education");
        createColumn(addressColumn, "Адрес", "address");
        createColumn(phoneNumberColumn, "Номер телефона", "phone_number");
        createColumn(specializationColumn, "Специализация", "specialization");
    }

    private void createColumn(TableColumn<Teacher, String> columnName, String columnText, String objectText) {
        columnName = new TableColumn<>(columnText);
        columnName.setCellValueFactory(new PropertyValueFactory<>(objectText));
        table.getColumns().add(columnName);
    }
}
