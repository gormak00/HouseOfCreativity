package view.extraPane;

import controller.GroupsController;
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
import model.Groups;
import view.table.ChildFromGroupByDateTable;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class ChildFromGroupByDatePane {
    private Pane pane;
    private Label dateLabel, groupLabel, sectionGroupDateLabel;
    private TextField dateField;
    private ComboBox allGroupsBox;
    private Button childButton;
    private GroupsController groupsController;
    private ChildFromGroupByDateTable childFromGroupByDateTable;
    private Date date;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");

    public ChildFromGroupByDatePane() throws IOException, SQLException {
        pane = new Pane();
        createDateField();
        createAllLabels();
        createAllGroupsBox();
        createChildButton();
    }

    private void createDateField() {
        dateField = new TextField("ДД.ММ.ГГГГ");
        setTextFieldLayoutAndFont(pane, dateField, 10.0, 30.0, mainFont);

    }

    private void setTextFieldLayoutAndFont(Pane paneName, TextField textFieldName, Double layoutX, Double layoutY, Font font) {
        textFieldName.setFont(font);
        textFieldName.setLayoutX(layoutX);
        textFieldName.setLayoutY(layoutY);
        paneName.getChildren().add(textFieldName);
    }

    private void createAllLabels() {
        dateLabel = new Label("Укажите дату");
        setLabelLayoutAndFont(pane, dateLabel, 10.0, 10.0, mainFont);

        groupLabel = new Label("Укажите группу");
        setLabelLayoutAndFont(pane, groupLabel, 10.0, 60.0, mainFont);
    }

    private void createSectionGroupDateLabel(String sectionName, String groupName, String date) {
        sectionGroupDateLabel = new Label("Результаты по секции: " + sectionName +
                ", группе: " + groupName + ", дата: " + date);
        setLabelLayoutAndFont(pane, sectionGroupDateLabel, 10.0, 155.0, mainFont);
    }

    private void setLabelLayoutAndFont(Pane paneName, Label labelName, Double layoutX, Double layoutY, Font font) {
        labelName.setFont(font);
        labelName.setLayoutX(layoutX);
        labelName.setLayoutY(layoutY);
        paneName.getChildren().add(labelName);
    }

    private void createAllGroupsBox() throws IOException, SQLException {
        groupsController = new GroupsController();
        ObservableList<Integer> freeGroupsList = FXCollections.observableArrayList();
        for (Groups currentGroup : groupsController.getAllGroups()) {
            freeGroupsList.add(currentGroup.getNumber());
        }
        allGroupsBox = new ComboBox<Integer>(freeGroupsList);
        allGroupsBox.setValue("Не выбрано");
        setComboBoxLayout(pane, allGroupsBox, 10.0, 80.0);
    }

    private void setComboBoxLayout(Pane paneName, ComboBox comboBoxName, Double layoutX, Double layoutY) {
        comboBoxName.setLayoutX(layoutX);
        comboBoxName.setLayoutY(layoutY);
        paneName.getChildren().add(comboBoxName);
    }

    private void createChildButton() {
        childButton = new Button("Показать детей");
        setButtonLayoutAndFont(pane, childButton, 10.0, 110.0);
        actionChildButton();
    }

    private void actionChildButton() {
        childButton.setOnAction(event -> {
            try {
                date = formatter.parse(dateField.getText());
                childFromGroupByDateTable = new ChildFromGroupByDateTable(date, Integer.parseInt(allGroupsBox.getValue().toString()));
            } catch (IOException | SQLException | ParseException e) {
                e.printStackTrace();
            }
            createSectionGroupDateLabel("ad", "wqer", "22/22/22");
            pane.getChildren().add(childFromGroupByDateTable.getTable());
        });
    }

    private void setButtonLayoutAndFont(Pane paneName, Button buttonName, double layoutX, double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }
}
