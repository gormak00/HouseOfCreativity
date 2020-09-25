package view.childStatusPane;

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

@Getter
public class ReplaceChildFromGroupPane {
    private Pane replacePane;
    private ComboBox childNameBox, newGroupBox, oldGroupBox;
    private Label childNameLabel, todayDateLabel, newGroupLabel, oldGroupLabel;
    private TextField todayDateField;
    private Button replaceButton;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);

    public ReplaceChildFromGroupPane(){
        replacePane = new Pane();
        createAllComboBoxes();
        createAllLabels();
        createAllTextFields();
        createReplaceButton();
    }

    private void createAllComboBoxes() {
        ObservableList<String> nameList = FXCollections.observableArrayList(
                "Мужской",
                "Женский");
        childNameBox = new ComboBox<String>(nameList);
        childNameBox.setValue("Не выбрано");
        setComboBoxLayout(replacePane, childNameBox, 10.0, 30.0);

        ObservableList<String> freeGroupsList = FXCollections.observableArrayList(
                "Мужской",
                "Женский");
        newGroupBox = new ComboBox<String>(freeGroupsList);
        newGroupBox.setValue("Не выбрано");
        setComboBoxLayout(replacePane, newGroupBox, 10.0, 130.0);

        ObservableList<String> childInGroupsList = FXCollections.observableArrayList(
                "Мужской",
                "Женский");
        oldGroupBox = new ComboBox<String>(childInGroupsList);
        oldGroupBox.setValue("Не выбрано");
        setComboBoxLayout(replacePane, oldGroupBox, 10.0, 180.0);
    }

    private void setComboBoxLayout(Pane paneName, ComboBox comboBoxName, Double layoutX, Double layoutY) {
        comboBoxName.setLayoutX(layoutX);
        comboBoxName.setLayoutY(layoutY);
        paneName.getChildren().add(comboBoxName);
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

    private void createAllLabels() {
        childNameLabel = new Label("Выберите имя ребенка");
        setLabelLayoutAndFont(replacePane, childNameLabel, 10.0, 10.0, mainFont);

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
            /*Teacher selectedItem = teacherTable.getTable().getSelectionModel().getSelectedItem();
            teacherTable.getTable().getItems().remove(selectedItem);*/
        });
    }

    private void setButtonLayoutAndFont(Pane paneName, Button buttonName, double layoutX, double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }
}
