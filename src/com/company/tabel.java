package com.company;


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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


/**
 * Created by Anton on 20.11.2016. Этот класс отвечает только за расчёты!
 */
public class tabel {


    private GridPane aken2 = new GridPane(); //setka gridpane
    private ScrollPane sp = new ScrollPane(); //sozdanie scrollpane
    private Scene scene2 = new Scene(sp,590,500); //sozdanie bazi okna
    VBox resultBio = new VBox(); //vertikaljnij stolbec dlja rezuljtata biomassi, vstavljaetsja v ja4eiku gridpane
    VBox resultSooda = new VBox();//vstavljaetsja v ja4eiku gridpane
    VBox resultJuurde = new VBox();
    VBox resultPaev2 = new VBox();




    public tabel(TextField biomass, TextField protsent, TextField fcr, TextField paevuarv) {// получили текстфилды


        sp.setContent(aken2); //vstavljaem v scrollpane gridpane!!!!!!!! ne naoborot
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); //pokazivaet vbar, kogda nado (prokrutka okna)

        seadistaText();
        
        //pervij denj i pervie ras4eti
        double bioMassField = Double.parseDouble(biomass.getText()); //polu4aem na4aljnie dannie v tekstovom vide is field i preobrazuem v 4islo
        double feedAmountField = Double.parseDouble(protsent.getText()); // tekst v 4islo
        double feedConversionRatioField = Double.parseDouble(fcr.getText()); // tekst v 4islo
        int daysField = Integer.parseInt(paevuarv.getText()); //tekst v 4islo

        double soodakogus = (bioMassField * feedAmountField / 100); //söödakogus
        double juurdekasv = soodakogus / feedConversionRatioField; //juurdekasv
        double uusbiomass = juurdekasv + bioMassField; //uus biomass

        //eto vsje dannie pervogo dnja, ih nado otdeljno. ina4e oni budut povtorjatsja v cikle.
        Label uusBio = new Label(Double.toString(bioMassField)); // esli eto vstavitj v cikl, to na4aljnie dannie budut kazdij denj pojavljatsja
        resultBio.getChildren().addAll(uusBio); //posle togo kak pos4itali 4islo, ego nugno opjatj v text, 4tobi vstavitj v vBox

        Label sooda = new Label(Double.toString(soodakogus)); //novij soodakogus v tekst
        resultSooda.getChildren().addAll(sooda); //prisvaivaem novij soodakogus v textovom formate vBoxu

        Label juurde = new Label(Double.toString(juurdekasv));
        resultJuurde.getChildren().addAll(juurde);

        Label paev = new Label(Integer.toString(1)); // prosto vstavljaem 1 dlja pervogo dnja
        resultPaev2.getChildren().addAll(paev); //proboval v grid i vbox vstavitj dva objekta. grid dlja etogo ne podhodit. on pomeshaet objekti drug na druga po centru.

        resultSooda.setMargin(sooda, new Insets(5,5,5,5));//otstupi ot objekta vnutri kazdoj ja4eiki vBox (nado ditja pisatj - tekst)
        resultBio.setMargin(uusBio, new Insets(5,5,5,5));
        resultJuurde.setMargin(juurde, new Insets(5,5,5,5));
        resultPaev2.setMargin(paev, new Insets(5,5,5,5));



        //vtoroj denj i daljshe
        double[] mas = new double[daysField]; //sozdanie massiva, kotorij polu4aet 4islo vvedennih dnei, i rascitivaet plan kormlenija
        mas[0] = uusbiomass; //novaja biomassa
        for (int i = 1; i < mas.length; i++) {
            soodakogus = (mas[i - 1] * feedAmountField / 100); //söödakogus
            juurdekasv = soodakogus / feedConversionRatioField; //juurdekasv
            mas[i] = juurdekasv + mas[i - 1]; //uus biomass



            //dannie na4inaja so vtorogo dlja, to 4to s4itajet cikl
            Label uusBio2 = new Label(Double.toString(mas[i - 1])); //dealem iz double string, tak kak v Vbox mozno vstavitj toljko objekt
            Label sooda2 = new Label(Double.toString(soodakogus));
            Label juurde2 = new Label(Double.toString(juurdekasv));
            Label paev2 = new Label(Integer.toString(i+1));
            resultBio.getChildren().addAll(uusBio2); // dobavljaem dannie v vide string v Vbox
            resultSooda.getChildren().addAll(sooda2);
            resultJuurde.getChildren().addAll(juurde2);
            resultPaev2.getChildren().addAll(paev2);

            //resultBio.setAlignment(Pos.CENTER); //razmeshenie objekta po centru ja4eiki vBox
            //resultSooda.setAlignment(Pos.CENTER);
            //resultJuurde.setAlignment(Pos.CENTER);
            //resultPaev2.setAlignment(Pos.CENTER);

            resultBio.setPadding(new Insets(10, 10, 10, 10)); // otstupi ot objekta vnutri vBoxa
            resultSooda.setPadding(new Insets(10, 10, 10, 10)); // otstupi ot objekta vnutri  vsego vBoxa
            resultJuurde.setPadding(new Insets(10, 10, 10, 10)); // otstupi ot objekta vnutri vBoxa
            resultPaev2.setPadding(new Insets(10, 10, 10, 10)); // otstupi ot objekta vnutri vBoxa
            resultBio.setMargin(uusBio2, new Insets(5,5,5,5)); //otstupi ot objekta vnutri kazdoj ja4eiki vBox (nado ditja pisatj uusbio2)
            resultSooda.setMargin(sooda2, new Insets(5,5,5,5)); //otstupi ot objekta vnutri kazdoj ja4eiki vBox (nado ditja pisatj - tekst)
            resultJuurde.setMargin(juurde2, new Insets(5,5,5,5)); //otstupi ot objekta vnutri kazdoj ja4eiki vBox(nado ditja pisatj)
            resultPaev2.setMargin(paev2, new Insets(5,5,5,5)); //otstupi ot objekta vnutri kazdoj ja4eiki vBox(nado ditja pisatj)



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
        aken2.setHalignment(paevT, HPos.CENTER);//raspologaet tekst po centru ja4eiki
        aken2.setMargin(paevT, new Insets(12,12,12,12)); // daesh rebenka tekst i otstupi ot nego.
        bioT.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(bioT, 1, 0);
        aken2.setHalignment(bioT, HPos.CENTER);
        sootT.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(sootT, 2, 0);
        aken2.setHalignment(sootT, HPos.CENTER);
        juurdeT.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        aken2.add(juurdeT, 3, 0);
        aken2.setHalignment(juurdeT, HPos.CENTER);
        aken2.setMargin(juurdeT, new Insets(12,12,12,12)); // daesh rebenka tekst i otstupi ot nego.
    }


    private void startStage() {
        Stage stage = new Stage();
        stage.setTitle("Fishfarm Calculator!");
        scene2.setFill(Color.GRAY);
        stage.setScene(scene2);
        stage.show();
        aken2.setGridLinesVisible(true); // показывает сетку gridpane
        aken2.setVgap(0); // отступы между границами сетки, делает пустые места по вертикали
        aken2.setHgap(0); // от делает пустые места по горизонтали
        aken2.setAlignment(Pos.CENTER); // delaet gridpane po zentru. ткперь не работает из за скролпане
        aken2.add(resultBio, 1, 1); //dobavili VBox v gridpane
        aken2.add(resultSooda, 2, 1);
        aken2.add(resultJuurde, 3, 1);
        aken2.add(resultPaev2, 0, 1);
        aken2.setPadding(new Insets(25, 25, 25, 25)); // otstupi gridpane ot krajov



    }

}
