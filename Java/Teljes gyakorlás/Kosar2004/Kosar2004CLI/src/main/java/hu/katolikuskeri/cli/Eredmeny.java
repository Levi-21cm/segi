package hu.katolikuskeri.cli;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Eredmeny {
    private String haza;
    private String idegen;
    private int hazai_pont;
    private int idegen_pont;
    private String helyszín;
    private LocalDate időpont;

    public Eredmeny(String haza, String idegen, int hazai_pont, int idegen_pont, String helyszín, LocalDate időpont) {
        this.haza = haza;
        this.idegen = idegen;
        this.hazai_pont = hazai_pont;
        this.idegen_pont = idegen_pont;
        this.helyszín = helyszín;
        this.időpont = időpont;
    }
    public Eredmeny(String[] adatok) {
        this(adatok[0], adatok[1], Integer.parseInt(adatok[2]), Integer.parseInt(adatok[3]),adatok[4],LocalDate.parse(adatok[5]));
    }

    public String getHaza() {
        return haza;
    }

    public String getIdegen() {
        return idegen;
    }

    public int getHazai_pont() {
        return hazai_pont;
    }

    public int getIdegen_pont() {
        return idegen_pont;
    }

    public String getHelyszín() {
        return helyszín;
    }

    public LocalDate getIdőpont() {
        return időpont;
    }

    public void setHelyszín(String helyszín) {
        this.helyszín = helyszín;
    }


    public static ArrayList<Eredmeny> beolvas(String file){
        ArrayList<Eredmeny> eredmenyek = new ArrayList<>();

        File fájl = new File(file);
        try {
            Scanner olvaso = new Scanner(fájl, "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Eredmeny tmp = new Eredmeny(adatok);
                eredmenyek.add(tmp);
            }

            olvaso.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return eredmenyek;
    }

    @Override
    public String toString() {
        return helyszín + "(" + időpont + ")";
    }
}
