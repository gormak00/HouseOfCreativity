package view.table;

import controller.ChildController;
import controller.ExtraController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import model.Child;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

@Getter
public class ChildFromGroupByDateTable {
    private TableView<Child> table;
    private TableColumn<Child, String> firstNameColumn, lastNameColumn, patronymicColumn, ageColumn;
    private ChildController childController;
    private ExtraController extraController;

    public ChildFromGroupByDateTable(Date date, int groupNumber) throws IOException, SQLException, ParseException {
        childController = new ChildController();
        extraController = new ExtraController();

        ObservableList<Child> children = FXCollections.observableArrayList(extraController.createChildGroupByDateTable(date, groupNumber));
        table = new TableView<Child>(children);
        table.setPrefWidth(800);
        table.setPrefHeight(500);
        table.setLayoutX(0.0);
        table.setLayoutY(0.0);

        createColumn(firstNameColumn, "Имя", "first_name");
        createColumn(lastNameColumn, "Фамилия", "last_name");
        createColumn(patronymicColumn, "Отчество", "patronymic");
        createColumn(ageColumn, "Возраст", "age");
    }

    private void createColumn(TableColumn<Child, String> columnName, String columnText, String objectText) {
        columnName = new TableColumn<>(columnText);
        columnName.setCellValueFactory(new PropertyValueFactory<>(objectText));
        table.getColumns().add(columnName);
    }
}
