package view.sectionPane;

import controller.SectionController;
import controller.TeacherController;
import controller.dto.SectionDto;
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
public class AddSectionPane {
    private Pane addPane;
    private Label numberLabel, nameLabel, fullNameTeacherLabel;
    private TextField numberTextField, nameTextField;
    private ComboBox fullNameTeacherBox;
    private TeacherController teacherController;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);
    private Button addButton, changeButton;

    public AddSectionPane() throws IOException, SQLException {
        addPane = new Pane();
        createAllLabels();
        createAllTextFields();
        createAllComboBoxes();
        createAddButton();
    }

    public AddSectionPane(SectionDto oldSectionDto) throws IOException, SQLException {
        addPane = new Pane();
        createAllLabels();
        createAllTextFields();
        createAllComboBoxes();
        createChangeButton(oldSectionDto);
        insertSectionDtoIntoFields(oldSectionDto);

        Scene changeScene = new Scene(addPane, 800, 750);
        Stage changeStage = new Stage();
        changeStage.setTitle("Окно изменения");
        changeStage.setScene(changeScene);
        changeStage.setResizable(false);
        changeStage.show();
    }

    private void insertSectionDtoIntoFields(SectionDto sectionDto) {
        numberTextField.setText(String.valueOf(sectionDto.getNumber()));
        nameTextField.setText(sectionDto.getName());
        fullNameTeacherBox.setValue(sectionDto.getFullNameTeacher());
    }

    private void createAddButton() {
        addButton = new Button("Добавить секцию");
        setButtonLayoutAndFont(addPane, addButton, 260.0, 110.0);
        actionAddButton();
    }

    private void actionAddButton() {
        addButton.setOnAction(event -> {
            SectionController sectionController = new SectionController();
            try {
                sectionController.addSection(createSectionDto());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void createChangeButton(SectionDto oldSectionDto) {
        changeButton = new Button("Изменить секцию");
        setButtonLayoutAndFont(addPane, changeButton, 260.0, 110.0);
        actionChangeButton(oldSectionDto);
    }

    private void actionChangeButton(SectionDto oldSectionDto) {
        changeButton.setOnAction(event -> {
            SectionController sectionController = new SectionController();
            try {
                sectionController.changeSection(createSectionDto(), oldSectionDto);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void setButtonLayoutAndFont(Pane paneName, Button buttonName, Double layoutX, Double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }

    private SectionDto createSectionDto() throws IOException, SQLException {
        SectionDto sectionDto = new SectionDto();
        sectionDto.setName(nameTextField.getText());
        sectionDto.setNumber(Integer.parseInt(numberTextField.getText()));
        sectionDto.setFullNameTeacher(fullNameTeacherBox.getValue().toString());
        return sectionDto;
    }

    private void createAllComboBoxes() throws IOException, SQLException {
        teacherController = new TeacherController();
        ObservableList<String> sexList = FXCollections.observableArrayList(teacherController.getFullNamesList());
        fullNameTeacherBox = new ComboBox<String>(sexList);
        fullNameTeacherBox.setValue("Не выбрано");
        setComboBoxLayout(addPane, fullNameTeacherBox, 10.0, 130.0);
    }

    private void setComboBoxLayout(Pane paneName, ComboBox comboBoxName, Double layoutX, Double layoutY) {
        comboBoxName.setLayoutX(layoutX);
        comboBoxName.setLayoutY(layoutY);
        paneName.getChildren().add(comboBoxName);
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

    private void createAllLabels() {
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
