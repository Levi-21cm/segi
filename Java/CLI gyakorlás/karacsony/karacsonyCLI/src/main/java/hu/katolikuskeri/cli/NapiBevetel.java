package hu.katolikuskeri.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NapiBevetel {
    private String Név;
    private char Csoport;
    private String NemzetÉsKód;
    private double D1;
    private double D2;
    private double D3;

    public NapiBevetel(String név, char csoport, String nemzetÉsKód, double d1, double d2, double d3) {
        Név = név;
        Csoport = csoport;
        NemzetÉsKód = nemzetÉsKód;
        D1 = d1;
        D2 = d2;
        D3 = d3;
    }
    private static double parseDobas(String adat) {
        if (adat.equals("X")) {
            return -1.0;
        } else if (adat.equals("-")) {
            return -2.0;
        } else {
            try {
                // Tizedespont és tizedesvessző kezelése
                String adatPont = adat.replace(',', '.');
                return Double.parseDouble(adatPont);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Érvénytelen érték: " + adat, e);
            }
        }
    }
    public NapiBevetel(String[] adat) {
        this(adat[0],
                adat[1].charAt(0),
                adat[2],
                parseDobas(adat[3]),
                parseDobas(adat[4]),
                parseDobas(adat[5])
        );
    }


    public String getNév() {
        return Név;
    }

    public void setNév(String név) {
        Név = név;
    }

    public char getCsoport() {
        return Csoport;
    }

    public void setCsoport(char csoport) {
        Csoport = csoport;
    }

    public String getNemzetÉsKód() {
        return NemzetÉsKód;
    }

    public void setNemzetÉsKód(String nemzetÉsKód) {
        NemzetÉsKód = nemzetÉsKód;
    }

    public Double getD1() {
        return D1;
    }

    public void setD1(Double d1) {
        D1 = d1;
    }

    public Double getD2() {
        return D2;
    }

    public void setD2(Double d2) {
        D2 = d2;
    }

    public Double getD3() {
        return D3;
    }

    public void setD3(Double d3) {
        D3 = d3;
    }

    public static ArrayList<NapiBevetel> beolvas(String fajl){
        ArrayList<NapiBevetel> versenyzo = new ArrayList<>();

        File file = new File(fajl);

        try {
            Scanner olvaso = new Scanner(file, "UTF-8");

            olvaso.nextLine();

            int szamolo=0;

            while ((olvaso.hasNextLine())&&(szamolo<50)){
                String sor = olvaso.nextLine();
                String[] adat = sor.split(";");
                NapiBevetel tmp = new NapiBevetel(adat);
                versenyzo.add(tmp);
                szamolo++;
            }

            olvaso.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return versenyzo;
    }
    public double getEredmeny() {
        double legnagyobbDobas = -1.0;
        if (D1 > legnagyobbDobas) {
            legnagyobbDobas = D1;
        }
        if (D2 > legnagyobbDobas) {
            legnagyobbDobas = D2;
        }
        if (D3 > legnagyobbDobas) {
            legnagyobbDobas = D3;
        }
        return legnagyobbDobas;
    }
    public String getNemzet() {
        return NemzetÉsKód.split("\\(")[0].trim();
    }

    public String getKod() {
        String kod = NemzetÉsKód.split("\\(")[1];
        return kod.substring(0, kod.length() - 1);
    }
}



