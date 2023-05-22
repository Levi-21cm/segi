package hu.katolikuskeri.cli;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<NapiBevetel> versenyzok;
        versenyzok =NapiBevetel.beolvas("Selejtezo2012.txt");

        System.out.println("5.feladat: Versenyzők száma a selejtezőben: " + versenyzok.size() +" fő");

        int tovabbjutott=0;
        ArrayList<NapiBevetel> legjobb = new ArrayList<>();
        for (NapiBevetel elem: versenyzok){
            if ((elem.getD1()>78)||(elem.getD2()>78)){
                tovabbjutott++;
            }
        }
        System.out.println("6.feladat: 78,00 méter feletti eredménnyel tovább jutott: " + tovabbjutott + " fő");
        int legnagyobbindex = 0;
        Double legnagyobbdobas = 0.0;
        for (int i =0; i<versenyzok.size();i++){
            NapiBevetel napiBevetel = versenyzok.get(i);
            if (napiBevetel.getD1()>legnagyobbdobas ){
                legnagyobbdobas= napiBevetel.getD1();
                legnagyobbindex= i;
            }
            else if(napiBevetel.getD2()>legnagyobbdobas){
                legnagyobbdobas= napiBevetel.getD2();
                legnagyobbindex= i;
            }
            else if(napiBevetel.getD3()>legnagyobbdobas){
                legnagyobbdobas= napiBevetel.getD3();
                legnagyobbindex= i;
            }
        }
        System.out.println("9.feladat: A selejtező nyertese: ");
        for (int i =0; i<versenyzok.size();i++){
            NapiBevetel napiBevetel = versenyzok.get(i);
            if (i == legnagyobbindex){
                System.out.println("Név: " + napiBevetel.getNév());
                System.out.println("Csoport: " + napiBevetel.getCsoport());
                System.out.println("Nemzet: " +napiBevetel.getNemzet());
                System.out.println("Nemzet kód: " + napiBevetel.getKod());
                if ((napiBevetel.getD1()==-1.0) ||(napiBevetel.getD1()==-2.0) ){
                    System.out.printf("Sorozat: -;%.2f;%.2f",napiBevetel.getD2(),napiBevetel.getD3());
                    System.out.println("\nEredmény: "+ (napiBevetel.getD2()+napiBevetel.getD3())/2);
                }
                else if ((napiBevetel.getD2()==-1.0 )||(napiBevetel.getD2()==-2.0) ){
                    System.out.printf("Sorozat: %.2f;-;%.2f",napiBevetel.getD1(),napiBevetel.getD3());
                    System.out.println("\nEredmény: "+ (napiBevetel.getD1()+napiBevetel.getD3())/2);
                }
                else if ((napiBevetel.getD3()==-1.0) ||(napiBevetel.getD3()==-2.0)  ){
                    System.out.printf("Sorozat: %.2f;%.2f;-",napiBevetel.getD1(),napiBevetel.getD2());
                    System.out.println("\nEredmény: "+ (napiBevetel.getD2()+napiBevetel.getD1())/2);
                }
                else if (((napiBevetel.getD1()==-1.0) ||(napiBevetel.getD1()==-2.0) )&&((napiBevetel.getD2()==-1.0) ||(napiBevetel.getD2()==-2.0) )){
                    System.out.printf("Sorozat: -;-;%.2f",napiBevetel.getD3());
                    System.out.println("\nEredmény: "+ napiBevetel.getD3());
                }
                else if (((napiBevetel.getD1()==-1.0) ||(napiBevetel.getD1()==-2.0) )&&((napiBevetel.getD3()==-1.0) ||(napiBevetel.getD3()==-2.0) )){
                    System.out.printf("Sorozat: -;%.2f;-",napiBevetel.getD2());
                    System.out.println("\nEredmény: "+ napiBevetel.getD2());
                }
                else if (((napiBevetel.getD2()==-1.0) ||(napiBevetel.getD2()==-2.0) )&&((napiBevetel.getD3()==-1.0) ||(napiBevetel.getD3()==-2.0) )){
                    System.out.printf("Sorozat: %.2f;-;-",napiBevetel.getD1());
                    System.out.println("\nEredmény: "+ napiBevetel.getD1());
                }
                else {
                    System.out.printf("Sorozat: -;-;-");
                    System.out.println("\nEredmény: -");
                }

            }
        }
    }

}