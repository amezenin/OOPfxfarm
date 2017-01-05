package com.company;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Anton on 16.11.2016.
 */
public class Calc {

    private GridPane aken1 = new GridPane(); // sozdanie gridpane tablica
    private Scene scene1 = new Scene(aken1, 620, 200); // baza okna
    Button Ratsioon = new Button("Söödaratsiooni kalkulaator"); //knopki
    Button Biofiltri = new Button("Biofiltri võimsuse kalkulaator"); //knopki
    Button lihtCalc = new Button("Lihtsustatud kalakasvatuse kalkulaator");



    public Calc () { //bez metoda ne zapustish
        startStage(); //  zapusk metoda okna i ego zapisk
        seadistaNuppud(); // zapusk metoda metoda, kotorij raspologaet knopki
        arvutamine(); // zapusk metoda sozdanie ras4etov
        seadistaText(); // zapusk metoda teksa teksa
        seadistaLitsens();
    }

    private void seadistaLitsens() {
        Image lit = new Image(getClass().getResourceAsStream("litsens.png"));
        ImageView litsens = new ImageView(lit);
        aken1.add(litsens,2,2);
        aken1.setHalignment(litsens, HPos.CENTER); //viravnivaet kartinku po centru
    }

    private void seadistaText() { //metod otve4ajushij za tekst ja ego raspolozenie

        Text val = new Text("Valige kalkulaator!");
        val.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        aken1.add(val, 2, 0);
    }

    private void startStage() { //metod otve4aet za vizualizaciju okna
        Stage stage = new Stage();
        stage.setTitle("Fishfarm Calculator!"); // dobavlenie nazvanija v shapku okna
        scene1.setFill(Color.GRAY); //cvet fona
        stage.setScene(scene1); //dobavitj v ramku okna fon
        stage.show(); //zapusk ramki okna
        //aken1.setGridLinesVisible(true); // показывает сетку гридпейн
        aken1.setVgap(15); // отступы между копками, делает пустые места по вертикали
        aken1.setHgap(12); // отступы между копками, делает пустые места по горизонтали
        aken1.setAlignment(Pos.CENTER); // выравнивает гридпайн по центру
    }


    private void seadistaNuppud() { //metod kotorij dobavljaet knopki v setku gridpane
        aken1.add(Ratsioon, 1, 1);
        aken1.add(Biofiltri, 2, 1);
        aken1.add(lihtCalc, 3, 1);
    }


    private void arvutamine() { //metod kotori pri nazatii knopki zapuskaet kod drugogo classa
        Ratsioon.setOnAction(arg0 -> new ratsioon()); //zapusk classa ratsion
        Biofiltri.setOnAction(arg0 -> new biofilter()); //zapusk classa biofilter
        lihtCalc.setOnAction(arg0 -> new lihtcalc());
    }


}


