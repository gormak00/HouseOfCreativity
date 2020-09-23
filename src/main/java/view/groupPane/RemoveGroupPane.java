package view.groupPane;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import model.Groups;
import view.table.GroupTable;

@Getter
public class RemoveGroupPane {
    private Pane removePane;
    private GroupTable groupTable;
    private Button removeButton;

    public RemoveGroupPane() {
        removePane = new Pane();
        groupTable = new GroupTable();
        createTable();
        createRemoveButton();
    }

    private void createRemoveButton() {
        removeButton = new Button("Удалить группу");
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
            Groups selectedItem = groupTable.getTable().getSelectionModel().getSelectedItem();
            groupTable.getTable().getItems().remove(selectedItem);
        });
    }

    private void createTable() {
        removePane.getChildren().add(groupTable.getTable());
    }
}
