package com.calculator.darkMode;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ToggleSwitch extends Pane {

    private BooleanProperty switchedOn = new SimpleBooleanProperty(false);

    private TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25));
    private FillTransition fillTransition = new FillTransition(Duration.seconds(0.25));

    private ParallelTransition animation = new ParallelTransition(translateTransition, fillTransition);

    public ToggleSwitch(int width, int height, Color fromColor, Color toColor)
    {
        Rectangle rectangle = createButtonBackground(width, height);

        int triggerRadius = height / 2;
        Circle trigger = createTriggerCircle(triggerRadius);

        getChildren().addAll(rectangle, trigger);

        translateTransition.setNode(trigger);
        fillTransition.setShape(rectangle);

        switchedOn.addListener((obs, oldState, newState) -> {
            Color darkModeColor = Color.rgb(12, 12,12);

            boolean isOn = newState;

            translateTransition.setToX(isOn ? width - height : 0);
            fillTransition.setFromValue(isOn ? fromColor : toColor);
            fillTransition.setToValue(isOn ? toColor : fromColor);

            animation.play();
        });

        setOnMouseClicked(event ->{
            switchedOn.set(!switchedOn.get());
        });
    }

    public void addSwitchedOnProperty(Runnable switchedOffMethod, Runnable switchedOnMethod)
    {
        switchedOn.addListener((obs, oldState, newState) -> {
            if (newState) {
                switchedOffMethod.run();
            } else {
                switchedOnMethod.run();
            }
        });
    }

    private Rectangle createButtonBackground(int width, int height)
    {
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setArcWidth(height);
        rectangle.setArcHeight(height);
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

    public BooleanProperty isSwitchedOn() {
        return switchedOn;
    }
}
