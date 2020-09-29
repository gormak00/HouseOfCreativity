import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import repository.ConnectionToDB;
import view.AppScene;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    public static void main(String[] args) throws IOException, SQLException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AppScene appScene = new AppScene();
        primaryStage.setTitle("House of creativity");
        primaryStage.getIcons().add(new Image("image.jpg"));
        primaryStage.setScene(appScene.getMainScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
