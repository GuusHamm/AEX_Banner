package aexbanner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AEXBanner extends Application {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 100;
    public static final int NANO_TICKS = 10 * 1000000;
    public final double textSpeed = 12;
    // FRAME_RATE = 1000000000/NANO_TICKS = 50;

    private Text text;
    private double textLength;
    private double textPosition;
    private BannerController controller;
    private AnimationTimer animationTimer;

    @Override
    public void start(Stage primaryStage) {
        Font font = new Font("Arial", HEIGHT);
        text = new Text();
        text.setFont(font);
        text.setFill(Color.BLACK);

        Pane root = new Pane();
        root.getChildren().add(text);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("AEX banner");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.toFront();


        // Start animation: text moves from right to left
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {
                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                    textPosition -= textSpeed;
                }

                if (textPosition + textLength < 0) {
                    textPosition = 1000;
                }

                text.relocate(textPosition,0);
                prevUpdate = now;
            }
            @Override
            public void start() {
                prevUpdate = System.nanoTime();
                textPosition = WIDTH;
                text.relocate(textPosition, 0);
                setKoersen("Nothing to display");
                super.start();
            }
        };
        animationTimer.start();
        controller = new BannerController(this);
    }

    public void setKoersen(String koersen) {
        text.setText(koersen);
        textLength = text.getLayoutBounds().getWidth();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        animationTimer.stop();
        controller.stop();
    }
}
