package com.company;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Anton on 16.11.2016.
 */
public class Calc {

    private GridPane aken1 = new GridPane();
    private Scene scene1 = new Scene(aken1, 400, 200);
    Button Ratsioon = new Button("Söödaratsiooni kalkulaator");
    Button Biofiltri = new Button("Biofiltri võimsuse kalkulaator");

    public Calc () { //bez metoda ne zapustish
        startStage();
        seadistaNuppud();
        arvutamine();
        seadistaText();
    }

    private void seadistaText() {
        Text tere = new Text("FishFarmCalc vol 1.0 ");
        Text val = new Text("Valige kalkulaator");
        tere.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        aken1.add(tere, 1, 0);
        val.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        aken1.add(val, 2, 0);
    }

    private void startStage() {
        Stage stage = new Stage();
        stage.setTitle("Fishfarm Calculator!");
        scene1.setFill(Color.GRAY);
        stage.setScene(scene1);
        stage.show();
        //aken1.setGridLinesVisible(true); // показывает сетку гридпейн
        aken1.setVgap(15); // отступы между копками, делает пустые места по вертикали
        aken1.setHgap(12); // отступы между копками, делает пустые места по горизонтали
        aken1.setAlignment(Pos.CENTER); // выравнивает гридпайн по центру
    }


    private void seadistaNuppud() {
        aken1.add(Ratsioon, 1, 1);
        aken1.add(Biofiltri, 2, 1);
    }


    private void arvutamine() {
        Ratsioon.setOnAction(arg0 -> new ratsioon());
        Biofiltri.setOnAction(arg0 -> new biofilter());
    }


}


