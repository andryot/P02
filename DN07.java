package P02;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DN07 {
    public static void main(String[] args) {
        if(args.length != 0){
            int ct = 0;
            for (String c : args[0].split(",")){
                ct ++;
            }
            int [] t = new int[ct];
            int i = 0;
            for (String c : args[0].split(",")) {
                if (i < ct) {
                    t[i] = Integer.parseInt(c);
                    i++;
                }
            }
            narisiStolpce(t);
        }
        else
        narisiStolpce(new int[] {10,5,8,4,12,7,4});
    }
    static void narisiStolpce(int[] visine){
        StdDraw.setScale(0, 100);
        StdDraw.setPenRadius(0.01);

        StdDraw.rectangle(50,50,50,50);
        float sirina = (float) 100 / (visine.length + 1);

        float razmak = sirina / (visine.length + 1);
        float x = razmak;
        float najvisji = 0;

        for (int i : visine) {
            if(i > najvisji)
                najvisji = i;
        }

        float [] praveVisine = new float[visine.length];
        for (int i = 0; i < visine.length; i++)
            praveVisine[i] = 95 * visine[i] / najvisji;

        for (int i = 0; i < visine.length; i++) {
            if(i % 3 == 0)
                StdDraw.setPenColor(StdDraw.RED);
            else if(i % 3 == 1)
                StdDraw.setPenColor(StdDraw.GREEN);
            else
                StdDraw.setPenColor(StdDraw.BLUE);

            StdDraw.filledRectangle(x+sirina/2, praveVisine[i] / 2, sirina/2, praveVisine[i] / 2);
            x += razmak + sirina;
        }
    }
}
