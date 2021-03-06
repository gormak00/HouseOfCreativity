package view.teacherPane;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import model.Teacher;
import view.table.TeacherTable;

import java.io.IOException;
import java.sql.SQLException;

@Getter
public class ChangeTeacherPane {
    private Pane changePane;
    private Button changeButton;
    private TeacherTable teacherTable;
    private AddTeacherPane addTeacherPane;

    public ChangeTeacherPane() throws IOException, SQLException {
        teacherTable = new TeacherTable();
        changePane = new Pane();
        createTableOfTeachers();
        createChangeButton();
    }

    private void createChangeButton() {
        changeButton = new Button("Изменить выбранного преподавателя");
        setButtonLayoutAndFont(changePane, changeButton, 250.0, 550.0);
        action();
    }

    private void action() {
        changeButton.setOnAction(event -> {
            Teacher selectedTeacher = teacherTable.getTable().getSelectionModel().getSelectedItem();
            AddTeacherPane addTeacherPane = new AddTeacherPane(selectedTeacher);
        });
    }

    private void setButtonLayoutAndFont(Pane paneName, Button buttonName, double layoutX, double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }

    private void createTableOfTeachers() {
        changePane.getChildren().add(teacherTable.getTable());
    }
}
