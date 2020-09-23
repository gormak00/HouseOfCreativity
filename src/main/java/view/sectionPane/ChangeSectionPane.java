package view.sectionPane;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import model.Section;
import view.table.SectionTable;

@Getter
public class ChangeSectionPane {
    private Pane changePane;
    private SectionTable sectionTable;
    private Button changeButton;

    public ChangeSectionPane() {
        changePane = new Pane();
        createTable();
        createChangeButton();
    }

    private void createChangeButton() {
        changeButton = new Button("Изменить выбранную секцию");
        setButtonLayoutAndFont(changePane, changeButton, 275.0, 550.0);
        action();
    }

    private void setButtonLayoutAndFont(Pane paneName, javafx.scene.control.Button buttonName, double layoutX, double layoutY) {
        buttonName.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        buttonName.setLayoutX(layoutX);
        buttonName.setLayoutY(layoutY);
        paneName.getChildren().add(buttonName);
    }

    private void action() {
        changeButton.setOnAction(event -> {
            Section selectedItem = sectionTable.getTable().getSelectionModel().getSelectedItem();
            AddSectionPane addSectionPane = new AddSectionPane(true);
        });
    }

    private void createTable() {
        sectionTable = new SectionTable();
        changePane.getChildren().add(sectionTable.getTable());
    }
}
