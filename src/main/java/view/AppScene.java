package view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AppScene {
    private AppMenuBar appMenuBar;
    private Scene scene;
    private BorderPane pane;

    public Scene getMainScene() {
        pane = new BorderPane();
        appMenuBar = new AppMenuBar(this);
        pane.setTop(appMenuBar.getMainMenuBar());

        scene = new Scene(pane, 800, 750);
        return scene;
    }


}
