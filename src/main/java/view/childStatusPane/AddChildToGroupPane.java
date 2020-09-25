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
public class AddChildToGroupPane {
    private ChildController childController;
    private ChildStatusController childStatusController;
    private Pane addToGroupPane;
    private ComboBox childNameBox, newGroupBox;
    private Label childNameLabel, todayDateLabel, newGroupLabel;
    private TextField todayDateField;
    private Button addToGroupButton, childButton;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);

    public AddChildToGroupPane() throws IOException, SQLException {
        addToGroupPane = new Pane();
        createChildButton();
        createChildNameBox();
        createChildNameLabel();
    }

    private void createChildNameBox() throws IOException, SQLException {
        childController = new ChildController();
        childStatusController = new ChildStatusController();
        ObservableList<String> nameList = FXCollections.observableArrayList(childController.getAllChildrenFullNames());
        childNameBox = new ComboBox<String>(nameList);
        childNameBox.setValue("Не выбрано");
        setComboBoxLayout(addToGroupPane, childNameBox, 10.0, 30.0);
    }

    private void createNewGroupBox() throws IOException, SQLException {
        ObservableList<Integer> freeGroupsList = FXCollections.observableArrayList(childStatusController.getFreeGroupsByChild(childNameBox.getValue().toString()));
        newGroupBox = new ComboBox<Integer>(freeGroupsList);
        newGroupBox.setValue("Не выбрано");
        setComboBoxLayout(addToGroupPane, newGroupBox, 10.0, 130.0);
    }

        private void setComboBoxLayout(Pane paneName, ComboBox comboBoxName, Double layoutX, Double layoutY) {
        comboBoxName.setLayoutX(layoutX);
        comboBoxName.setLayoutY(layoutY);
        paneName.getChildren().add(comboBoxName);
    }

    private void createAllTextFields() {
        todayDateField = new TextField();
        setTextFieldLayoutAndFont(addToGroupPane, todayDateField, 10.0, 80.0, mainFont);
    }

    private void setTextFieldLayoutAndFont(Pane paneName, TextField textFieldName, Double layoutX, Double layoutY, Font font) {
        textFieldName.setFont(font);
        textFieldName.setLayoutX(layoutX);
        textFieldName.setLayoutY(layoutY);
        paneName.getChildren().add(textFieldName);
    }

    private void createChildNameLabel() {
        childNameLabel = new Label("Выберите имя ребенка");
        setLabelLayoutAndFont(addToGroupPane, childNameLabel, 10.0, 10.0, mainFont);
    }

    private void createAllLabels() {
        todayDateLabel = new Label("Укажите сегодняшнюю дату");
        setLabelLayoutAndFont(addToGroupPane, todayDateLabel, 10.0, 60.0, mainFont);

        newGroupLabel = new Label("Выберите новую группу");
        setLabelLayoutAndFont(addToGroupPane, newGroupLabel, 10.0, 110.0, mainFont);
    }

    private void setLabelLayoutAndFont(Pane paneName, Label labelName, Double layoutX, Double layoutY, Font font) {
        labelName.setFont(font);
        labelName.setLayoutX(layoutX);
        labelName.setLayoutY(layoutY);
        paneName.getChildren().add(labelName);
    }

    private void createReplaceButton() {
        addToGroupButton = new Button("Добавить в группу ребенка");
        setButtonLayoutAndFont(addToGroupPane, addToGroupButton, 210.0, 120.0);
        actionReplaceButton();
    }

    private void actionReplaceButton() {
        addToGroupButton.setOnAction(event -> {
            childStatusController = new ChildStatusController();
            try {
                childStatusController.addChildStatus(createChildStatusDto());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

        });
    }

    private ChildStatusDto createChildStatusDto(){
        ChildStatusDto childStatusDto = new ChildStatusDto();
        childStatusDto.setChildName(childNameBox.getValue().toString());
        childStatusDto.setNewGroupNumber(Integer.parseInt(newGroupBox.getValue().toString()));
        childStatusDto.setTodayDate(todayDateField.getText());
        return childStatusDto;
    }

    private void createChildButton() {
        childButton = new Button("Выбрать ребенка");
        setButtonLayoutAndFont(addToGroupPane, childButton, 270.0, 30.0);
        actionChildButton();
    }

    private void actionChildButton() {
        childButton.setOnAction(event -> {
            createReplaceButton();
            createAllLabels();
            createAllTextFields();
            try {
                createNewGroupBox();
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
