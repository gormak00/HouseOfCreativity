package view.sectionPane;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import lombok.Getter;


@Getter
public class AddSectionPane {
    private Pane addPane;
    private Label numberLabel, nameLabel, fullNameTeacherLabel;
    private TextField numberTextField, nameTextField, fullNameTeacherTextField;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);
    private Button addButton, changeButton;

    public AddSectionPane(){
        addPane = new Pane();
        createAllLabels();
        createAllTextFields();
        createAddButton();
    }

    public AddSectionPane(boolean change){
        addPane = new Pane();
        createAllLabels();
        createAllTextFields();
        createChangeButton();

        Scene changeScene = new Scene(addPane, 800, 750);
        Stage changeStage = new Stage();
        changeStage.setTitle("Окно изменения");
        changeStage.setScene(changeScene);
        changeStage.setResizable(false);
        changeStage.show();
    }

    private void createAddButton(){
        addButton = new Button("Добавить секцию");
        setButtonLayoutAndFont(addPane, addButton, 250.0, 110.0);
        actionAddButton();
    }

    private void actionAddButton(){
        addButton.setOnAction(event -> {

        });
    }
    private void createChangeButton(){
        changeButton = new Button("Добавить секцию");
        setButtonLayoutAndFont(addPane, changeButton, 250.0, 110.0);
        actionChangeButton();
    }

    private void actionChangeButton(){
        changeButton.setOnAction(event -> {

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

        fullNameTeacherTextField = new TextField();
        setTextFieldLayoutAndFont(addPane, fullNameTeacherTextField, 10.0, 130.0, mainFont);
    }

    private void setTextFieldLayoutAndFont(Pane paneName, TextField textFieldName, Double layoutX, Double layoutY, Font font) {
        textFieldName.setFont(font);
        textFieldName.setLayoutX(layoutX);
        textFieldName.setLayoutY(layoutY);
        paneName.getChildren().add(textFieldName);
    }

    private void createAllLabels(){
        numberLabel = new Label("Введите номер секции");
            setLabelLayoutAndFont(addPane, numberLabel, 10.0, 10.0, mainFont);

        nameLabel = new Label("Введите название секции");
            setLabelLayoutAndFont(addPane, nameLabel, 10.0, 60.0, mainFont);

        fullNameTeacherLabel = new Label("Введите ФИО преподавателя");
            setLabelLayoutAndFont(addPane, fullNameTeacherLabel, 10.0, 110.0, mainFont);
    }

    private void setLabelLayoutAndFont(Pane paneName, Label labelName, Double layoutX, Double layoutY, Font font) {
        labelName.setFont(font);
        labelName.setLayoutX(layoutX);
        labelName.setLayoutY(layoutY);
        paneName.getChildren().add(labelName);
    }
}
