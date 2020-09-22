package view.childPane;

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
public class AddChildPane {
    private Pane addPane;
    private Label firstNameLabel, lastNameLabel, patronymicLabel, ageLabel, numberOfSchoolLabel, schoolClassLabel, numberOfBirthCertificateLabel, dateOfBirthCertificateLabel, addressLabel, phoneNumberLabel, fullNameDadLabel, phoneNumberDadLabel, fullNameMumLabel, phoneNumberMumLabel;
    private TextField firstNameField, lastNameField, patronymicField, ageField, numberOfSchoolField, schoolClassField, numberOfBirthCertificateField, dateOfBirthCertificateField, addressField, phoneNumberField, fullNameDadField, phoneNumberDadField, fullNameMumField, phoneNumberMumField;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);
    private Button addButton, changeButton;

    public AddChildPane() {
        addPane = new Pane();
        createAllLabels();
        createAllTextFields();
        createAddButton();
    }

    public AddChildPane(boolean change) {
        addPane = new Pane();
        createAllLabels();
        createAllTextFields();

        Scene changeScene = new Scene(addPane, 800, 750);
        Stage changeStage = new Stage();
        changeStage.setTitle("Окно изменения");
        changeStage.setScene(changeScene);
        changeStage.setResizable(false);
        changeStage.show();
    }

    private void createAddButton(){
        addButton = new Button("Добавить ребенка");
        setButtonLayoutAndFont(addPane, addButton, 250,660);
        actionAddButton();
    }

    private void createChangeButton(){
        changeButton = new Button("Изменить ребенка");
        setButtonLayoutAndFont(addPane, addButton, 250,660);
        actionChangeButton();
    }

    private void actionAddButton() {
        addButton.setOnAction(event -> {
            /*Teacher selectedItem = teacherTable.getTable().getSelectionModel().getSelectedItem();
            teacherTable.getTable().getItems().remove(selectedItem);*/
        });
    }

    private void actionChangeButton() {
        changeButton.setOnAction(event -> {
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

    private void createAllTextFields() {
        firstNameField = new TextField();
        setTextFieldLayoutAndFont(addPane, firstNameField, 10.0, 30.0, mainFont);

        lastNameField = new TextField();
        setTextFieldLayoutAndFont(addPane, lastNameField, 10.0, 80.0, mainFont);

        patronymicField = new TextField();
        setTextFieldLayoutAndFont(addPane, patronymicField, 10.0, 130.0, mainFont);

        ageField = new TextField();
        setTextFieldLayoutAndFont(addPane, ageField, 10.0, 180.0, mainFont);

        numberOfSchoolField = new TextField();
        setTextFieldLayoutAndFont(addPane, numberOfSchoolField, 10.0, 230.0, mainFont);

        schoolClassField = new TextField();
        setTextFieldLayoutAndFont(addPane, schoolClassField, 10.0, 280.0, mainFont);

        numberOfBirthCertificateField = new TextField();
        setTextFieldLayoutAndFont(addPane, numberOfBirthCertificateField, 10.0, 330.0, mainFont);

        dateOfBirthCertificateField = new TextField();
        setTextFieldLayoutAndFont(addPane, dateOfBirthCertificateField, 10.0, 380.0, mainFont);

        addressField = new TextField();
        setTextFieldLayoutAndFont(addPane, addressField, 10.0, 430.0, mainFont);

        phoneNumberField = new TextField();
        setTextFieldLayoutAndFont(addPane, phoneNumberField, 10.0, 480.0, mainFont);

        fullNameDadField = new TextField();
        setTextFieldLayoutAndFont(addPane, fullNameDadField, 10.0, 530.0, mainFont);

        phoneNumberDadField = new TextField();
        setTextFieldLayoutAndFont(addPane, phoneNumberDadField, 10.0, 580.0, mainFont);

        fullNameMumField = new TextField();
        setTextFieldLayoutAndFont(addPane, fullNameMumField, 10.0, 630.0, mainFont);

        phoneNumberMumField = new TextField();
        setTextFieldLayoutAndFont(addPane, phoneNumberMumField, 10.0, 680.0, mainFont);
    }

    private void setTextFieldLayoutAndFont(Pane paneName, TextField textFieldName, Double layoutX, Double layoutY, Font font) {
        textFieldName.setFont(font);
        textFieldName.setLayoutX(layoutX);
        textFieldName.setLayoutY(layoutY);
        paneName.getChildren().add(textFieldName);
    }

    private void createAllLabels() {
        firstNameLabel = new Label("Введите имя");
        setLabelLayoutAndFont(addPane, firstNameLabel, 10.0, 10.0, mainFont);

        lastNameLabel = new Label("Введите фамилию");
        setLabelLayoutAndFont(addPane, lastNameLabel, 10.0, 60.0, mainFont);

        patronymicLabel = new Label("Введите отчество");
        setLabelLayoutAndFont(addPane, patronymicLabel, 10.0, 110.0, mainFont);

        ageLabel = new Label("Введите возраст");
        setLabelLayoutAndFont(addPane, ageLabel, 10.0, 160.0, mainFont);

        numberOfSchoolLabel = new Label("Введите номер школы");
        setLabelLayoutAndFont(addPane, numberOfSchoolLabel, 10.0, 210.0, mainFont);

        schoolClassLabel = new Label("Введите класс");
        setLabelLayoutAndFont(addPane, schoolClassLabel, 10.0, 260.0, mainFont);

        numberOfBirthCertificateLabel = new Label("Введите номер свидетельства о рождении");
        setLabelLayoutAndFont(addPane, numberOfBirthCertificateLabel, 10.0, 310.0, mainFont);

        dateOfBirthCertificateLabel = new Label("Введите дату выдачи свидетельства о рождении");
        setLabelLayoutAndFont(addPane, dateOfBirthCertificateLabel, 10.0, 360.0, mainFont);

        addressLabel = new Label("Введите адрес");
        setLabelLayoutAndFont(addPane, addressLabel, 10.0, 410.0, mainFont);

        phoneNumberLabel = new Label("Введите номер телефона");
        setLabelLayoutAndFont(addPane, phoneNumberLabel, 10.0, 460.0, mainFont);

        fullNameDadLabel = new Label("Введите ФИО отца");
        setLabelLayoutAndFont(addPane, fullNameDadLabel, 10.0, 510.0, mainFont);

        phoneNumberDadLabel = new Label("Введите номер телефона отца");
        setLabelLayoutAndFont(addPane, phoneNumberDadLabel, 10.0, 560.0, mainFont);

        fullNameMumLabel = new Label("Введите ФИО матери");
        setLabelLayoutAndFont(addPane, fullNameMumLabel, 10.0, 610.0, mainFont);

        phoneNumberMumLabel = new Label("Введите номер телефона матери");
        setLabelLayoutAndFont(addPane, phoneNumberMumLabel, 10.0, 660.0, mainFont);
    }

    private void setLabelLayoutAndFont(Pane paneName, Label labelName, Double layoutX, Double layoutY, Font font) {
        labelName.setFont(font);
        labelName.setLayoutX(layoutX);
        labelName.setLayoutY(layoutY);
        paneName.getChildren().add(labelName);
    }
}
