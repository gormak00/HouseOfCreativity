package view.sectionPane;

import controller.dto.SectionDto;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import lombok.Getter;
import view.table.SectionTable;

import java.io.IOException;
import java.sql.SQLException;

@Getter
public class ChangeSectionPane {
    private Pane changePane;
    private SectionTable sectionTable;
    private Button changeButton;

    public ChangeSectionPane() throws IOException, SQLException {
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
            SectionDto selectedSectionDto = sectionTable.getTable().getSelectionModel().getSelectedItem();
            try {
                AddSectionPane addSectionPane = new AddSectionPane(selectedSectionDto);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void createTable() throws IOException, SQLException {
        sectionTable = new SectionTable();
        changePane.getChildren().add(sectionTable.getTable());
    }
}
