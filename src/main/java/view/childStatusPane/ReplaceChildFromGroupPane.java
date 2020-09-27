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
public class ReplaceChildFromGroupPane {
    private Pane replacePane;
    private ComboBox childNameBox, newGroupBox, oldGroupBox;
    private Label childNameLabel, todayDateLabel, newGroupLabel, oldGroupLabel;
    private TextField todayDateField;
    private Button replaceButton, childButton;
    private ChildStatusController childStatusController;
    private ChildController childController;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);

    public ReplaceChildFromGroupPane() throws IOException, SQLException {
        replacePane = new Pane();
        createChildNameBox();
        createChildButton();
        createChildLabel();
    }

    private void createChildNameBox() throws IOException, SQLException {
        childController = new ChildController();
        childStatusController = new ChildStatusController();
        ObservableList<String> nameList = FXCollections.observableArrayList(childController.getAllChildrenFullNames());
        childNameBox = new ComboBox<String>(nameList);
        childNameBox.setValue("Не выбрано");
        setComboBoxLayout(replacePane, childNameBox, 10.0, 30.0);
    }

    private void createGroupsComboBoxes() throws IOException, SQLException {
        ObservableList<Integer> freeGroupsList = FXCollections.observableArrayList(childStatusController.getFreeGroupsByChild(childNameBox.getValue().toString()));
        newGroupBox = new ComboBox<Integer>(freeGroupsList);
        newGroupBox.setValue("Не выбрано");
        setComboBoxLayout(replacePane, newGroupBox, 10.0, 130.0);

        ObservableList<Integer> childInGroupsList = FXCollections.observableArrayList(childStatusController.createChildGroupsList(childNameBox.getValue().toString()));
        oldGroupBox = new ComboBox<Integer>(childInGroupsList);
        oldGroupBox.setValue("Не выбрано");
        setComboBoxLayout(replacePane, oldGroupBox, 10.0, 180.0);
    }

    private void setComboBoxLayout(Pane paneName, ComboBox comboBoxName, Double layoutX, Double layoutY) {
        comboBoxName.setLayoutX(layoutX);
        comboBoxName.setLayoutY(layoutY);
        paneName.getChildren().add(comboBoxName);
    }

    private void createChildButton() {
        childButton = new Button("Выбрать ребенка");
        setButtonLayoutAndFont(replacePane, childButton, 270.0, 30.0);
        actionChildButton();
    }

    private void actionChildButton() {
        childButton.setOnAction(event -> {
            try {
                createGroupsComboBoxes();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            createAllLabels();
            createAllTextFields();
            createReplaceButton();
        });
    }

    private void createAllTextFields() {
        todayDateField = new TextField();
        setTextFieldLayoutAndFont(replacePane, todayDateField, 10.0, 80.0, mainFont);
    }

    private void setTextFieldLayoutAndFont(Pane paneName, TextField textFieldName, Double layoutX, Double layoutY, Font font) {
        textFieldName.setFont(font);
        textFieldName.setLayoutX(layoutX);
        textFieldName.setLayoutY(layoutY);
        paneName.getChildren().add(textFieldName);
    }

    private void createChildLabel(){
        childNameLabel = new Label("Выберите имя ребенка");
        setLabelLayoutAndFont(replacePane, childNameLabel, 10.0, 10.0, mainFont);
    }

    private void createAllLabels() {
        todayDateLabel = new Label("Укажите сегодняшнюю дату");
        setLabelLayoutAndFont(replacePane, todayDateLabel, 10.0, 60.0, mainFont);

        newGroupLabel = new Label("Выберите новую группу");
        setLabelLayoutAndFont(replacePane, newGroupLabel, 10.0, 110.0, mainFont);

        oldGroupLabel = new Label("Выберите группу из которой хотите перевестись");
        setLabelLayoutAndFont(replacePane, oldGroupLabel, 10.0, 160.0, mainFont);
    }

    private void setLabelLayoutAndFont(Pane paneName, Label labelName, Double layoutX, Double layoutY, Font font) {
        labelName.setFont(font);
        labelName.setLayoutX(layoutX);
        labelName.setLayoutY(layoutY);
        paneName.getChildren().add(labelName);
    }

    private void createReplaceButton() {
        replaceButton = new Button("Переместить ребенка");
        setButtonLayoutAndFont(replacePane, replaceButton, 250.0, 120.0);
        actionReplaceButton();
    }

    private void actionReplaceButton() {
        replaceButton.setOnAction(event -> {
            ChildStatusController childStatusController = new ChildStatusController();
            try {
                childStatusController.replaceChild(createChildStatusDto());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private ChildStatusDto createChildStatusDto(){
        ChildStatusDto childStatusDto = new ChildStatusDto();
        childStatusDto.setChildName(childNameBox.getValue().toString());
        childStatusDto.setTodayDate(todayDateField.getText());
        childStatusDto.setNewGroupNumber(Integer.parseInt(newGroupBox.getValue().toString()));
        childStatusDto.setOldGroupNumber(Integer.parseInt(oldGroupBox.getValue().toString()));
        return childStatusDto;
    }

    private void setButtonLayoutAndFont(Pane paneName, Button buttonName, double layoutX, double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }
}
