//CSDS 132 YINGYU ZHU

package chess;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class ButtonStyleTest {

    @BeforeClass
    public static void initJFX() {
        Thread t = new Thread(() -> Application.launch(TestApp.class));
        t.setDaemon(true);
        t.start();
    }

    @Test
    public void applyTo() {
        Button button = new Button();
        ButtonStyle.BLACK.applyTo(button);
        assertEquals(1, button.getBackground().getFills().size());

        JButton jButton = new JButton();
        ButtonStyle.BLACK.applyTo(jButton);
        assertEquals(ButtonStyle.getAwtColor(ColorValue.BLACK.toString()), jButton.getBackground());
    }

    public static class TestApp extends Application {
        @Override
        public void start(Stage primaryStage) {
        }
    }
}