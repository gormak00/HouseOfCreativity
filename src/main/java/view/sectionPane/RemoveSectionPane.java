package view.sectionPane;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import model.Section;
import view.table.SectionTable;
@Getter
public class RemoveSectionPane {
    private Pane removePane;
    private SectionTable sectionTable;
    private Button removeButton;

    public RemoveSectionPane() {
        removePane = new Pane();
        sectionTable = new SectionTable();
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
            Section selectedItem = sectionTable.getTable().getSelectionModel().getSelectedItem();
            sectionTable.getTable().getItems().remove(selectedItem);
        });
    }

    private void createTable() {
        removePane.getChildren().add(sectionTable.getTable());
    }
}
