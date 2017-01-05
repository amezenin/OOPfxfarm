package com.company;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by Anton on 16.11.2016.
 */
public class biofilter {

    private GridPane aken3 = new GridPane();
    private Scene scene3 = new Scene(aken3,490,250);
    Button arvuta = new Button("Arvuta!");
    Button nullida = new Button("Nullida!");


    TextField maxSoot = new TextField();
    TextField element = new TextField();

    Label tulemusMax = new Label();
    Label tulemusMin = new Label();


    public biofilter () { //bez metoda ne zapustish
        startStage();
        seadistaNuppud();
        seadistaField();
        arvutamine();
        seadistaText();
        seadistaLabel();

    }

    private void seadistaLabel() {
        aken3.add(tulemusMax,2,5);
        aken3.setMargin(tulemusMax, new Insets(0,0,0,30));

        aken3.add(tulemusMin,0,5);
        aken3.setMargin(tulemusMin, new Insets(0,0,0,30));
    }

    private void seadistaText() {

        Text sooda = new Text("Maksimaalne sööda kogus, kg");
        Text element = new Text("Biofiltri elemendi tööpindala, m2/m3");
        Text tulemus = new Text("Minimaalne elemendi kogus, m3");
        Text tulemus2 = new Text("Soovitatav elemendi kogus, m3");
        sooda.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken3.add(sooda, 0, 1);
        element.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken3.add(element, 2, 1);
        tulemus.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken3.add(tulemus, 0, 4);
        aken3.setMargin(tulemus, new Insets(40,0,0,0));//otstup ot verhnej 4asti teksta, vnutri ja4eiki
        tulemus2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken3.add(tulemus2, 2, 4);
        aken3.setMargin(tulemus2, new Insets(40,0,0,0));//otstup ot verhnej 4asti teksta, vnutri ja4eiki
    }

    private void arvutamine() {
        arvuta.setOnAction((event) -> {
            double soodaField = Double.parseDouble(maxSoot.getText());
            double elementField = Double.parseDouble(element.getText());
            double tulemus = (soodaField * 0.5 / 6.25 * 0.56) / elementField / 2 * 1000;
            double tulemus2 = tulemus * 2;
            tulemusMin.setText(String.valueOf(tulemus));
            tulemusMax.setText(String.valueOf(tulemus2));

        });

        nullida.setOnAction((event) -> {
            maxSoot.setText(null);
            element.setText(null);
            tulemusMax.setText(null);
            tulemusMin.setText(null);
        });

    }

    private void seadistaField() {
        aken3.add(maxSoot,0,2);
        maxSoot.setPromptText("Maksimaalne söödakogus, kg");
        aken3.add(element,2,2);
        element.setPromptText("Biofiltri elemendi tööpindala, m2/m3");

    }

    private void seadistaNuppud() {
        aken3.add(arvuta,0 ,3);
        aken3.add(nullida, 2, 3);
        nullida.setAlignment(Pos.CENTER);

    }

    private void startStage() {
        Stage stage = new Stage();
        stage.setTitle("Fishfarm Calculator!");
        scene3.setFill(Color.GRAY);
        stage.setScene(scene3);
        stage.show();
        //aken3.setGridLinesVisible(true); // показывает сетку gridpane
        aken3.setVgap(9); // отступы между копками, делает пустые места по вертикали
        aken3.setHgap(6); // отступы между копками, делает пустые места по горизонтали
        aken3.setAlignment(Pos.CENTER); // delaet gridpane po zentru
        aken3.setHalignment(nullida, HPos.CENTER); // выравнивает кнопку по центру гридпейна
        aken3.setHalignment(arvuta, HPos.CENTER);



    }


}
