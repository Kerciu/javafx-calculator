package com.calculator.darkMode;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;

public class ToggleSwitch {

    private BooleanProperty switchedOn = new SimpleBooleanProperty(false);

    public ToggleSwitch(int width, int height)
    {
        Rectangle rectangle = createButtonBackground(width, height);
    }

    private Rectangle createButtonBackground(int width, int height)
    {
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setArcWidth(50);
        rectangle.setArcHeight(50);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.LIGHTGRAY);

        return rectangle;
    }

    private Circle createTriggerCircle(int radius)
    {
        Circle triggerCircle = new Circle(radius);
        triggerCircle.setCenterX(radius);
        triggerCircle.setCenterY(radius);
        triggerCircle.setFill(Color.WHITE);
        triggerCircle.setStroke(Color.LIGHTGRAY);

        return triggerCircle;
    }

    public boolean isSwitchedOn() {
        return switchedOn.get();
    }
}
