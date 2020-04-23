package P02.vaje06;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.Random;

public class Vaje06 {
    public static void main(String[] args) {

        Igra.zacni();
        Igra.izpisiTabelo();
        while (Igra.igraj()) {
            Igra.naslednjaPoteza();
        }
    }
}


class Igra {
    private static Random random = new Random();

    /* Mreza */
    private static final int STRANICA_KVADRATA = 10;
    private static final int DEBELINA_ROBA = 2;

    /* IGRALNA POVRŠINA */
    private static final int VELIKOST = 4 * STRANICA_KVADRATA + 5 * DEBELINA_ROBA;
    private static final int HEADER = 10;

    /* BARVE */
    private static Color BARVA_0 = Color.decode("#c1b2ab");
    private static Color BARVA_2 = Color.decode("#d66853");
    private static Color BARVA_4 = Color.decode("#7d4e57");
    private static Color BARVA_8 = Color.decode("#7e8d85");
    private static Color BARVA_16 = Color.decode("#9dbebb");
    private static Color BARVA_32 = Color.decode("#757083");
    private static Color BARVA_64 = Color.decode("#aec3b0");
    private static Color BARVA_128 = Color.decode("#9b7e46");
    private static Color BARVA_256 = Color.decode("#8896ab");
    private static Color BARVA_512 = Color.decode("#646e68");
    private static Color BARVA_1024 = Color.decode("#ffb30f");
    private static Color BARVA_2048 = Color.decode("#849324");

    /* PISAVE */
    private static Font FONT_1 = new Font("Arial", Font.BOLD, 60);
    private static Font FONT_2 = new Font("Arial", Font.BOLD, 40);
    private static Font FONT_3 = new Font("Arial", Font.BOLD, 20);
    private static Font FONT_SCORE = new Font("Arial", Font.BOLD, 30);


    /* KODE SMERNIH TIPK */
    private static final int ESC_BUTTON = 27;
    private static final int LEFT_BUTTON = 37;
    private static final int UP_BUTTON = 38;
    private static final int RIGHT_BUTTON = 39;
    private static final int DOWN_BUTTON = 40;

    /* CASOVNE KONSTANTE */
    private static final int PAUSE = 10;
    private static final int PAUSE_LONG = 100;

    /*PARAMETRI IGRE*/
    private static boolean soPraznaPolja = true;
    private static int[][] polja = new int[4][4];

    /* TOCKE */
    private static int tocke = 0;

    /**
     * Vrne true ce je se kaksno polje prazno.
     * V nasprotnem primeru izrise konec in vrne false.
     * @return
     */
    public static boolean igraj(){
        for (int[] i : polja) {
            for (int j : i)
                if (j == 0)
                    return true;
        }
        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(25, 25, 15, 5);
        StdDraw.setFont(FONT_2);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(25,24,"KONEC");
        StdDraw.show();
        StdDraw.pause(20000);
        return false;
    }

    /**
     * Pogleda če je bila pritisnjena katera izmed tipk, ustrezno premakne števila
     * in doda novo stevilo. Poveča točke, če se kakšna števila združijo.
     */
    public static void naslednjaPoteza(){
       if(StdDraw.isKeyPressed(ESC_BUTTON)){
            soPraznaPolja = false;
            System.exit(0);
       }
       else if(StdDraw.isKeyPressed(LEFT_BUTTON)){
           premakniLevo();
           StdDraw.pause(PAUSE_LONG*3);
       }
       else if(StdDraw.isKeyPressed(UP_BUTTON)){
           premakniGor();
           StdDraw.pause(PAUSE_LONG*3);
       }
       else if(StdDraw.isKeyPressed(RIGHT_BUTTON)){
           premakniDesno();
           StdDraw.pause(PAUSE_LONG*3);
       }
       else if(StdDraw.isKeyPressed(DOWN_BUTTON)){
           premakniDol();
           StdDraw.pause(PAUSE_LONG*3);
       }

    }

    /**
     * Premakne stevila dol. Pomožna metoda za metodo void naslednjaPoteza().
     * @return
     * Vrne true če se je tabela polja pri premiku spremenila drugače false.
     */
    static void premakniDol(){
        sortDol();
        if(sortDol()) {
            for (int i = 3; i > 0; i--) {
                for (int j = 0; j < 4; j++) {
                    if (polja[i][j] == polja[i - 1][j]) {
                        polja[i][j] *= 2;
                        polja[i - 1][j] = 0;
                        tocke += polja[i][j];
                    }
                }
            }
            sortDol();
            dodajStevilo();
            izpisiTabelo();
        }
    }
    static boolean sortDol(){
        boolean change = false;
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < 4; j++) {
                int ct = 1;
                while(polja[i][j] == 0 && ct <= i ) {
                    change = true;
                    polja[i][j] = polja[i - ct][j];
                    polja[i - ct][j] = 0;
                    ct++;
                }
            }
        }
        return change;
    }
    /**
     * Premakne stevila gor. Pomožna metoda za metodo void naslednjaPoteza().
     * @return
     * Vrne true če se je tabela polja pri premiku spremenila drugače false.
     */
    static void premakniGor(){
        if(sortGor()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (polja[i][j] == polja[i + 1][j]) {
                        polja[i][j] *= 2;
                        polja[i + 1][j] = 0;
                        tocke += polja[i][j];
                    }
                }
            }
            sortGor();
            dodajStevilo();
            izpisiTabelo();
        }
    }
    static boolean sortGor(){
      boolean change = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                int ct = 1;
                while(polja[i][j] == 0 && ct < 4 - i) {
                    change = true;
                    polja[i][j] = polja[i+ct][j];
                    polja[i+ct][j] = 0;
                    ct++;
                }
            }
        }
        return change;
    }

    /**
     * Premakne stevila levo. Pomožna metoda za metodo void naslednjaPoteza().
     * @return
     * Vrne true če se je tabela polja pri premiku spremenila drugače false.
     */
    static void premakniLevo(){
        boolean change = false;
        if(sortLevo()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (polja[i][j] == polja[i][j + 1]) {
                        polja[i][j] *= 2;
                        tocke += polja[i][j];
                        polja[i][j + 1] = 0;
                    }
                }
            }
            sortLevo();
            dodajStevilo();
            izpisiTabelo();
        }
    }
    static boolean sortLevo(){
        boolean change = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                int ct = 1;
                while(polja[i][j] == 0 && ct < 4 - j) {
                    change = true;
                    polja[i][j] = polja[i][j+ct];
                    polja[i][j+ct] = 0;
                    ct++;
                }
            }
        }
        return change;
    }

    /**
     * Premakne stevila desno. Pomožna metoda za metodo void naslednjaPoteza().
     * @return
     * Vrne true če se je tabela polja pri premiku spremenila drugače false.
     */
    static void premakniDesno(){
        if(sortDesno()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 3; j > 0; j--) {
                    if (polja[i][j] == polja[i][j - 1]) {
                        polja[i][j] *= 2;
                        tocke += polja[i][j];
                        polja[i][j - 1] = 0;
                    }
                }
            }
            sortDesno();
            dodajStevilo();
            izpisiTabelo();
        }
    }
    static boolean sortDesno(){
        boolean change = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                int ct = 1;
                while(polja[i][j] == 0 && ct <=  j) {
                    polja[i][j] = polja[i][j - ct];
                    change = true;
                    polja[i][j - ct] = 0;
                    ct++;
                }
            }
        }
        return change;
    }

    /**
     * Preveri ce je kaksno polje prazno. Ce ni postavi soPraznaPolja = false
     * Vrne tabelo praznih polj. Pomožna metoda za void dodajStevilo().
     * @return
     */
    static int[] preveriPraznaPolja(){
        int prazna [] = new int[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(polja[i][j] == 0)
                    prazna[i*4+j] = 1;
            }
        }
        if (prazna[0] == 0)
            soPraznaPolja = false;
        return prazna;
    }

    /**
     * Doda 2 na nakljucno prazno mesto v tabeli.
     * Če ni prostih mest postavi soPraznaPolja na false.
     */
    static void dodajStevilo(){
        int [] prazna = preveriPraznaPolja();
        if(igraj()) {
            int x = random.nextInt(16);
            while (prazna[x] != 1)
                x = random.nextInt(16);
            polja[x/4][x%4] = 2;
        }
    }

    /**
     * Inicializira parametre igre.
     */
    public static void zacni(){
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, VELIKOST);
        StdDraw.setYscale(0, VELIKOST + HEADER);

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                polja[i][j] = 0;
        dodajStevilo();
        dodajStevilo();
    }

    /**
     * Izrise tabelo
     */
    public static void izpisiTabelo(){
        StdDraw.clear();
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(FONT_SCORE);
        StdDraw.text(25,55, String.valueOf(tocke));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                StdDraw.setFont(FONT_1);
                switch (polja[i][j]){
                    case 0:
                        StdDraw.setPenColor(BARVA_0);
                        break;
                    case 2:
                        StdDraw.setPenColor(BARVA_2);
                        break;
                    case 4:
                        StdDraw.setPenColor(BARVA_4);
                        break;
                    case 8:
                        StdDraw.setPenColor(BARVA_8);
                        break;
                    case 16:
                        StdDraw.setPenColor(BARVA_16);
                        break;
                    case 32:
                        StdDraw.setPenColor(BARVA_32);
                        break;
                    case 64:
                        StdDraw.setPenColor(BARVA_64);
                        break;
                    case 128:
                        StdDraw.setPenColor(BARVA_128);
                        StdDraw.setFont(FONT_2);
                        break;
                    case 256:
                        StdDraw.setPenColor(BARVA_256);
                        StdDraw.setFont(FONT_2);
                        break;
                    case 512:
                        StdDraw.setPenColor(BARVA_512);
                        StdDraw.setFont(FONT_2);
                        break;
                    case 1024:
                        StdDraw.setPenColor(BARVA_1024);
                        StdDraw.setFont(FONT_3);
                        break;
                    case 2048:
                        StdDraw.setPenColor(BARVA_2048);
                        StdDraw.setFont(FONT_3);
                        break;
                }
                int x = DEBELINA_ROBA+5 + j*STRANICA_KVADRATA + DEBELINA_ROBA*j;
                int y = VELIKOST - (DEBELINA_ROBA+5) - i*STRANICA_KVADRATA - DEBELINA_ROBA*i;
                StdDraw.filledRectangle(x,y,5,5);
                if(polja[i][j] != 0) {
                    StdDraw.setPenColor(Color.white);
                    StdDraw.text(x, y-1, String.valueOf(polja[i][j]));
                }
            }
        }
        StdDraw.show();

    }
}