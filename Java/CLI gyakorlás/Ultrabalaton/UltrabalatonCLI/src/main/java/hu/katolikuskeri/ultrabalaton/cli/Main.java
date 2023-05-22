package hu.katolikuskeri.ultrabalaton.cli;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Versenyzok> versenyzok = Versenyzok.beolvas("ub2017egyeni.txt");
        int db =0;
        for (Versenyzok elem: versenyzok){
            db++;
        }
        System.out.println("3.feladat: Egyéni indulók: " + db + " fő");
        int nőiversenyzők = 0;
        for (Versenyzok elem: versenyzok){
            if ((elem.getKategória().equals("Noi"))&&(elem.getTávszázalék()==100)){
                nőiversenyzők++;
            }
        }
        System.out.println("4.feladat: Célba érkező női sportolók: " + nőiversenyzők + " fő");

        System.out.println("5.feladat: Kérem a sportoló nevét:");
        Scanner sc = new Scanner(System.in);
        String bekértnév = sc.nextLine();
        boolean volt = false;
        for (Versenyzok elem: versenyzok){
            if (elem.getVersenyző().equals(bekértnév)){
                if (elem.getTávszázalék()==100){
                    System.out.println("\tIndult egyéniben a sportoló? Igen");
                    System.out.println("\tTeljesítette a távot? Igen");
                    volt=true;
                    break;

                }
                else {
                    System.out.println("\tIndult egyéniben a sportoló? Igen");
                    System.out.println("\tTeljesítette a távot? Nem");
                    volt=true;
                    break;
                }
            }
        }
        if (!volt){
            System.out.println("\tIndult egyéniben a sportoló? Nem");
        }
        Versenyzok minimum2 = null;
        Versenyzok minimum = null;
        ArrayList<Versenyzok> teljesitok = new ArrayList<>();
        for (Versenyzok sportolo : versenyzok) {
            minimum = sportolo;
            minimum2= sportolo;
            if (sportolo.getKategória().equals("Ferfi") && sportolo.getTávszázalék()==100) {
                teljesitok.add(sportolo);
            }
        }

        double osszes = 0;
        for (Versenyzok elem : teljesitok){
            osszes += elem.getIdoOraban();
            if (elem.getIdoOraban()<=minimum.getIdoOraban()){
                minimum = elem;
            }
        }
        System.out.println("7.feladat: Áltagos idő: " +osszes/teljesitok.size() + " óra");

        ArrayList<Versenyzok> női = new ArrayList<>();
        for (Versenyzok sportolo : versenyzok) {
            if (sportolo.getKategória().equals("Noi") && sportolo.getTávszázalék()==100) {
                női.add(sportolo);
            }
        }
        for (Versenyzok elem : női){
            if (elem.getIdoOraban()<=minimum2.getIdoOraban()){
                minimum2 = elem;
            }
        }
        System.out.println("8.feladat: Verseny győztesei:");
        System.out.println("\tNői: " + minimum2.getVersenyző() +" (" + minimum2.getRajtszám() + ".) -  " + minimum2.getVersenyidő());
        System.out.println("\tFérfi: " + minimum.getVersenyző() +" (" + minimum.getRajtszám() + ".) -  " + minimum.getVersenyidő());
//        int teljesitoSportolokSzama = teljesitok.size();
//        int osszIdoMasodpercben = 0;
//        for (Versenyzok elem : teljesitok) {
//            String[] idoElemek = ido.split(":");
//            int ora = Integer.parseInt(idoElemek[0]);
//            int perc = Integer.parseInt(idoElemek[1]);
//            int masodperc = Integer.parseInt(idoElemek[2]);
//            int idoMasodpercben = (ora * 3600) + (perc * 60) + masodperc;
//        }

    }
}