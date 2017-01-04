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
 * Created by Anton on 04.01.2017.
 */
public class lihtcalc {

    private GridPane aken4 = new GridPane();
    private Scene scene4 = new Scene(aken4, 900, 400);
    Button arvutaBio = new Button("Arvuta biomass");
    Button arvutaPJuurde = new Button("Arvuta planeeritav juurdekasv");
    Button arvutaFCR = new Button("Arvuta FCR");
    TextField kaladeArv = new TextField();
    TextField keskmineKaal = new TextField();
    TextField soodaP = new TextField();
    TextField fcr = new TextField();
    TextField soodaT = new TextField();
    TextField juurdeT = new TextField();
    Label bioTextTulemus = new Label();
    Label pjTextTulemus = new Label();
    Label fcrTextTulemus = new Label();


    public lihtcalc() { //bez metoda ne zapustish
        startStage();
        seadistaNuppud();
        seadistaField();
        seadistaArvutamine();
        seadistaText();
        seadistaTulemused();
    }

    private void seadistaTulemused() {
        //Biomass
        aken4.add(bioTextTulemus,4,1);
        aken4.setMargin(bioTextTulemus, new Insets(0,0,0,10));
        //Planeeritav juurdekasv
        aken4.add(pjTextTulemus,4,3);
        aken4.setMargin(pjTextTulemus, new Insets(0,0,0,10));
        //Reaalne fcr
        aken4.add(fcrTextTulemus,4,5);
        aken4.setMargin(fcrTextTulemus, new Insets(0,0,0,10));
    }

    private void seadistaText() {
        //Biomass
        Text kaladeArv = new Text("Kalade arv, tk");
        Text keskKaal = new Text("Keskmine kaal, kg/tk");
        Text bioTulemus = new Text("Tulemus");
        Text bioArvutamine = new Text("Biomassi arvutamine:");
        kaladeArv.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(kaladeArv, 1, 0);
        aken4.setMargin(kaladeArv, new Insets(0,0,0,10));
        keskKaal.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(keskKaal, 2, 0);
        aken4.setMargin(keskKaal, new Insets(0,0,0,10));
        bioTulemus.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(bioTulemus, 4, 0);
        aken4.setMargin(bioTulemus, new Insets(0,0,0,10));
        bioArvutamine.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(bioArvutamine, 0, 1);

        //Planeeritav juurdekasv
        Text juurdeP = new Text("Planeeritav juurdekasv:");
        Text sootP = new Text("Söödakogus, kg");
        Text fcrTtext = new Text("FCR");
        Text pjTulemus = new Text("Tulemus");
        juurdeP.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(juurdeP, 0, 3);
        sootP.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(sootP, 1, 2);
        aken4.setMargin(sootP, new Insets(40,0,0,10));//otstup ot verhnej 4asti teksta, vnutri ja4eiki
        fcrTtext.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(fcrTtext, 2, 2);
        aken4.setMargin(fcrTtext, new Insets(40,0,0,10));//otstup ot verhnej 4asti teksta, vnutri ja4eiki
        pjTulemus.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(pjTulemus, 4, 2);
        aken4.setMargin(pjTulemus, new Insets(40,0,0,10));//otstup ot verhnej 4asti teksta, vnutri ja4eiki

        //Tegelekult  FCR
        Text fcrT = new Text("Reaalne FCR:");
        Text sootT = new Text("Söödakulud, kg ");
        Text juurdeKasvT = new Text("Reaalne juurdekasv");
        Text tjTulemus = new Text("Tulemus");
        fcrT.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(fcrT, 0, 5);
        sootT.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(sootT, 1, 4);
        aken4.setMargin(sootT, new Insets(40,0,0,10));//otstup ot verhnej 4asti teksta, vnutri ja4eiki
        juurdeKasvT.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(juurdeKasvT, 2, 4);
        aken4.setMargin(juurdeKasvT, new Insets(40,0,0,10));//otstup ot verhnej 4asti teksta, vnutri ja4eiki
        tjTulemus.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken4.add(tjTulemus, 4, 4);
        aken4.setMargin(tjTulemus, new Insets(40,0,0,10));//otstup ot verhnej 4asti teksta, vnutri ja4eiki



    }

    private void seadistaArvutamine() {
        //Biomassi arvutamine
        arvutaBio.setOnAction((event) -> {
            double kaladeArvField = Double.parseDouble(kaladeArv.getText());
            double keskmineKaalField = Double.parseDouble(keskmineKaal.getText());
            double tulemusBiomass = kaladeArvField * keskmineKaalField;
            bioTextTulemus.setText(Double.toString(tulemusBiomass)); //tut neljzja sozdavatj new Label :) pishet novij rezuljtat po verh starogo
        });


        //Planeeritav juurdekasv
        arvutaPJuurde.setOnAction((event) -> {
            double soodaPField = Double.parseDouble(soodaP.getText());
            double fcrField = Double.parseDouble(fcr.getText());
            double tulemusPJkasv = soodaPField / fcrField;
            pjTextTulemus.setText(String.valueOf(tulemusPJkasv));
        });

        //Reaalne FCR
        arvutaFCR.setOnAction((event) -> {
            double soodaTField = Double.parseDouble(soodaT.getText());
            double juurdeTField = Double.parseDouble(juurdeT.getText());
            double tulemusFCR = soodaTField / juurdeTField;
            fcrTextTulemus.setText(String.valueOf(tulemusFCR));
        });

    }

    private void seadistaField() {

        //biomassi osa
        aken4.add(kaladeArv, 1,1);
        kaladeArv.setPromptText("Sissestage kalade arv");
        aken4.setMargin(kaladeArv, new Insets(10,10,10,10));//otstup ot objekta, vnutri ja4eiki
        aken4.add(keskmineKaal, 2, 1);
        keskmineKaal.setPromptText("Sissestage keskmine kaal");
        aken4.setMargin(keskmineKaal, new Insets(10,10,10,10));//otstup ot objekta, vnutri ja4eiki


        //Planeeritav jurdekasv
        aken4.add(soodaP, 1,3);
        soodaP.setPromptText("Sissestage söödakogus");
        aken4.setMargin(soodaP, new Insets(10,10,10,10));//otstup ot objekta, vnutri ja4eiki
        aken4.add(fcr, 2, 3);
        fcr.setPromptText("Sissestage FCR");
        aken4.setMargin(fcr, new Insets(10,10,10,10));//otstup ot objekta, vnutri ja4eiki


        //Tegelt FCR
        aken4.add(soodaT, 1,5);
        soodaT.setPromptText("Sissestage söödakogus");
        aken4.setMargin(soodaT, new Insets(10,10,10,10));//otstup ot objekta, vnutri ja4eiki
        aken4.add(juurdeT, 2, 5);
        juurdeT.setPromptText("Sissestage juurdekasv");
        aken4.setMargin(juurdeT, new Insets(10,10,10,10));//otstup ot objekta, vnutri ja4eiki


    }

    private void seadistaNuppud() {
        //Biomass
        aken4.add(arvutaBio, 3, 1);
        //Planeeritav juurdekasv
        aken4.add(arvutaPJuurde, 3, 3);
        aken4.setMargin(arvutaPJuurde, new Insets(0,10,0,10));//otstup ot objekta sprava i sleva, vnutri ja4eiki
        //Tegelt FCR
        aken4.add(arvutaFCR, 3, 5);
    }





    private void startStage() {
        Stage stage = new Stage();
        stage.setTitle("Fishfarm Calculator!");
        scene4.setFill(Color.GRAY);
        stage.setScene(scene4);
        stage.show();
        //aken4.setGridLinesVisible(true); // показывает сетку gridpane
        //aken4.setVgap(0); // отступы между копками, делает пустые места по вертикали. ne nado ja ispoljzuju setMargin
        //aken4.setHgap(0); // отступы между копками, делает пустые места по горизонтали
        aken4.setAlignment(Pos.CENTER); // delaet gridpane po zentru
        aken4.setHalignment(arvutaBio, HPos.CENTER); // raspologaet knopki po centru
        aken4.setHalignment(arvutaFCR, HPos.CENTER);
        aken4.setHalignment(arvutaPJuurde, HPos.CENTER);


    }
    
    
    
}