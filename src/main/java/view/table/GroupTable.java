package view.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import model.Groups;

@Getter
public class GroupTable {
    private TableView<Groups> table;
    private TableColumn<Groups, String> numberColumn, nameColumn, sectionNumberColumn;

    public GroupTable() {
        ObservableList<Groups> people = FXCollections.observableArrayList(

                /*new Child("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30"),
                new Child("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30"),
                new Child("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30")
*/
        );
        table = new TableView<Groups>(people);
        table.setPrefWidth(800);
        table.setPrefHeight(500);
        table.setLayoutX(0.0);
        table.setLayoutY(0.0);
        //action();

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
