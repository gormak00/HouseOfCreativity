package view.groupPane;

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
public class AddGroupPane {
    private Pane addPane;
    private ComboBox sectionNumberBox;
    private Label numberLabel, nameLabel, sectionNumberLabel;
    private TextField numberTextField, nameTextField;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);
    private Button addButton;

    public AddGroupPane(){
        addPane = new Pane();
        createAllLabels();
        createAllComboBoxes();
        createAllTextFields();
        createAddButton();
    }

    private void createAllComboBoxes() {
        ObservableList<String> sectionNumberList = FXCollections.observableArrayList(
                "Мужской",
                "Женский");
        sectionNumberBox = new ComboBox<String>(sectionNumberList);
        sectionNumberBox.setValue("Не выбрано");
        setComboBoxLayout(addPane, sectionNumberBox, 10.0, 130.0);
    }

    private void setComboBoxLayout(Pane paneName, ComboBox comboBoxName, Double layoutX, Double layoutY) {
        comboBoxName.setLayoutX(layoutX);
        comboBoxName.setLayoutY(layoutY);
        paneName.getChildren().add(comboBoxName);
    }

    private void createAddButton(){
        addButton = new Button("Добавить группу");
        setButtonLayoutAndFont(addPane, addButton, 250.0, 110.0);
        actionAddButton();
    }

    private void actionAddButton(){
        addButton.setOnAction(event -> {

        });
    }

    private void setButtonLayoutAndFont(Pane paneName, Button buttonName, Double layoutX, Double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }

    private void createAllTextFields() {
        numberTextField = new TextField();
        setTextFieldLayoutAndFont(addPane, numberTextField, 10.0, 30.0, mainFont);

        nameTextField = new TextField();
        setTextFieldLayoutAndFont(addPane, nameTextField, 10.0, 80.0, mainFont);
    }

    private void setTextFieldLayoutAndFont(Pane paneName, TextField textFieldName, Double layoutX, Double layoutY, Font font) {
        textFieldName.setFont(font);
        textFieldName.setLayoutX(layoutX);
        textFieldName.setLayoutY(layoutY);
        paneName.getChildren().add(textFieldName);
    }

    private void createAllLabels(){
        numberLabel = new Label("Введите номер группы");
        setLabelLayoutAndFont(addPane, numberLabel, 10.0, 10.0, mainFont);

        nameLabel = new Label("Введите название группы");
        setLabelLayoutAndFont(addPane, nameLabel, 10.0, 60.0, mainFont);

        sectionNumberLabel = new Label("Выберите номер секции");
        setLabelLayoutAndFont(addPane, sectionNumberLabel, 10.0, 110.0, mainFont);
    }

    private void setLabelLayoutAndFont(Pane paneName, Label labelName, Double layoutX, Double layoutY, Font font) {
        labelName.setFont(font);
        labelName.setLayoutX(layoutX);
        labelName.setLayoutY(layoutY);
        paneName.getChildren().add(labelName);
    }
}
