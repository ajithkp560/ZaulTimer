package ZaulTimer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    /*

    Coded By AJITH KP [ajithkp560]
    http://www.terminalcoders.blogspot.com
    http://fb.com/ajithkp560

     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ZaulTimer.fxml"));
        primaryStage.setTitle("..: AJITH KP ::.");
        primaryStage.setScene(new Scene(root, 1366, 786));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("zeITgeist 2K17");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
