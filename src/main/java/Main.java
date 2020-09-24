import javafx.application.Application;
import javafx.stage.Stage;
import repository.ConnectionToDB;
import view.AppScene;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("ТАКОООЙ ДАУН");
        /*ConnectionToDB connectionToDB = new ConnectionToDB();
        connectionToDB.getDB();*/
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AppScene appScene = new AppScene();
        primaryStage.setTitle("House of creativity");
        //stage.getIcons().add(new Image("icon.png"));
        primaryStage.setScene(appScene.getMainScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
