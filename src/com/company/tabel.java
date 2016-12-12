package com.company;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.scene.control.ScrollPane.*;

/**
 * Created by Anton on 20.11.2016.
 */
public class tabel {

    private GridPane aken2 = new GridPane();
    private Scene scene2 = new Scene(aken2,1000,600);
    VBox resultBio = new VBox();
    VBox resultSooda = new VBox();
    VBox resultJuurde = new VBox();
    VBox resultPaev2 = new VBox();
    ScrollPane sp = new ScrollPane();


    public tabel(TextField biomass, TextField protsent, TextField fcr, TextField paevuarv) {// получили текстфилды

        seadistaText();

        double bioMassField = Double.parseDouble(biomass.getText());
        double feedAmountField = Double.parseDouble(protsent.getText());
        double feedConversionRatioField = Double.parseDouble(fcr.getText());
        int daysField = Integer.parseInt(paevuarv.getText());

        double soodakogus = (bioMassField * feedAmountField / 100); //söödakogus
        double juurdekasv = soodakogus / feedConversionRatioField; //juurdekasv
        double uusbiomass = juurdekasv + bioMassField; //uus biomass


        Label uusBio = new Label(Double.toString(bioMassField)); // esli eto vstavitj v cikl, to na4aljnie dannie budut kazdij denj pojavljatsja
        resultBio.getChildren().addAll(uusBio);

        Label sooda = new Label(Double.toString(soodakogus));
        resultSooda.getChildren().addAll(sooda);

        Label juurde = new Label(Double.toString(juurdekasv));
        resultJuurde.getChildren().addAll(juurde);

        Label paev = new Label(Integer.toString(1));
        resultPaev2.getChildren().addAll(paev); //proboval v grid i vbox vstavitj dva objekta. grid dlja etogo ne podhodit. on pomeshaet objekti drug na druga po centru.

        /*System.out.println(1 + " päev");
        System.out.println(" Biomass: " + bioMassField);
        System.out.println(" Söödakogus: " + soodakogus);
        System.out.println(" Planeeritav juurdekasv: " + juurdekasv);*/



        double[] mas = new double[daysField];
        mas[0] = uusbiomass;
        for (int i = 1; i < mas.length; i++) {
            soodakogus = (mas[i - 1] * feedAmountField / 100); //söödakogus
            juurdekasv = soodakogus / feedConversionRatioField; //juurdekasv
            mas[i] = juurdekasv + mas[i - 1]; //uus biomass



            /*System.out.println(i + 1 + " päev");
            System.out.println(" Biomass: " + mas[i - 1]);
            System.out.println(" Söödakogus: " + soodakogus);
            System.out.println(" Planeeritav juurdekasv: " + juurdekasv);*/

            Label uusBio2 = new Label(Double.toString(mas[i - 1])); //dealem iz double string, tak kak v Vbox mozno vstavitj toljko objekt
            Label sooda2 = new Label(Double.toString(soodakogus));
            Label juurde2 = new Label(Double.toString(juurdekasv));
            Label paev2 = new Label(Integer.toString(i+1));
            resultBio.getChildren().addAll(uusBio2); // dobavljaem dannie v vide string v Vbox
            resultSooda.getChildren().addAll(sooda2);
            resultJuurde.getChildren().addAll(juurde2);
            resultPaev2.getChildren().addAll(paev2);

        }

        startStage();


    }

    private void seadistaText() {
        Text paevT = new Text("Päev");
        Text bioT = new Text("Biomass");
        Text sootT = new Text("Söödakogus");
        Text juurdeT = new Text("Planeeritav juurdekasv");
        paevT.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(paevT, 0, 0);
        bioT.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(bioT, 1, 0);
        sootT.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(sootT, 2, 0);
        juurdeT.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(juurdeT, 3, 0);
    }


    private void startStage() {
        Stage stage = new Stage();

        stage.setTitle("Fishfarm Calculator!");
        scene2.setFill(Color.GRAY);
        stage.setScene(scene2);
        stage.show();
        //sp.setContent(resultBio); //content scrolpane
        //sp.setVbarPolicy(ScrollBarPolicy.ALWAYS); //vsegda pokazivatj vbar
        aken2.setGridLinesVisible(true); // показывает сетку gridpane
        aken2.setVgap(9); // отступы между копками, делает пустые места по вертикали
        aken2.setHgap(6); // отступы между копками, делает пустые места по горизонтали
        aken2.setAlignment(Pos.CENTER); // delaet gridpane po zentru
        aken2.add(resultBio, 1, 1); //dobavili VBox v gridpane
        aken2.add(resultSooda, 2, 1);
        aken2.add(resultJuurde, 3, 1);
        aken2.add(resultPaev2, 0, 1);
        //aken2.add(sp,1,1); //vstavljaet skroll s grid
        // dlja kazdogo vboxa nado otdeljno delatj scrollpane, nado kak to naiti kak sdelatj scroll dlja vsei stranici.




    }

}
