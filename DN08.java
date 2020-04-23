

import java.io.File;
import java.util.Random;
import java.util.Scanner;

class Stevilo {
    double absolutnaVrednost(){
        return 0;
    }
}

/**
 * @author ...
 **/
public class DN08 {
    static final int MAX_STEVIL = 100;

    static Stevilo [] preberiStevila(String imeDatoteke) throws Exception {
        Stevilo [] stevila = new Stevilo[MAX_STEVIL];
        File file = new File(imeDatoteke);

        Scanner sc = new Scanner(file);
        int ct = 0;
        while(sc.hasNextLine()){
            String s = sc.nextLine();
           String [] x = s.split(" ");
           switch (x[0]){
               case "Z":
                   stevila[ct] = new CeloStevilo(Integer.parseInt(x[1]));
                   break;
               case "Q":
                   stevila[ct] = new RacionalnoStevilo(Integer.parseInt(x[1]),Integer.parseInt(x[2]));
                   break;
               case "C":
                   stevila[ct] = new KompleksnoStevilo(Integer.parseInt(x[1]),Integer.parseInt(x[2]));
                   break;
           }
           ct++;
        }


        return stevila;
    }

    public static void main(String[] args) throws Exception {
        Stevilo [] stevila = preberiStevila(args[0]);

        for (int i = 0; i < MAX_STEVIL; i++) {
            if (stevila[i] == null) continue;

            System.out.printf("Absolutna vrednost stevila %s je %.2f\n",
                    stevila[i].toString(), stevila[i].absolutnaVrednost());

        }
    }
}

class CeloStevilo extends Stevilo {
    private int n;
    CeloStevilo(int n){this.n=n;}
    @Override
    public double absolutnaVrednost(){
        if( this.n > 0) return this.n; return (double) this.n * -1;
    }
    @Override
    public String toString(){
        return String.valueOf(n);
    }

}
class RacionalnoStevilo extends Stevilo {
    private int p;
    private int q;
    RacionalnoStevilo(int p, int q){this.p = p; this.q = q;}

    @Override
    public double absolutnaVrednost(){
        double x = (double) this.p / this.q;
       if(x < 0) return x * -1;
       return x;
    }
    @Override
    public String toString(){
        return (p > 0 ? " ": "") + p + " / " + q;
    }
}
class KompleksnoStevilo extends Stevilo {
    private int re;
    private int im;
    KompleksnoStevilo(int re, int im){this.re = re; this.im = im;}
    @Override
    public double absolutnaVrednost(){
        return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
    }
    @Override
    public String toString(){
        return  + re + (im > 0 ? " + ": " - ") +  Math.abs(im) + " i";
    }
}