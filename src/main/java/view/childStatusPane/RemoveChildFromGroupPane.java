package view.childStatusPane;

import controller.ChildController;
import controller.ChildStatusController;
import controller.dto.ChildStatusDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;

import java.io.IOException;
import java.sql.SQLException;
@Getter
public class RemoveChildFromGroupPane {
    private ChildController childController;
    private ChildStatusController childStatusController;
    private Pane removeFromGroupPane;
    private ComboBox childNameBox, oldGroupBox;
    private Label childNameLabel, todayDateLabel, newGroupLabel;
    private TextField todayDateField;
    private Button removeFromGroupButton, childButton;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);

    public RemoveChildFromGroupPane() throws IOException, SQLException {
        removeFromGroupPane = new Pane();
        createChildButton();
        createChildNameBox();
        createChildNameLabel();
    }

    private void createChildNameBox() throws IOException, SQLException {
        childController = new ChildController();
        ObservableList<String> nameList = FXCollections.observableArrayList(childController.getAllChildrenFullNames());
        childNameBox = new ComboBox<String>(nameList);
        childNameBox.setValue("Не выбрано");
        setComboBoxLayout(removeFromGroupPane, childNameBox, 10.0, 30.0);
    }

    private void createOldGroupBox() throws IOException, SQLException {
        childStatusController = new ChildStatusController();
        ObservableList<Integer> freeGroupsList = FXCollections.observableArrayList(childStatusController.createChildGroupsList(childNameBox.getValue().toString()));
        oldGroupBox = new ComboBox<Integer>(freeGroupsList);
        oldGroupBox.setValue("Не выбрано");
        setComboBoxLayout(removeFromGroupPane, oldGroupBox, 10.0, 130.0);
    }

    private void setComboBoxLayout(Pane paneName, ComboBox comboBoxName, Double layoutX, Double layoutY) {
        comboBoxName.setLayoutX(layoutX);
        comboBoxName.setLayoutY(layoutY);
        paneName.getChildren().add(comboBoxName);
    }

    private void createAllTextFields() {
        todayDateField = new TextField();
        setTextFieldLayoutAndFont(removeFromGroupPane, todayDateField, 10.0, 80.0, mainFont);
    }

    private void setTextFieldLayoutAndFont(Pane paneName, TextField textFieldName, Double layoutX, Double layoutY, Font font) {
        textFieldName.setFont(font);
        textFieldName.setLayoutX(layoutX);
        textFieldName.setLayoutY(layoutY);
        paneName.getChildren().add(textFieldName);
    }

    private void createChildNameLabel() {
        childNameLabel = new Label("Выберите имя ребенка");
        setLabelLayoutAndFont(removeFromGroupPane, childNameLabel, 10.0, 10.0, mainFont);
    }

    private void createAllLabels() {
        todayDateLabel = new Label("Укажите сегодняшнюю дату");
        setLabelLayoutAndFont(removeFromGroupPane, todayDateLabel, 10.0, 60.0, mainFont);

        newGroupLabel = new Label("Выберите группу из которой хотите удалить");
        setLabelLayoutAndFont(removeFromGroupPane, newGroupLabel, 10.0, 110.0, mainFont);
    }

    private void setLabelLayoutAndFont(Pane paneName, Label labelName, Double layoutX, Double layoutY, Font font) {
        labelName.setFont(font);
        labelName.setLayoutX(layoutX);
        labelName.setLayoutY(layoutY);
        paneName.getChildren().add(labelName);
    }

    private void createRemoveFromGroupButton() {
        removeFromGroupButton = new Button("Удалить из группы ребенка");
        setButtonLayoutAndFont(removeFromGroupPane, removeFromGroupButton, 210.0, 130.0);
        actionRemoveFromGroupButton();
    }

    private void actionRemoveFromGroupButton() {
        removeFromGroupButton.setOnAction(event -> {
            childStatusController = new ChildStatusController();
            try {
                childStatusController.removeChildFromGroup(createChildStatusDto());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

        });
    }

    private ChildStatusDto createChildStatusDto(){
        ChildStatusDto childStatusDto = new ChildStatusDto();
        childStatusDto.setChildName(childNameBox.getValue().toString());
        childStatusDto.setOldGroupNumber(Integer.parseInt(oldGroupBox.getValue().toString()));
        childStatusDto.setTodayDate(todayDateField.getText());
        return childStatusDto;
    }

    private void createChildButton() {
        childButton = new Button("Выбрать ребенка");
        setButtonLayoutAndFont(removeFromGroupPane, childButton, 270.0, 30.0);
        actionChildButton();
    }

    private void actionChildButton() {
        childButton.setOnAction(event -> {
            createRemoveFromGroupButton();
            createAllLabels();
            createAllTextFields();
            try {
                createOldGroupBox();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void setButtonLayoutAndFont(Pane paneName, Button buttonName, double layoutX, double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }
}
