package aexbanner;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AEXBanner extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AEXBanner.fxml"));
        fxmlLoader.setController(new AEXBannerController(this));

        primaryStage.setTitle("AEXBanner");
        primaryStage.setScene(new Scene(fxmlLoader.load(), 300, 275));
        primaryStage.show();
    }

    public void stop() {
        // TODO - implement Application.stop

    }


    public static void main(String[] args) {
        launch(args);
    }
}
