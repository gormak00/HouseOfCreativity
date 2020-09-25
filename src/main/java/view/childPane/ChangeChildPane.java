package view.childPane;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import model.Child;
import view.table.ChildTable;

import java.io.IOException;
import java.sql.SQLException;

@Getter
public class ChangeChildPane {
    private Pane changePane;
    private ChildTable childTable;
    private Button changeButton;

    public ChangeChildPane() throws IOException, SQLException {
        changePane = new Pane();
        createTable();
        createChangeButton();
    }

    private void createChangeButton(){
        changeButton = new Button("Изменить выбранного ребенка");
        setButtonLayoutAndFont(changePane, changeButton, 250.0, 550.0);
        action();
    }

    private void setButtonLayoutAndFont(Pane paneName, javafx.scene.control.Button buttonName, double layoutX, double layoutY){
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }

    private void action() {
        changeButton.setOnAction(event -> {
            Child selectedItem = childTable.getTable().getSelectionModel().getSelectedItem();
            AddChildPane addChildPane = new AddChildPane(selectedItem);
        });
    }

    private void createTable() throws IOException, SQLException {
        childTable = new ChildTable();
        changePane.getChildren().add(childTable.getTable());
    }
}
