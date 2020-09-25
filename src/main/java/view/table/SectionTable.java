package view.table;

import controller.SectionController;
import controller.dto.SectionDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import model.Section;

import java.io.IOException;
import java.sql.SQLException;

@Getter
public class SectionTable {
    private TableView<SectionDto> table;
    private TableColumn<SectionDto, String> numberColumn, nameColumn, fullNameColumn;
    private SectionController sectionController;

    public SectionTable() throws IOException, SQLException {
        sectionController = new SectionController();
        ObservableList<SectionDto> sectionDto = FXCollections.observableArrayList(sectionController.getAllSection());
        table = new TableView<SectionDto>(sectionDto);
        table.setPrefWidth(800);
        table.setPrefHeight(500);
        table.setLayoutX(0.0);
        table.setLayoutY(0.0);
        //action();

        createColumn(numberColumn, "Номер секции", "number");
        createColumn(nameColumn, "Название секции", "name");
        createColumn(fullNameColumn, "ФИО преподавателя", "fullNameTeacher");
    }

    private void createColumn(TableColumn<SectionDto, String> columnName, String columnText, String objectText) {
        columnName = new TableColumn<>(columnText);
        columnName.setCellValueFactory(new PropertyValueFactory<>(objectText));
        table.getColumns().add(columnName);
    }

}
