package hu.katolikuskeri.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Kolcsonzes> kolcsonzes;
        kolcsonzes= Kolcsonzes.beolvas("forras.txt");

        System.out.println("5.Feladat: Napi kölcsönzések száma: "+ kolcsonzes.size());
        Scanner konzol = new Scanner(System.in);
        System.out.println("6.Feladat: Kérek egy nevet:");
        String nev = konzol.nextLine();
        System.out.println("\t\t"+nev + " kölcsönzései:");
        for (Kolcsonzes elem: kolcsonzes){
            if (elem.getNév().equals(nev)){
                System.out.printf("\t\t%d:%d - %d:%d\n",elem.getEÓra(),elem.getEPerc(),elem.getVÓra(),elem.getVPerc());
            }
        }
        System.out.println("7.Feladat: Adjon meg egy időpontot óra:perc alakban: ");
        String ido = konzol.nextLine();

        String[] darabolt = ido.split(":");
        System.out.println("\t A vízen lévő járművek:");

        int ora = Integer.parseInt(darabolt[0]);
        int perc = Integer.parseInt(darabolt[1]);

        LocalTime kolcsonzesbevane = LocalTime.of(ora,perc);
        for (Kolcsonzes elem: kolcsonzes){
            LocalTime van = LocalTime.of(elem.getEÓra(), elem.getEPerc());
            LocalTime nincs = LocalTime.of(elem.getVÓra(), elem.getVPerc());
            if (kolcsonzesbevane.isAfter(van) && kolcsonzesbevane.isBefore(nincs)){
                System.out.println("\t\t" + LocalTime.of(elem.getEÓra(),elem.getEPerc()) + "-" + LocalTime.of(elem.VÓra, elem.VPerc) + " : " + elem.getNév());
            }
        }
        long osszeg =0;

        for (Kolcsonzes elem: kolcsonzes){
            LocalTime kezdo = LocalTime.of(elem.getEÓra(), elem.getEPerc());
            LocalTime vegzo = LocalTime.of(elem.getVÓra(), elem.getVPerc());

            long különbség = Duration.between(kezdo,vegzo).toMinutes();
            long megkezdettora= különbség/30;

            if (különbség%30!=0) {
                megkezdettora++;

                /*int segedke = (int) Duration.between(kezdo,vegzo).toMinutes();
                System.out.println("30-nál nagyobb");
                System.out.println(segedke);
                darab = darab * (segedke/30);
                /*if (Duration.between(kezdo,vegzo).toMinutes()>60) {
                    darab--;
                    darab = (segedke / 30 )*darab;

                }
                else {

                }*/
            }
            osszeg +=megkezdettora*2400;
        }

        System.out.println("8.Feladat: Napi bevétel: "+ osszeg);
        try {
            PrintWriter iro = new PrintWriter("F.txt");
            for (Kolcsonzes elem:kolcsonzes){
                if (elem.getJAzon() == 'F'){
                    System.out.printf("%s-%s : %s\n",elem.getEPerc(),elem.getEÓra(),elem.getNév());
                }
            }
            iro.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hiba a fájlbeírás");
        }
        HashMap<Character,Integer> statisztika = new HashMap<>();
        for (Kolcsonzes elem:kolcsonzes){
            if (statisztika.containsKey(elem.getJAzon())){
                int korabbi = statisztika.get(elem.getJAzon());
                statisztika.put(elem.getJAzon(),korabbi+1);
            }else {
                statisztika.put(elem.getJAzon(),1);
            }
        }
    }
    }
