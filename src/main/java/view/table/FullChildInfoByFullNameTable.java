package view.table;

import controller.ExtraController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import model.Child;
import model.ChildStatus;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@Getter
public class FullChildInfoByFullNameTable {
    private TableView<Child> childTable;
    private TableView<ChildStatus> childStatusTable;
    private TableColumn<Child, String> firstNameColumn, lastNameColumn, patronymicColumn,
            ageColumn, numberOfSchoolColumn, schoolClassColumn, numberOfBirthCertificateColumn,
            dateOfBirthCertificateColumn, addressColumn, phoneNumberColumn, fullNameDadColumn,
            phoneNumberDadColumn, fullNameMumColumn, phoneNumberMumColumn;
    private TableColumn<ChildStatus, String> groupNumberColumn, startDateColumn, endDateColumn;
    private ExtraController extraController;

    public FullChildInfoByFullNameTable(String fullName) throws IOException, SQLException, ParseException {
        extraController = new ExtraController();
        extraController.createFullChildInfoByFullNameTable(fullName);
        ObservableList<Child> children = FXCollections.observableArrayList(extraController.getChildList());
        childTable = new TableView<Child>(children);
        childTable.setPrefWidth(800);
        childTable.setPrefHeight(100);
        childTable.setLayoutX(0.0);
        childTable.setLayoutY(140.0);

        createChildColumn(firstNameColumn, "Имя", "first_name");
        createChildColumn(lastNameColumn, "Фамилия", "last_name");
        createChildColumn(patronymicColumn, "Отчество", "patronymic");
        createChildColumn(ageColumn, "Возраст", "age");
        createChildColumn(numberOfSchoolColumn, "Номер школы", "number_of_school");
        createChildColumn(schoolClassColumn, "Номер класса", "school_class");
        createChildColumn(numberOfBirthCertificateColumn, "Номер свидетельства о рождении", "number_of_birth_certificate");
        createChildColumn(dateOfBirthCertificateColumn, "Дата выдачи свидетельства о рождении", "date_of_birth_certificate");
        createChildColumn(addressColumn, "Адрес", "address");
        createChildColumn(phoneNumberColumn, "Номер телефона", "phone_number");
        createChildColumn(fullNameDadColumn, "ФИО отца", "full_name_dad");
        createChildColumn(phoneNumberDadColumn, "Номер телефона отца", "phone_number_dad");
        createChildColumn(fullNameMumColumn, "ФИО матери", "full_name_mum");
        createChildColumn(phoneNumberMumColumn, "Номер телефона матери", "phone_number_mum");

        ObservableList<ChildStatus> childStatuses = FXCollections.observableArrayList(extraController.getChildStatusList());
        childStatusTable = new TableView<ChildStatus>(childStatuses);
        childStatusTable.setPrefWidth(800);
        childStatusTable.setPrefHeight(300);
        childStatusTable.setLayoutX(0.0);
        childStatusTable.setLayoutY(300.0);

        createChildStatusColumn(groupNumberColumn, "Номер группы", "group_number");
        createChildStatusColumn(startDateColumn, "Дата начала учебы", "start_date");
        createChildStatusColumn(endDateColumn, "Дата конца учебы", "end_date");
    }

    private void createChildColumn(TableColumn<Child, String> columnName, String columnText, String objectText) {
        columnName = new TableColumn<>(columnText);
        columnName.setCellValueFactory(new PropertyValueFactory<>(objectText));
        childTable.getColumns().add(columnName);
    }

    private void createChildStatusColumn(TableColumn<ChildStatus, String> columnName, String columnText, String objectText) {
        columnName = new TableColumn<>(columnText);
        columnName.setCellValueFactory(new PropertyValueFactory<>(objectText));
        childStatusTable.getColumns().add(columnName);
    }
}
