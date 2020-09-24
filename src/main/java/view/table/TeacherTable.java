package view.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import model.Teacher;

@Getter
public class TeacherTable {
    private TableView<Teacher> table;
    private TableColumn<Teacher, String> passportNumberColumn, firstNameColumn, lastNameColumn, patronymicColumn, dateOfBirthColumn, sexColumn, familyStatusColumn, educationColumn, addressColumn, phoneNumberColumn, specializationColumn;

    public TeacherTable() {
        ObservableList<Teacher> people = FXCollections.observableArrayList(

                /*new Teacher("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30"),
                new Teacher("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30"),
                new Teacher("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30")*/

        );
        table = new TableView<Teacher>(people);
        table.setPrefWidth(800);
        table.setPrefHeight(500);
        table.setLayoutX(0.0);
        table.setLayoutY(0.0);
        //action();

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
