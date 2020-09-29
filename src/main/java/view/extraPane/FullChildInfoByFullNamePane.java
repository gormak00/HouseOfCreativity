package view.extraPane;

import controller.ChildController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import view.table.FullChildInfoByFullNameTable;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@Getter
public class FullChildInfoByFullNamePane {
    private Pane pane;
    private Label childFullNameLabel;
    private ComboBox childFullNameBox;
    private Button childButton;
    private ChildController childController;
    private FullChildInfoByFullNameTable fullChildInfoByFullNameTable;
    private static Font mainFont = Font.font("Arial", FontWeight.NORMAL, 13);

    public FullChildInfoByFullNamePane() throws IOException, SQLException {
        pane = new Pane();
        createAllComboBoxes();
        createAllLabels();
        createChildButton();
    }

    private void createAllLabels() {
        childFullNameLabel = new Label("Укажите ребенка");
        setLabelLayoutAndFont(pane, childFullNameLabel, 10.0, 10.0, mainFont);
    }

    private void setLabelLayoutAndFont(Pane paneName, Label labelName, Double layoutX, Double layoutY, Font font) {
        labelName.setFont(font);
        labelName.setLayoutX(layoutX);
        labelName.setLayoutY(layoutY);
        paneName.getChildren().add(labelName);
    }

    private void createAllComboBoxes() throws IOException, SQLException {
        childController = new ChildController();
        ObservableList<String> getAllChildrenFullNamesList = FXCollections.observableArrayList(childController.getAllChildrenFullNames());
        childFullNameBox = new ComboBox<String>(getAllChildrenFullNamesList);
        childFullNameBox.setValue("Не выбрано");
        setComboBoxLayout(pane, childFullNameBox, 10.0, 30.0);
    }

    private void setComboBoxLayout(Pane paneName, ComboBox comboBoxName, Double layoutX, Double layoutY) {
        comboBoxName.setLayoutX(layoutX);
        comboBoxName.setLayoutY(layoutY);
        paneName.getChildren().add(comboBoxName);
    }

    private void createChildButton() {
        childButton = new Button("Показать данные");
        setButtonLayoutAndFont(pane, childButton, 10.0, 60.0);
        actionChildButton();
    }

    private void actionChildButton() {
        childButton.setOnAction(event -> {
            try {
                fullChildInfoByFullNameTable = new FullChildInfoByFullNameTable(childFullNameBox.getValue().toString());
            } catch (IOException | SQLException | ParseException e) {
                e.printStackTrace();
            }
            pane.getChildren().add(fullChildInfoByFullNameTable.getChildTable());
            pane.getChildren().add(fullChildInfoByFullNameTable.getChildStatusTable());
        });
    }

    private void setButtonLayoutAndFont(Pane paneName, Button buttonName, double layoutX, double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }
}
