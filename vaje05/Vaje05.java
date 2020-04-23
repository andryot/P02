package P02.vaje05;

import java.util.Scanner;

public class Vaje05 {

    public static void main (String[] args){
        System.out.println("h: pomoc, q: izhod");
        Scanner sc = new Scanner(System.in);
        String userInput;
        loop: while (true){
            userInput = sc.nextLine();
            switch (userInput){
                case "q":
                    break loop;
                case "h":
                    izpisiNavodila();
                    break;
                case "1":
                    System.out.println("Vnesi dolžino seznama: ");
                    Seznam.narediSeznam(sc.nextInt());
                    break;
                case "2":
                    System.out.println("Zapiši element: ");
                    Seznam.dodajNaSeznam(sc.nextLine());
                    break;
                case "3":
                    System.out.println("Odstrani element: ");
                    Seznam.odstraniIzSeznama(sc.nextInt());
                    break;
                case "4":
                    Seznam.izpisiSeznam();
                    break;
                case "5":
                    Seznam.izpisiSeznam64Bit();
                    break;
            }
        }
    }

    public static void izpisiNavodila(){
        System.out.println("Navodila:\n1: naredi seznam, 2: dodaj element, 3: odstrani element, 4: izpiši seznam, 5: izpiši 64 bitno, q: izhod, h: pomoč");
    }
}


class Seznam {
    private static String[] seznam;
    private static int dolzina = 0;

    public static void narediSeznam(int n){
        if (seznam == null)
            seznam = new String[n];
        else if (seznam.length == n)
            System.out.printf("Seznam z dolžino %d je že narejen\n", seznam.length);
        else
            seznam = new String[n];

    }

    public static void dodajNaSeznam(String element){
        if (seznam == null)
            System.out.println("Seznam še ni narejen.");
        else if (seznam[seznam.length - 1] != null)
            System.out.println("Seznam je poln. Element ni bil dodan");
        else {
           seznam[dolzina] = element;
           dolzina++;
        }


    }

    public static void odstraniIzSeznama(int mesto){
        if (seznam == null)
            System.out.println("Seznam še ni narejen.");
        else if (seznam[mesto - 1] == null)
            System.out.printf("\nNa mestu %d ni elementa", mesto);
        else if (mesto <= seznam.length) {
            String izbrisani = seznam[mesto-1];
            int i = mesto - 1;
            while (i < seznam.length - 1 && seznam[i] != null) {
                seznam[i] = seznam[i + 1];
                i++;
            }
            seznam[i] = null;
            dolzina--;
            System.out.printf("\nIzbrisan element na mestu %d: %s.", mesto,izbrisani);
        }
    }

    public static void izpisiSeznam(){
        if (seznam == null)
            System.out.println("Na seznamu ni elemntov.");
        else {
            System.out.println("Na seznamu so sledeči elementi:\n");
            for (int i = 0; i < dolzina; i++) {
                if (seznam[i] == null)
                    break;
                System.out.printf("\n%d: %s\n",i+1, seznam[i]);
            }
        }
    }

    public static void izpisiSeznam64Bit(){
        if (seznam == null)
            System.out.println("Na seznamu ni elemntov.");
        else {
            System.out.println("Na seznamu so sledeči elementi:\n");
            for (int i = 0; i < dolzina; i++) {
                if (seznam[i] == null)
                    break;
                P02.vaje03.Vaje03.izpisiNiz64bit(i+1 +" " + seznam[i]);
                System.out.println();
            }
        }
    }
}