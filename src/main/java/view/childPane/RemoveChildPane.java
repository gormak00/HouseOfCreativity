package view.childPane;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import model.Child;
import view.table.ChildTable;


@Getter
public class RemoveChildPane {
    private Pane removePane;
    private ChildTable childTable;
    private Button removeButton;

    public RemoveChildPane() {
        removePane = new Pane();
        childTable = new ChildTable();
        createTable();
        createRemoveButton();
    }

    private void createRemoveButton(){
        removeButton = new Button("Удалить ребенка");
        setButtonLayoutAndFont(removePane, removeButton, 250.0, 550.0);
        action();
    }

    private void setButtonLayoutAndFont(Pane paneName, javafx.scene.control.Button buttonName, double layoutX, double layoutY){
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }

    private void action() {
        removeButton.setOnAction(event -> {
            Child selectedItem = childTable.getTable().getSelectionModel().getSelectedItem();
            childTable.getTable().getItems().remove(selectedItem);
        });
    }

    private void createTable() {
        removePane.getChildren().add(childTable.getTable());
    }
}
