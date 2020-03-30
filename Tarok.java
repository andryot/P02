package P02;

import java.util.Random;

public class Tarok {

    private static final int ST_KART = 54;
    private static final int STOLPCI = 8;

    private static final char pik  = '\u2660';  // ♠
    private static final char kriz = '\u2663';  // ♣
    private static final char srce = '\u2665';  // ♥
    private static final char karo = '\u2666';  // ♦

    private static char[] barve = {srce, karo, kriz, pik};
    private static int[] prazneRdece = {1, 2, 3, 4};
    private static int[] prazneCrne = {10, 9, 8, 7};
    private static String[] figure = {"Fant", "Kaval", "Dama", "Kralj"};
    private static String[] taroki = {"I", "II", "III", "IIII", "V", "VI", "VII",
            "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
            "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "SKIS"};


    private static void izpisi(String[] tabela){
        for (int i = 0; i < ST_KART; i++) {
            System.out.printf("%8s (%d)",tabela[i], vrednostKarte(tabela[i]));
            if(i % STOLPCI == STOLPCI - 1)
                System.out.println();
        }
    }
    private static String[] ustvariKarte(){
        String [] karte = new String[ST_KART];
        for (int i = 0; i < 4; i++) {
            karte[i] = srce + String.valueOf(i+1);
        }
        for (int i = 4; i < 8; i++) {
            karte[i] = srce + figure[i-4];
        }

        for (int i = 8; i < 12; i++) {
            karte[i] = karo + String.valueOf(i - 7);
        }
        for (int i = 12; i < 16; i++) {
            karte[i] = karo + figure[i-12];
        }

        for (int i = 16; i < 20; i++) {
            karte[i] = String.valueOf(kriz) + prazneCrne[i-16];
        }
        for (int i = 20; i < 24; i++) {
            karte[i] = kriz + figure[i-20];
        }

        for (int i = 24; i < 28; i++) {
            karte[i] = String.valueOf(pik) + prazneCrne[i-24];
        }
        for (int i = 28; i < 32; i++) {
            karte[i] = pik + figure[i-28];
        }
        for (int i = 32; i < ST_KART; i++)
            karte[i] = taroki[i - 32];
        return karte;
    }


    private static void premesajKarte(String[] kupcek, int stevilo){
        Random rand = new Random();

        for (int i = 0; i < stevilo; i++) {
            int x = rand.nextInt(ST_KART);
            int y = rand.nextInt(ST_KART);
            if (x != y){
                String  pom = kupcek[x];
                kupcek[x] = kupcek[y];
                kupcek[y] = pom;
            }
        }
    }


    private static int vrednostKarte(String karta){
        if(karta == "SKIS" || karta == "I" || karta == "XXI")
            return 5;
        else if(karta.endsWith("Fant"))
            return 2;
        else if(karta.endsWith("Kaval"))
            return 3;
        else if(karta.endsWith("Dama"))
            return 4;
        else if(karta.endsWith("Kralj"))
            return 5;
        else
            return 1;
    }


    private static int preprostoStetje(String [] kupcek){
        int sum = 0;
        for (String karta : kupcek)
            sum += vrednostKarte(karta);
        return sum;
    }


    private static int natancnoStetje(String [] kupcek, int start, int end, boolean trojka){
        int sum = 0;
        for (int i = start; i < end; i +=3) {
            if (i < end - 3) {
                int pom = ((vrednostKarte(kupcek[i]) + vrednostKarte(kupcek[i + 1]) + vrednostKarte(kupcek[i + 2]) - 2));
                sum += pom;
                if (trojka)
                    System.out.printf("Trojka: %7s  %7s  %7s  #  %d\n", kupcek[i], kupcek[i+1], kupcek[i+2], pom);
            }
            else if (i < end - 2) {
                int pom = ((vrednostKarte(kupcek[i]) + vrednostKarte(kupcek[i + 1]) - 1));
                sum += pom;
                if (trojka)
                System.out.printf("Trojka: %7s  %7s        -  #  %d\n", kupcek[i], kupcek[i+1], pom);

            }
            else {
                int pom = vrednostKarte(kupcek[i]) - 1;
                sum += pom;
                if (trojka)
                System.out.printf("Trojka: %7s        -        -  #  %d\n", kupcek[i], pom);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        String[] kupcek0 = ustvariKarte();
        premesajKarte(kupcek0, 500);
        izpisi(kupcek0);
        System.out.println("");
        System.out.println(vrednostKarte("♥Kralj"));
        System.out.println("");
        System.out.printf("Skupna vrednost kart (preprosto stetje): %d \n", preprostoStetje(kupcek0));

        String[] kupcek = ustvariKarte();
        premesajKarte(kupcek, 500);
        int meja = 25;
        System.out.println("Prvi kup kart:");
        int kupcek1 = natancnoStetje(kupcek, 0, meja, true);
        System.out.printf("Natancno stetje 1. kupa kart: %d\n", kupcek1);
        System.out.println();
        System.out.println("Drugi kup kart:");
        int kupcek2 = natancnoStetje(kupcek, meja, ST_KART, true);
        System.out.printf("Natancno stetje 2. kupa kart: %d\n", kupcek2);
        System.out.printf("\nSkupaj oba kupa kart: %d\n", kupcek1 + kupcek2);
    }
}
