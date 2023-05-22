package hu.katolikuskeri.ultrabalaton.cli;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Versenyzok {
    private String versenyző;
    private int rajtszám;
    private String kategória;
    private String versenyidő;
    private int távszázalék;

    public Versenyzok(String versenyző, int rajtszám, String kategória, String versenyidő, int távszázalék) {
        this.versenyző = versenyző;
        this.rajtszám = rajtszám;
        this.kategória = kategória;
        this.versenyidő = versenyidő;
        this.távszázalék = távszázalék;
    }
    public Versenyzok(String[] adatok) {
        this(adatok[0], Integer.parseInt(adatok[1]), adatok[2], adatok[3],Integer.parseInt(adatok[4]));
    }

    public String getVersenyző() {
        return versenyző;
    }

    public void setVersenyző(String versenyző) {
        this.versenyző = versenyző;
    }

    public int getRajtszám() {
        return rajtszám;
    }

    public void setRajtszám(int rajtszám) {
        this.rajtszám = rajtszám;
    }

    public String getKategória() {
        return kategória;
    }

    public void setKategória(String kategória) {
        this.kategória = kategória;
    }

    public String getVersenyidő() {
        return versenyidő;
    }

    public void setVersenyidő(String versenyidő) {
        this.versenyidő = versenyidő;
    }

    public int getTávszázalék() {
        return távszázalék;
    }

    public void setTávszázalék(int távszázalék) {
        this.távszázalék = távszázalék;
    }
    public static ArrayList<Versenyzok> beolvas(String file){
        ArrayList<Versenyzok> versenyzok = new ArrayList<>();

        File fájl = new File(file);
        int darab=0;
        try {
            Scanner olvaso = new Scanner(fájl, "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                darab++;
                String[] adatok = sor.split(";");
                Versenyzok tmp = new Versenyzok(adatok);
                versenyzok.add(tmp);
                if (darab>=500){
                    System.out.println("A beolvasott fájl több mint 500 sort tartalmaz");
                    break;
                }
            }

            olvaso.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return versenyzok;
    }
    public double getIdoOraban() {
        String[] idoElemek = versenyidő.split(":");
        int ora = Integer.parseInt(idoElemek[0]);
        int perc = Integer.parseInt(idoElemek[1]);
        int masodperc = Integer.parseInt(idoElemek[2]);
        int osszMp = ora * 3600 + perc * 60 + masodperc;
        double idoOraban = osszMp / 3600.0;
        return idoOraban;
    }
}

