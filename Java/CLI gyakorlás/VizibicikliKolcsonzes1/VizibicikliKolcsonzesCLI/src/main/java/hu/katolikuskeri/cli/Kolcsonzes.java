package hu.katolikuskeri.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Kolcsonzes {
    public String Név;
    public Character JAzon;
    public int EÓra;
    public int EPerc;
    public int VÓra;
    public int VPerc;

    public Kolcsonzes(String név, Character JAzon, int EÓra, int EPerc, int VÓra, int VPerc) {
        Név = név;
        this.JAzon = JAzon;
        this.EÓra = EÓra;
        this.EPerc = EPerc;
        this.VÓra = VÓra;
        this.VPerc = VPerc;
    }

    public String getNév() {
        return Név;
    }

    public void setNév(String név) {
        Név = név;
    }

    public Character getJAzon() {
        return JAzon;
    }

    public void setJAzon(Character JAzon) {
        this.JAzon = JAzon;
    }

    public int getEÓra() {
        return EÓra;
    }

    public void setEÓra(int EÓra) {
        this.EÓra = EÓra;
    }

    public int getEPerc() {
        return EPerc;
    }

    public void setEPerc(int EPerc) {
        this.EPerc = EPerc;
    }

    public int getVÓra() {
        return VÓra;
    }

    public void setVÓra(int VÓra) {
        this.VÓra = VÓra;
    }

    public int getVPerc() {
        return VPerc;
    }

    public void setVPerc(int VPerc) {
        this.VPerc = VPerc;
    }
    public static ArrayList<Kolcsonzes> beolvas(String fájlelérés) {

        ArrayList<Kolcsonzes> kölcsönzések = new ArrayList<>();

        Scanner olvasó = null;
        try {
            olvasó = new Scanner(new File(fájlelérés),"UTF-8");
            olvasó.nextLine();
            while (olvasó.hasNextLine()){
                String sor = olvasó.nextLine();
                String[] adatok = sor.split(";");
                kölcsönzések.add(new Kolcsonzes(adatok[0],adatok[1].charAt(0),Integer.parseInt(adatok[2]),Integer.parseInt(adatok[3]),Integer.parseInt(adatok[4]),Integer.parseInt(adatok[5])));
            }
            olvasó.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }




        return kölcsönzések;
    }
}
