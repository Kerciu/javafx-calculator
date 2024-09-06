package com.calculator.darkMode;

import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ToggleSwitch {

    private BooleanProperty switchedOn = new SimpleBooleanProperty(false);

    private TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25));

    public ToggleSwitch(int width, int height)
    {
        Rectangle rectangle = createButtonBackground(width, height);

        int triggerRadius = height / 2;
        Circle trigger = createTriggerCircle(triggerRadius);

        translateTransition.setNode(trigger);

        switchedOn.addListener((obs, oldState, newState) -> {
            boolean isOn = newState.booleanValue();
            translateTransition.setToX(isOn ? width - triggerRadius : 0);
            translateTransition.play();
        });
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
