package view.teacherPane;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import model.Teacher;
import view.table.TeacherTable;

@Getter
public class RemoveTeacherPane {
    private Pane removePane;
    private Button deleteButton;
    private TeacherTable teacherTable;

    public RemoveTeacherPane() {
        teacherTable = new TeacherTable();
        removePane = new Pane();
        createTableOfTeachers();
        createDeleteButton();
    }

    private void createDeleteButton() {
        deleteButton = new Button("Удалить выбранного преподавателя");
        setButtonLayoutAndFont(removePane, deleteButton, 250.0, 550.0);
        action();
    }

    private void action() {
        deleteButton.setOnAction(event -> {
            Teacher selectedItem = teacherTable.getTable().getSelectionModel().getSelectedItem();
            teacherTable.getTable().getItems().remove(selectedItem);
        });
    }

    private void setButtonLayoutAndFont(Pane paneName, Button buttonName, double layoutX, double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }

    private void createTableOfTeachers() {
        teacherTable.getTable().setEditable(false);
        removePane.getChildren().add(teacherTable.getTable());
    }
}
