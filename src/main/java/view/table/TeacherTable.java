package view.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import lombok.Getter;
import model.Teacher;

@Getter
public class TeacherTable {
    private TableView<Teacher> table;
    private TableColumn<Teacher, String> passportNumberColumn, firstNameColumn, lastNameColumn, patronymicColumn, dateOfBirthColumn, sexColumn, familyStatusColumn, educationColumn, addressColumn, phoneNumberColumn, specializationColumn;

    public TeacherTable() {
        ObservableList<Teacher> people = FXCollections.observableArrayList(

                new Teacher("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30"),
                new Teacher("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30"),
                new Teacher("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30")

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

    /*private void action(){
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn.setOnEditCommit(
                t -> ((Teacher) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setFirst_name(t.getNewValue())
        );

        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setOnEditCommit(
                t -> ((Teacher) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setLast_name(t.getNewValue())
        );

        patronymicColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        patronymicColumn.setOnEditCommit(
                t -> ((Teacher) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setPatronymic(t.getNewValue())
        );

        dateOfBirthColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateOfBirthColumn.setOnEditCommit(
                t -> ((Teacher) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setDate_of_birth(t.getNewValue())
        );

        sexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sexColumn.setOnEditCommit(
                t -> ((Teacher) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setSex(t.getNewValue())
        );

        familyStatusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        familyStatusColumn.setOnEditCommit(
                t -> ((Teacher) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setFamily_status(t.getNewValue())
        );

        educationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        educationColumn.setOnEditCommit(
                t -> ((Teacher) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setEducation(t.getNewValue())
        );

        addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        addressColumn.setOnEditCommit(
                t -> ((Teacher) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setAddress(t.getNewValue())
        );

        phoneNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumberColumn.setOnEditCommit(
                t -> ((Teacher) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setPhone_number(t.getNewValue())
        );

        specializationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        specializationColumn.setOnEditCommit(
                t -> ((Teacher) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setSpecialization(t.getNewValue())
        );
    }*/
}
