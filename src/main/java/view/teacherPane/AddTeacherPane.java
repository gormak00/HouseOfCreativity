package view.teacherPane;

import controller.TeacherController;
import controller.dto.TeacherDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.sql.SQLException;

@Getter
public class AddTeacherPane {
    private Pane addPane;
    private Label passportNumberLabel, firstNameLabel, lastNameLabel, patronymicLabel, dateOfBirthLabel, sexLabel, familyStatusLabel, educationLabel, addressLabel, phoneNumberLabel, specializationLabel;
    private TextField passportNumberField, firstNameField, lastNameField, patronymicField, dateOfBirthField, addressField, phoneNumberField, specializationField;
    private ComboBox sexComboBox, familyStatusComboBox, educationComboBox;
    private Button addButton, changeButton;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);

    public AddTeacherPane() {
        addPane = new Pane();
        createAllLabels();
        createAllTextFields();
        createAllComboBoxes();
        createAddButton();
    }

    public AddTeacherPane(boolean change) {
        addPane = new Pane();
        createAllLabels();
        createAllTextFields();
        createAllComboBoxes();
        createChangeButton();

        Scene changeScene = new Scene(addPane, 800, 750);
        Stage changeStage = new Stage();
        changeStage.setTitle("Окно изменения");
        changeStage.setScene(changeScene);
        changeStage.setResizable(false);
        changeStage.show();
    }

    private void createAddButton() {
        addButton = new Button("Добавить преподавателя");
        setButtonLayoutAndFont(addPane, addButton, 250.0, 550.0);
        actionAddButton();
    }

    private void createChangeButton() {
        changeButton = new Button("Изменить преподавателя");
        setButtonLayoutAndFont(addPane, changeButton, 250.0, 550.0);
        actionChangeButton();
    }

    private void actionAddButton() {
        addButton.setOnAction(event -> {
            TeacherController teacherController = new TeacherController();
            try {
                teacherController.addTeacher(createTeacherDto());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private TeacherDto createTeacherDto(){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setPassportNumber(passportNumberField.getText());
        teacherDto.setFirstName(firstNameField.getText());
        teacherDto.setLastName(lastNameField.getText());
        teacherDto.setPatronymic(patronymicField.getText());
        teacherDto.setDateOfBirth(dateOfBirthField.getText());
        teacherDto.setSex(sexComboBox.getEditor().getText());
        teacherDto.setFamilyStatus(familyStatusComboBox.getEditor().getText());
        teacherDto.setEducation(educationComboBox.getEditor().getText());
        teacherDto.setAddress(addressField.getText());
        teacherDto.setPhoneNumber(phoneNumberField.getText());
        teacherDto.setSpecialization(specializationField.getText());
        return teacherDto;
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

    private void createAllComboBoxes() {
        ObservableList<String> sexList = FXCollections.observableArrayList(
                "Мужской",
                "Женский");
        sexComboBox = new ComboBox<String>(sexList);
        sexComboBox.setValue("Не выбрано");
        setComboBoxLayout(addPane, sexComboBox, 10.0, 280.0);

        ObservableList<String> familyStatusList = FXCollections.observableArrayList(
                "Женат/замужем",
                "Холост");
        familyStatusComboBox = new ComboBox<String>(familyStatusList);
        familyStatusComboBox.setValue("Не выбрано");
        setComboBoxLayout(addPane, familyStatusComboBox, 10.0, 330.0);

        ObservableList<String> educationList = FXCollections.observableArrayList(
                "Общее базовое",
                "Общее среднее",
                "Профессионально-техническое/среднее специальное",
                "Высшее профессиональное");
        educationComboBox = new ComboBox<String>(educationList);
        educationComboBox.setValue("Не выбрано");
        setComboBoxLayout(addPane, educationComboBox, 10.0, 380.0);
    }

    private void setComboBoxLayout(Pane paneName, ComboBox comboBoxName, Double layoutX, Double layoutY) {
        comboBoxName.setLayoutX(layoutX);
        comboBoxName.setLayoutY(layoutY);
        paneName.getChildren().add(comboBoxName);
    }

    private void createAllTextFields() {
        passportNumberField = new TextField();
        setTextFieldLayoutAndFont(addPane, passportNumberField, 10.0, 30.0, mainFont);

        firstNameField = new TextField();
        setTextFieldLayoutAndFont(addPane, firstNameField, 10.0, 80.0, mainFont);

        lastNameField = new TextField();
        setTextFieldLayoutAndFont(addPane, lastNameField, 10.0, 130.0, mainFont);

        patronymicField = new TextField();
        setTextFieldLayoutAndFont(addPane, patronymicField, 10.0, 180.0, mainFont);

        dateOfBirthField = new TextField("ДД.ММ.ГГГГ");
        setTextFieldLayoutAndFont(addPane, dateOfBirthField, 10.0, 230.0, mainFont);

        addressField = new TextField();
        setTextFieldLayoutAndFont(addPane, addressField, 10.0, 430.0, mainFont);

        phoneNumberField = new TextField("+375(..)...");
        setTextFieldLayoutAndFont(addPane, phoneNumberField, 10.0, 480.0, mainFont);

        specializationField = new TextField();
        setTextFieldLayoutAndFont(addPane, specializationField, 10.0, 530.0, mainFont);
    }

    private void setTextFieldLayoutAndFont(Pane paneName, TextField textFieldName, Double layoutX, Double layoutY, Font font) {
        textFieldName.setFont(font);
        textFieldName.setLayoutX(layoutX);
        textFieldName.setLayoutY(layoutY);
        paneName.getChildren().add(textFieldName);
    }

    private void createAllLabels() {
        passportNumberLabel = new Label("Введите паспортные данные");
        setLabelLayoutAndFont(addPane, passportNumberLabel, 10.0, 10.0, mainFont);

        firstNameLabel = new Label("Введите имя");
        setLabelLayoutAndFont(addPane, firstNameLabel, 10.0, 60.0, mainFont);

        lastNameLabel = new Label("Введите фамилию");
        setLabelLayoutAndFont(addPane, lastNameLabel, 10.0, 110.0, mainFont);

        patronymicLabel = new Label("Введите отчество");
        setLabelLayoutAndFont(addPane, patronymicLabel, 10.0, 160.0, mainFont);

        dateOfBirthLabel = new Label("Введите дату рождения");
        setLabelLayoutAndFont(addPane, dateOfBirthLabel, 10.0, 210.0, mainFont);

        sexLabel = new Label("Укажите пол");
        setLabelLayoutAndFont(addPane, sexLabel, 10.0, 260.0, mainFont);

        familyStatusLabel = new Label("Укажите семейный статус");
        setLabelLayoutAndFont(addPane, familyStatusLabel, 10.0, 310.0, mainFont);

        educationLabel = new Label("Укажите образование");
        setLabelLayoutAndFont(addPane, educationLabel, 10.0, 360.0, mainFont);

        addressLabel = new Label("Введите адрес");
        setLabelLayoutAndFont(addPane, addressLabel, 10.0, 410.0, mainFont);

        phoneNumberLabel = new Label("Введите номер телефона");
        setLabelLayoutAndFont(addPane, phoneNumberLabel, 10.0, 460.0, mainFont);

        specializationLabel = new Label("Введите специализацию");
        setLabelLayoutAndFont(addPane, specializationLabel, 10.0, 510.0, mainFont);
    }

    private void setLabelLayoutAndFont(Pane paneName, Label labelName, Double layoutX, Double layoutY, Font font) {
        labelName.setFont(font);
        labelName.setLayoutX(layoutX);
        labelName.setLayoutY(layoutY);
        paneName.getChildren().add(labelName);
    }
}
