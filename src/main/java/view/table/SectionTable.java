package view.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import model.Section;

@Getter
public class SectionTable {
    private TableView<Section> table;
    private TableColumn<Section, String> numberColumn, nameColumn;

    public SectionTable() {
        ObservableList<Section> people = FXCollections.observableArrayList(

                /*new Child("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30"),
                new Child("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30"),
                new Child("П5", "Крюков", "30", "Киев", "П5", "Крюков", "30", "Киев", "П5", "Крюков", "30")
*/
        );
        table = new TableView<Section>(people);
        table.setPrefWidth(800);
        table.setPrefHeight(500);
        table.setLayoutX(0.0);
        table.setLayoutY(0.0);
        //action();

        createColumn(numberColumn, "Номер секции", "number");
        createColumn(nameColumn, "Название секции", "name");
        //createColumn(lastNameColumn, "ФИО преподавателя", "teacher_id");
    }

    private void createColumn(TableColumn<Section, String> columnName, String columnText, String objectText) {
        columnName = new TableColumn<>(columnText);
        columnName.setCellValueFactory(new PropertyValueFactory<>(objectText));
        table.getColumns().add(columnName);
    }

}
