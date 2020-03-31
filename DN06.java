package P02;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Random;

public class DN06 {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            Random rd = new Random();
            int x = rd.nextInt(200) - 100;
            int y = rd.nextInt(200) - 100;
            int velikost = rd.nextInt(30) + 8;
            korona(x, y, velikost);
        }
    }
    static void korona(double x, double y, double velikost){
        StdDraw.setScale(-100, 100);
        Random rd = new Random();
        StdDraw.setPenRadius(0.01);

        for (float i = 0; i < velikost; i++) {
            StdDraw.setPenColor(255,60 + (int)(i*3), 60 + (int)(i*3));
            StdDraw.circle(x,y,i);

        }
        StdDraw.setPenRadius(velikost/10000);
        for (float j =(float) (velikost * 0.15);  j < velikost ; j++) {
            if(j % 2 < 1.8){
                int kot = rd.nextInt(360);
                int rand = rd.nextInt((int)(velikost * 0.25));
                StdDraw.setPenColor(0,0,0);
                double x1 = (j + (velikost * 0.6 - rand)) * Math.sin(2 * Math.PI * kot / 360) + x;
                double y1 = (j + (velikost * 0.6 - rand)) * Math.cos(2 * Math.PI * kot / 360) + y;

                StdDraw.line(j  * Math.sin(2 * Math.PI * kot / 360) + x, j  * Math.cos(2 * Math.PI * kot / 360) + y, x1, y1);
                StdDraw.setPenColor(220,220,220);
                StdDraw.filledCircle(x1, y1, velikost/15);
            }
        }

    }
}
