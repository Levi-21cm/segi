package hu.katolikuskeri.cli;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Totoszelveny {

    private int Év;
    private int Hét;
    private int Forduló;
    private int T13p1;
    private int Nyer13p1;
    private String Eredmények;

    public Totoszelveny(int év, int hét, int forduló, int t13p1, int nyer13p1, String eredmények) {
        Év = év;
        Hét = hét;
        Forduló = forduló;
        T13p1 = t13p1;
        Nyer13p1 = nyer13p1;
        Eredmények = eredmények;
    }
    public Totoszelveny(String[] adatok){
        this(Integer.parseInt(adatok[0]),Integer.parseInt(adatok[1]),Integer.parseInt(adatok[2]),Integer.parseInt(adatok[3]),Integer.parseInt(adatok[4]),adatok[5]);
    }

    public int getÉv() {
        return Év;
    }

    public void setÉv(int év) {
        Év = év;
    }

    public int getHét() {
        return Hét;
    }

    public void setHét(int hét) {
        Hét = hét;
    }

    public int getForduló() {
        return Forduló;
    }

    public void setForduló(int forduló) {
        Forduló = forduló;
    }

    public int getT13p1() {
        return T13p1;
    }

    public void setT13p1(int t13p1) {
        T13p1 = t13p1;
    }

    public int getNyer13p1() {
        return Nyer13p1;
    }

    public void setNyer13p1(int nyer13p1) {
        Nyer13p1 = nyer13p1;
    }

    public String getEredmények() {
        return Eredmények;
    }

    public void setEredmények(String eredmények) {
        Eredmények = eredmények;
    }
    private int dontetlenekSzama() {
        return megszamol('X');
    }

    private int megszamol(char kimenet) {
        return (int) Eredmények.chars().filter(ch -> ch == kimenet).count();
    }

    public boolean memvoltDontetlenMerkozes() {
        return dontetlenekSzama() == 0;
    }

    Totoszelveny(String eredmenyek) {
        this.Eredmények = eredmenyek;
    }


    public static ArrayList<Totoszelveny> beolvas(String file){
        ArrayList<Totoszelveny> dijasoks = new ArrayList<>();

        File fájl = new File(file);

        try {
            Scanner olvaso = new Scanner(fájl, StandardCharsets.UTF_8);

            olvaso.nextLine();
            int otszazsor= 0;

            while ((olvaso.hasNextLine())&&(otszazsor<=2000)){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Totoszelveny tmp = new Totoszelveny(adatok);
                dijasoks.add(tmp);
                otszazsor++;
            }

            olvaso.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return dijasoks;
    }
}
