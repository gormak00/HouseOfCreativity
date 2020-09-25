package view.table;

import controller.GroupsController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import model.Groups;

import java.io.IOException;
import java.sql.SQLException;

@Getter
public class GroupTable {
    private TableView<Groups> table;
    private TableColumn<Groups, String> numberColumn, nameColumn, sectionNumberColumn;
    private GroupsController groupsController;

    public GroupTable() throws SQLException, IOException {
        groupsController = new GroupsController();
        ObservableList<Groups> people = FXCollections.observableArrayList(groupsController.getAllGroups());
        table = new TableView<Groups>(people);
        table.setPrefWidth(800);
        table.setPrefHeight(500);
        table.setLayoutX(0.0);
        table.setLayoutY(0.0);

        createColumn(numberColumn, "Номер группы", "number");
        createColumn(nameColumn, "Название группы", "name");
        createColumn(sectionNumberColumn, "Номер секции", "section_number");
    }

    private void createColumn(TableColumn<Groups, String> columnName, String columnText, String objectText) {
        columnName = new TableColumn<>(columnText);
        columnName.setCellValueFactory(new PropertyValueFactory<>(objectText));
        table.getColumns().add(columnName);
    }

}
