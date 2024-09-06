package com.calculator.darkMode;

import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.lang.reflect.Method;

public class ToggleSwitch extends Pane {

    private BooleanProperty switchedOn = new SimpleBooleanProperty(false);

    private TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25));

    public ToggleSwitch(int width, int height)
    {
        Rectangle rectangle = createButtonBackground(width, height);

        int triggerRadius = height / 2;
        Circle trigger = createTriggerCircle(triggerRadius);

        getChildren().addAll(rectangle, trigger);

        translateTransition.setNode(trigger);

        switchedOn.addListener((obs, oldState, newState) -> {
            boolean isOn = newState.booleanValue();
            translateTransition.setToX(isOn ? width - height : 0);
            translateTransition.play();
        });

        setOnMouseClicked(event ->{
            switchedOn.set(!switchedOn.get());
        });
    }

    public void addSwitchedOnProperty(Runnable switchedOnMethod, Runnable switchedOffMethod)
    {
        switchedOn.addListener((obs, oldState, newState) -> {
            if (newState) {
                switchedOnMethod.run();
            } else {
                switchedOffMethod.run();
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
