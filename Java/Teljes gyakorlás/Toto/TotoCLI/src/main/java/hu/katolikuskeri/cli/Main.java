package hu.katolikuskeri.cli;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Totoszelveny> totoszelvenyek =Totoszelveny.beolvas("toto.txt");
        System.out.println("3. feladat: Fordulók száma: " + totoszelvenyek.size());



        int telitalalat = 0;
        for (Totoszelveny elem: totoszelvenyek){
            if (elem.getT13p1()>=0){
                telitalalat+=elem.getT13p1();
            }
        }
        System.out.println("4.feladat: Telitalálatos szelvénxek száma : "+ telitalalat + " db");



        int telitalalatdarab = 0;
        long telitalalatpenz = 0;
        for (Totoszelveny elem: totoszelvenyek){
            if ((elem.getT13p1()>=1)||(elem.getNyer13p1()>0)){
                long nyeremeny = (long) elem.getT13p1() * elem.getNyer13p1();
                telitalalatdarab+= elem.getT13p1();
                telitalalatpenz += nyeremeny;
            }
        }
        System.out.println("5.feladat: Átlag: " + telitalalatpenz/telitalalatdarab + " Ft");



        Totoszelveny legkissebb = totoszelvenyek.get(0);
        for (Totoszelveny elem:totoszelvenyek){
            if (elem.getT13p1()>=1){
                legkissebb = elem;
                break;
            }
        }
        Totoszelveny legnagyobb = totoszelvenyek.get(0);
        for (Totoszelveny elem: totoszelvenyek){
            if (elem.getT13p1() >=1){
                if (elem.getNyer13p1() <legkissebb.getNyer13p1()){
                    legkissebb = elem;
                }
            }
            if (elem.getNyer13p1() >legnagyobb.getNyer13p1()){
                legnagyobb = elem;
            }

        }
        System.out.println("6.Feladat: ");
        System.out.println("\\Legnagyobb:");
        System.out.println("\t\tÉv: "+legnagyobb.getÉv());
        System.out.println("\t\tHét: "+legnagyobb.getHét()+".");
        System.out.println("\t\tForduló: "+legnagyobb.getForduló()+".");
        System.out.println("\t\tTelitalálat: "+legnagyobb.getT13p1()+" db");
        System.out.println("\t\tNyeremény: "+legnagyobb.getNyer13p1()+" Ft");
        System.out.println("\t\tEredmények: "+legnagyobb.getEredmények());
        System.out.println();
        System.out.println("\t\tLegkisebb:");
        System.out.println("\t\tÉv: "+legkissebb.getÉv());
        System.out.println("\t\tHét: "+legkissebb.getHét()+".");
        System.out.println("\t\tForduló: "+legkissebb.getForduló()+".");
        System.out.println("\t\tTelitalálat: "+legkissebb.getT13p1()+" db");
        System.out.println("\t\tNyeremény: "+legkissebb.getNyer13p1()+" Ft");
        System.out.println("\t\tEredmények: "+legkissebb.getEredmények());



        boolean volt = false;
        for (Totoszelveny elem: totoszelvenyek){
            if (elem.memvoltDontetlenMerkozes()){
                volt = true;
                break;
            }
        }
        if (volt){
            System.out.println("8. Feladat: Volt döntetlen nélküli forduló");
        }
        else{
            System.out.println("8. Feladat: Nem volt döntetlen nélküli forduló");
        }

    }
}