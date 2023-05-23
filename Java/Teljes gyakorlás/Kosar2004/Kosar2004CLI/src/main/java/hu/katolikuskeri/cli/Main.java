package hu.katolikuskeri.cli;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Eredmeny> eredmenyek = Eredmeny.beolvas("eredmenyek.csv");
        int hazaidb =0 ;
        int idegendarab =0;
        for (Eredmeny elem : eredmenyek){
            if ((elem.getHaza().equals("Real Madrid"))){
                hazaidb++;
            }
            if ((elem.getIdegen().equals("Real Madrid"))){
                idegendarab++;
            }
        }
        System.out.println("5. feladat: Real Madrid: Hazai: "+hazaidb +", Idegen: " + idegendarab);
        boolean volt = false;
        for (Eredmeny elem : eredmenyek){
            if (elem.getHazai_pont()==elem.getIdegen_pont()){
                volt=true;
                break;
            }
        }
        if (volt){
            System.out.println("6. feladat: Volt döntetlen? igen");
        }else {
            System.out.println("6. feladat: Volt döntetlen? nem");
        }
        for (Eredmeny elem : eredmenyek){
            if (elem.getIdőpont().isEqual(LocalDate.of(2004,11,21))){
                System.out.println("\t\t"+elem.getHaza()+" - "+elem.getIdegen()+" ("+elem.getHazai_pont()+":"+ elem.getIdegen_pont()+")");
            }
        }
        Map<String, Integer> stadionok = new HashMap<>();
        for (Eredmeny eredmeny : eredmenyek) {
            String helyszin = eredmeny.getHelyszín();
            if (stadionok.containsKey(helyszin)) {
                stadionok.put(helyszin, stadionok.get(helyszin) + 1);
            } else {
                stadionok.put(helyszin, 1);
            }
        }
        System.out.println("8. feladat:");
        // Stadionok kiírása, ahol több mint 20 mérkőzés volt
        for (Map.Entry<String, Integer> entry : stadionok.entrySet()) {
            String stadion = entry.getKey();
            int mérkőzésekSzáma = entry.getValue();
            if (mérkőzésekSzáma > 20) {
                System.out.println("\t\t"+stadion + ": " + mérkőzésekSzáma);
            }
        }
    }


    }
