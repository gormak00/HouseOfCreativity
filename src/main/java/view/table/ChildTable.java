package view.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import model.Child;
@Getter
public class ChildTable {
    private TableView<Child> table;
    private TableColumn<Child, String> firstNameColumn, lastNameColumn, patronymicColumn,
            ageColumn, numberOfSchoolColumn, schoolClassColumn, numberOfBirthCertificateColumn,
            dateOfBirthCertificateColumn, addressColumn, phoneNumberColumn, fullNameDadColumn,
            phoneNumberDadColumn, fullNameMumColumn, phoneNumberMumColumn;

    public ChildTable() {
        ObservableList<Child> people = FXCollections.observableArrayList(

                /*new Child("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30"),
                new Child("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30"),
                new Child("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30")
*/
        );
        table = new TableView<Child>(people);
        table.setPrefWidth(800);
        table.setPrefHeight(500);
        table.setLayoutX(0.0);
        table.setLayoutY(0.0);
        //action();

        createColumn(firstNameColumn, "Имя", "first_name");
        createColumn(lastNameColumn, "Фамилия", "last_name");
        createColumn(patronymicColumn, "Отчество", "patronymic");
        createColumn(ageColumn, "Возраст", "age");
        createColumn(numberOfSchoolColumn, "Номер школы", "number_of_school");
        createColumn(schoolClassColumn, "Номер класса", "school_class");
        createColumn(numberOfBirthCertificateColumn, "Номер свидетельства о рождении", "number_of_birth_certificate");
        createColumn(dateOfBirthCertificateColumn, "Дата выдачи свидетельства о рождении", "date_of_birth_certificate");
        createColumn(addressColumn, "Адрес", "address");
        createColumn(phoneNumberColumn, "Номер телефона", "phone_number");
        createColumn(fullNameDadColumn, "ФИО отца", "full_name_dad");
        createColumn(phoneNumberDadColumn, "Номер телефона отца", "phone_number_dad");
        createColumn(fullNameMumColumn, "ФИО матери", "full_name_mum");
        createColumn(phoneNumberMumColumn, "Номер телефона матери", "phone_number_mum");
    }

    private void createColumn(TableColumn<Child, String> columnName, String columnText, String objectText) {
        columnName = new TableColumn<>(columnText);
        columnName.setCellValueFactory(new PropertyValueFactory<>(objectText));
        table.getColumns().add(columnName);
    }

}
