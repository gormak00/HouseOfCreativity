package view.sectionPane;

import controller.SectionController;
import controller.dto.SectionDto;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import view.table.SectionTable;

import java.io.IOException;
import java.sql.SQLException;

@Getter
public class RemoveSectionPane {
    private Pane removePane;
    private SectionTable sectionTable;
    private Button removeButton;

    public RemoveSectionPane() throws IOException, SQLException {
        removePane = new Pane();
        createTable();
        createRemoveButton();
    }

    private void createRemoveButton() {
        removeButton = new Button("Удалить секцию");
        setButtonLayoutAndFont(removePane, removeButton, 320.0, 550.0);
        action();
    }

    private void setButtonLayoutAndFont(Pane paneName, javafx.scene.control.Button buttonName, double layoutX, double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }

    private void action() {
        removeButton.setOnAction(event -> {
            SectionDto selectedItem = sectionTable.getTable().getSelectionModel().getSelectedItem();
            SectionController sectionController = new SectionController();
            try {
                sectionController.removeSection(selectedItem);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            sectionTable.getTable().getItems().remove(selectedItem);
        });
    }

    private void createTable() throws IOException, SQLException {
        sectionTable = new SectionTable();
        removePane.getChildren().add(sectionTable.getTable());
    }
}
