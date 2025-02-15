package ru.arsen.oop32;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Model model;
    private TextField textFieldA, textFieldB, textFieldC;
    private Spinner<Integer> spinnerA, spinnerB, spinnerC;
    private Slider sliderA, sliderB, sliderC;


    @Override
    public void start(Stage stage) throws IOException {

        model = new Model();

        textFieldA = new TextField();
        textFieldB = new TextField();
        textFieldC = new TextField();

        textFieldA.setText(String.valueOf(model.getA()));
        textFieldB.setText(String.valueOf(model.getB()));
        textFieldC.setText(String.valueOf(model.getC()));

        spinnerA = new Spinner(0,100,model.getA());
        spinnerB = new Spinner(0,100,model.getB());
        spinnerC = new Spinner(0,100,model.getC());

        sliderA = new Slider(0,100,model.getA());
        sliderB = new Slider(0,100,model.getB());
        sliderC = new Slider(0,100,model.getC());

        textFieldA.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                int value = Integer.parseInt(newValue);
                model.setA(value);
                updateView();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });

        textFieldB.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                int value = Integer.parseInt(newValue);
                model.setB(value);
                updateView();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });

        textFieldC.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                int value = Integer.parseInt(newValue);
                model.setC(value);
                updateView();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });


        spinnerA.valueProperty().addListener((observable, oldValue, newValue) -> {
            model.setA(newValue);
            updateView();
        });

        spinnerB.valueProperty().addListener((observable, oldValue, newValue) -> {
            model.setB(newValue);
            updateView();
        });

        spinnerC.valueProperty().addListener((observable, oldValue, newValue) -> {
            model.setC(newValue);
            updateView();
        });


        sliderA.valueProperty().addListener((observable, oldValue, newValue) -> {
            model.setA(newValue.intValue());
            updateView();
        });

        sliderB.valueProperty().addListener((observable, oldValue, newValue) -> {
            model.setB(newValue.intValue());
            updateView();
        });

        sliderC.valueProperty().addListener((observable, oldValue, newValue) -> {
            model.setC(newValue.intValue());
            updateView();
        });


        VBox vBoxA = new VBox(10,textFieldA, spinnerA, sliderA);
        VBox vBoxB = new VBox(10,textFieldB, spinnerB, sliderB);
        VBox vBoxC = new VBox(10,textFieldC, spinnerC, sliderC);

        FlowPane hBox = new FlowPane(vBoxA, vBoxB, vBoxC);
        hBox.setHgap(50);
        StackPane stackPane = new StackPane(hBox);

        Scene scene = new Scene(stackPane, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void updateView() {
        textFieldA.setText(String.valueOf(model.getA()));
        textFieldB.setText(String.valueOf(model.getB()));
        textFieldC.setText(String.valueOf(model.getC()));

        spinnerA.getValueFactory().setValue(model.getA());
        spinnerB.getValueFactory().setValue(model.getB());
        spinnerC.getValueFactory().setValue(model.getC());

        sliderA.setValue(model.getA());
        sliderB.setValue(model.getB());
        sliderC.setValue(model.getC());
    }

    @Override
    public void stop(){
        model.save();
    }

    public static void main(String[] args) {
        launch();
    }
}