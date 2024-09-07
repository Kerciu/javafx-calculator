package com.calculator.darkMode;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ToggleSwitch extends Pane {

    private BooleanProperty switchedOn = new SimpleBooleanProperty(false);

    private TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25));
    private FillTransition fillTransition = new FillTransition(Duration.seconds(0.25));

    public ToggleSwitch(int width, int height)
    {
        Rectangle rectangle = createButtonBackground(width, height);

        int triggerRadius = height / 2;
        Circle trigger = createTriggerCircle(triggerRadius);

        getChildren().addAll(rectangle, trigger);

        translateTransition.setNode(trigger);

        switchedOn.addListener((obs, oldState, newState) -> {
            boolean isOn = newState;

            translateTransition.setToX(isOn ? width - height : 0);

            fillTransition.setShape(rectangle);
            fillTransition.setFromValue(isOn ? Color.WHITE : Color.rgb(0xe2, 0x4a, 0xdf));
            fillTransition.setToValue(isOn ? Color.rgb(0xe2, 0x4a, 0xdf) : Color.WHITE);

            fillTransition.setOnFinished(event -> {
                if (isOn) {
                    rectangle.setFill(createLinearPinkOrangeGradient());
                } else {
                    rectangle.setFill(Color.WHITE);
                }
            });

            ParallelTransition parallelTransition = new ParallelTransition(translateTransition, fillTransition);
            parallelTransition.play();
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

    private LinearGradient createLinearPinkOrangeGradient()
    {
        return new LinearGradient(
                0, 0, 1, 1,
                true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(0xe2, 0x4a, 0xdf)),
                new Stop(1, Color.rgb(0xf4, 0x97, 0x2a))
        );
    }

    public BooleanProperty isSwitchedOn() {
        return switchedOn;
    }
}
