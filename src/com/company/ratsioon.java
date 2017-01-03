package com.company;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class ratsioon {

    private GridPane aken2 = new GridPane();
    private Scene scene2 = new Scene(aken2, 700, 300);
    Button feedTable = new Button("Arvuta söödaratsiooni!");
    Button nullida = new Button("Nullida!");
    TextField biomass = new TextField();
    TextField protsent = new TextField();
    TextField fcr = new TextField();
    TextField paevuarv = new TextField();


    public ratsioon () { //bez metoda ne zapustish
        startStage();
        seadistaNuppud();
        seadistaField();
        seadistaArvutamine();
        seadistaText();

    }

    private void seadistaText() {
        Text bio = new Text("Biomass");
        Text pro = new Text("Söödaprotsent");
        Text fcr = new Text("Söödakoefitsient");
        Text paev = new Text("Päevade arv");
        bio.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(bio, 1, 0);
        pro.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(pro, 2, 0);
        fcr.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(fcr, 3, 0);
        paev.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(paev, 4, 0);
    }

    public void seadistaField() {
        aken2.add(biomass, 1,1);
        biomass.setPromptText("Sissestage biomass");
        aken2.add(protsent, 2, 1);
        protsent.setPromptText("Päevane sööda protsent");
        aken2.add(fcr, 3, 1);
        fcr.setPromptText("FCR");
        aken2.add(paevuarv, 4, 1);
        paevuarv.setPromptText("Päevade arv");
    }

    private void startStage() {
        Stage stage = new Stage();
        stage.setTitle("Fishfarm Calculator!");
        scene2.setFill(Color.GRAY);
        stage.setScene(scene2);
        stage.show();
        //aken2.setGridLinesVisible(true); // показывает сетку gridpane
        aken2.setVgap(9); // отступы между копками, делает пустые места по вертикали
        aken2.setHgap(6); // отступы между копками, делает пустые места по горизонтали
        aken2.setAlignment(Pos.CENTER); // delaet gridpane po zentru
        aken2.setHalignment(nullida, HPos.CENTER); // raspologaet knopki po centru
        aken2.setHalignment(feedTable, HPos.CENTER);

    }

    private void seadistaNuppud() {
        aken2.add(feedTable, 2, 5);
        aken2.add(nullida, 3, 5);

    }
    private void seadistaArvutamine() {

        feedTable.setOnAction(arg0 -> new tabel(biomass, protsent, fcr, paevuarv)); //отдали текствилды в другой класс


        /*feedTable.setOnAction((event) ->{

                    double bioMassField = Double.parseDouble(biomass.getText());
                    double feedAmountField = Double.parseDouble(protsent.getText());
                    double feedConversionRatioField = Double.parseDouble(fcr.getText());
                    int daysField = Integer.parseInt(paevuarv.getText());

                    double soodakogus = (bioMassField * feedAmountField / 100); //söödakogus
                    double juurdekasv = soodakogus / feedConversionRatioField; //juurdekasv
                    double uusbiomass = juurdekasv + bioMassField; //uus biomass

                    System.out.println(1 + " päev");
                    System.out.println(" Biomass: " + bioMassField);
                    System.out.println(" Söödakogus: " + soodakogus);
                    System.out.println(" Planeeritav juurdekasv: " + juurdekasv);


                    double[] mas = new double[daysField];
                    mas[0] = uusbiomass;
                    for (int i = 1; i < mas.length; i++) {
                        soodakogus = (mas[i - 1] * feedAmountField / 100); //söödakogus
                        juurdekasv = soodakogus / feedConversionRatioField; //juurdekasv
                        mas[i] = juurdekasv + mas[i - 1]; //uus biomass


                        System.out.println(i + 1 + " päev");
                        System.out.println(" Biomass: " + mas[i - 1]);
                        System.out.println(" Söödakogus: " + soodakogus);
                        System.out.println(" Planeeritav juurdekasv: " + juurdekasv);

                    }

    });*/

        nullida.setOnAction((event) -> { //obnuljaet textfield
            biomass.setText(null);
            protsent.setText(null);
            fcr.setText(null);
            paevuarv.setText(null);
        });
    }

}
