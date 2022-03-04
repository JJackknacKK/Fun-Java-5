//CSDS 132 YINGYU ZHU

package chess;

import javafx.geometry.Insets;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

import javax.swing.*;
import java.awt.*;

public class ButtonStyle {
    public static final ButtonStyle BLACK = new ButtonStyle(ColorValue.BLACK);
    public static final ButtonStyle DARK_GRAY = new ButtonStyle(ColorValue.DARK_GRAY);
    public static final ButtonStyle EAST = new ButtonStyle(ColorValue.EAST);
    public static final ButtonStyle EAST_HIGHLIGHTED = new ButtonStyle(ColorValue.EAST_HIGHLIGHTED);
    public static final ButtonStyle LIGHT_GRAY = new ButtonStyle(ColorValue.LIGHT_GRAY);
    public static final ButtonStyle NORTH = new ButtonStyle(ColorValue.NORTH);
    public static final ButtonStyle NORTH_HIGHLIGHTED = new ButtonStyle(ColorValue.NORTH_HIGHLIGHTED);
    public static final ButtonStyle SOUTH = new ButtonStyle(ColorValue.SOUTH);
    public static final ButtonStyle SOUTH_HIGHLIGHTED = new ButtonStyle(ColorValue.SOUTH_HIGHLIGHTED);
    public static final ButtonStyle WEST = new ButtonStyle(ColorValue.WEST);
    public static final ButtonStyle WEST_HIGHLIGHTED = new ButtonStyle(ColorValue.WEST_HIGHLIGHTED);
    public static final ButtonStyle WHITE = new ButtonStyle(ColorValue.WHITE);

    private final Paint javaFXTextColor;
    private final Background javaFXBackground;
    private final Color swingBackgroundColor;
    private final Color swingFontColor;

    public ButtonStyle(ColorValue pieceColor) {
        ColorValue fontColor = getTextColorByBackgroundColor(pieceColor);
        this.javaFXTextColor = Paint.valueOf(fontColor.toString());
        this.javaFXBackground = new Background(new BackgroundFill(Paint.valueOf(pieceColor.toString()), CornerRadii.EMPTY, new Insets(1)));
        this.swingBackgroundColor = getAwtColor(pieceColor.toString());
        this.swingFontColor = getAwtColor(fontColor.toString());
    }

    public ButtonStyle(ColorValue pieceColor, ColorValue backgroundColor) {
        ColorValue fontColor = getTextColorByBackgroundColor(pieceColor);
        this.javaFXTextColor = Paint.valueOf(fontColor.toString());
        this.javaFXBackground = new Background(
                new BackgroundFill(Paint.valueOf(backgroundColor.toString()), CornerRadii.EMPTY, new Insets(1)),
                new BackgroundFill(Paint.valueOf(pieceColor.toString()), new CornerRadii(25), Insets.EMPTY));
        this.swingBackgroundColor = getAwtColor(pieceColor.toString());
        this.swingFontColor = getAwtColor(fontColor.toString());
    }

    public static Color getAwtColor(String str) {
        return new Color(Integer.parseInt(str.substring(1), 16));
    }

    private static ColorValue getTextColorByBackgroundColor(ColorValue backgroundColor) {
        switch (backgroundColor) {
            case BLACK:
            case EAST:
            case NORTH:
            case WEST:
                return ColorValue.WHITE;
            default:
                return ColorValue.BLACK;
        }
    }

    public void applyTo(Labeled button) {
        button.setTextFill(javaFXTextColor);
        button.setBackground(javaFXBackground);
    }

    public void applyTo(JComponent button) {
        button.setBackground(swingBackgroundColor);
        button.setForeground(swingFontColor);
    }
}
