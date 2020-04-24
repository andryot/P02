package P02.DN09;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PPMWriter {

    public void write(String filename, int[][][] pixels, int width, int height) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filename);

        out.println("P3");
        out.println(width + " " + height);
        out.println(255);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int[] color = pixels[x][y];
                out.println(color[0] + " " + color[1] + " " + color[2]);
            }
        }
        out.close();
    }

}
