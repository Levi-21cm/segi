package hu.katolikuskeri.taxifuvarok.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Fuvar {
    private String taxi_id;
    private LocalDateTime indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetes_modja;

    public Fuvar(String taxi_id, LocalDateTime indulas, int idotartam, double tavolsag, double viteldij, double borravalo, String fizetes_modja) {
        this.taxi_id = taxi_id;
        this.indulas = indulas;
        this.idotartam = idotartam;
        this.tavolsag = tavolsag;
        this.viteldij = viteldij;
        this.borravalo = borravalo;
        this.fizetes_modja = fizetes_modja;
    }

    public String getTaxi_id() {
        return taxi_id;
    }

    public LocalDateTime getIndulas() {
        return indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetes_modja() {
        return fizetes_modja;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }

    public void setTavolsag(double tavolsag) {
        this.tavolsag = tavolsag;
    }

    public void setFizetes_modja(String fizetes_modja) {
        this.fizetes_modja = fizetes_modja;
    }

    @Override
    public String toString() {
        return String.format(this.indulas+" (Taxi #" + taxi_id +")");
    }
    public static ArrayList<Fuvar> beolvas(String fájlelérés) throws FileNotFoundException {

        ArrayList<Fuvar> fuvarozas = new ArrayList<>();

        Scanner olvasó = new Scanner(new File(fájlelérés),"UTF-8");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        olvasó.nextLine();
        while (olvasó.hasNextLine()){
            String sor = olvasó.nextLine();
            String[] adatok = sor.split(";");
            fuvarozas.add(new Fuvar(adatok[0], LocalDateTime.parse(adatok[1],DateTimeFormatter.ISO_LOCAL_DATE_TIME),Integer.parseInt(adatok[2]),Double.parseDouble(adatok[3]),Double.parseDouble(adatok[4]),Double.parseDouble(adatok[5]),adatok[6]));
        }

        return fuvarozas;
    }
}

