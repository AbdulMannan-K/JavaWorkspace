package utilities;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class UIUtilities {
    public static void animateError(Label lbl, String message) {
        lbl.setVisible(true);
        lbl.setText(message);
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), lbl);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.play();
    }

    public static FadeTransition createFadeTransition(Node node, Double time, Integer counts, boolean fade) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(time), node);
        fadeTransition.setDelay(Duration.seconds(0));

        if(fade) {
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
        } else {
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
        }

        fadeTransition.setCycleCount(counts);
        fadeTransition.setAutoReverse(false);
        fadeTransition.setByValue(5);

        return fadeTransition;
    }

    public static FadeTransition createFadeTransition(Node node, Double time, Integer counts, boolean fade, EventHandler<ActionEvent> value) {
        FadeTransition fadeTransition = createFadeTransition(node, time, counts, fade);
        fadeTransition.setOnFinished(value);
        return fadeTransition;
    }

    public static RotateTransition createRotateTransition(Node node, Double time, Integer counts, boolean clockwise) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(time), node);
        rotateTransition.setDelay(Duration.seconds(0));

        if(clockwise) {
            rotateTransition.setFromAngle(0);
            rotateTransition.setToAngle(360);
        } else {
            rotateTransition.setFromAngle(360);
            rotateTransition.setToAngle(0);
        }

        rotateTransition.setCycleCount(counts);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setByAngle(180);

        return rotateTransition;
    }

    public static ParallelTransition createParallelTransition(Transition...transitions) {
        return new ParallelTransition(transitions);
    }

    public static ParallelTransition createParallelTransition(EventHandler<ActionEvent> value, Transition...transitions) {
        ParallelTransition parallelTransition = createParallelTransition(transitions);
        parallelTransition.setOnFinished(value);
        return parallelTransition;
    }

    public static SequentialTransition createSequentialTransition(Transition...transitions) {
        return new SequentialTransition(transitions);
    }

    public static SequentialTransition createSequentialTransition(EventHandler<ActionEvent> value, Transition...transitions) {
        SequentialTransition sequentialTransition = createSequentialTransition(transitions);
        sequentialTransition.setOnFinished(value);
        return sequentialTransition;
    }

}