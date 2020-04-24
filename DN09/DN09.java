package P02.DN09;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class DN09 {
    static Human [] humans;
    static Color backgroundColor, cleanNoSymptomsColor, cleanSymptomsColor, infectedNoSymptomsColor, infectedSymptomsColor;
    static int neighborhoodRadius = 1;
    static int steps;
    static float probabilityInfection, probabilityTrueSymptoms, probabilityFakeSymptoms;
    static String prefix;
    static int viewX1, viewX2, viewY1, viewY2;

    public static void main(String[] args) {
        if(args.length == 1){
            File file = new File(args[0]);
            try {
                Scanner scanner = new Scanner(file);
                String line;
                while (scanner.hasNextLine()){
                    line = scanner.nextLine();
                    String[] array = line.split(" ");
                    switch (array[0]){
                        case "numberOfHumans":
                            humans = new Human[Integer.parseInt(array[1])];
                            break;
                        case "human":
                            human(array);
                            break;
                        case "random":
                            randomHumans(Integer.parseInt(array[1]),Integer.parseInt(array[4]),Integer.parseInt(array[5]),Integer.parseInt(array[7]),Integer.parseInt(array[8]));
                            break;
                        case "neighborhoodRadius":
                            neighborhoodRadius = Integer.parseInt(array[1]);
                            break;
                        case "steps":
                            steps = Integer.parseInt(array[1]);
                            break;
                        case "probabilityInfection":
                            probabilityInfection = Float.parseFloat(array[1]);
                            break;
                        case "probabilityTrueSymptoms":
                            probabilityTrueSymptoms = Float.parseFloat(array[1]);
                            break;
                        case "probabilityFakeSymptoms":
                            probabilityFakeSymptoms = Float.parseFloat(array[1]);
                            break;
                        case "view":
                            viewX1 = Integer.parseInt(array[2]);
                            viewY1 = Integer.parseInt(array[3]);
                            viewX2 = Integer.parseInt(array[5]);
                            viewY2 = Integer.parseInt(array[6]);
                            break;
                        case "outputPrefix":
                            prefix = array[1];
                            break;
                        case "color":
                            colors(array);
                            break;
                    }
                }

                // main loop with n steps
                PPMWriter ppmWriter = new PPMWriter();
                for (int i = 0; i < steps; i++) {



                //ppmWriter.write(prefix + String.valueOf(i), );
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    // colors
    private static void colors(String[] array) {
        switch (array[1]){
            case "background":
                backgroundColor = new Color(Integer.parseInt(array[2]), Integer.parseInt(array[3]),Integer.parseInt(array[4]));
                break;
            case "cleanNoSymptoms":
                cleanNoSymptomsColor = new Color(Integer.parseInt(array[2]), Integer.parseInt(array[3]),Integer.parseInt(array[4]));
                break;
            case "cleanSymptoms":
                cleanSymptomsColor = new Color(Integer.parseInt(array[2]), Integer.parseInt(array[3]),Integer.parseInt(array[4]));
                break;
            case "infectedNoSymptoms":
                infectedNoSymptomsColor = new Color(Integer.parseInt(array[2]), Integer.parseInt(array[3]),Integer.parseInt(array[4]));
                break;
            case "infectedSymptoms":
                infectedSymptomsColor = new Color(Integer.parseInt(array[2]), Integer.parseInt(array[3]),Integer.parseInt(array[4]));
                break;
        }
    }
    // foreach through array of humans to set infections and symptoms of humans on specific location
    private static void human(String[] array) {
        boolean isInfected = array[3] != null;
        boolean hasSymptoms = array[4] != null;
        for(Human human : humans){

            if(human.position.x == Integer.parseInt(array[1]) && human.position.y == Integer.parseInt(array[2])){
                human.hasSymptoms = hasSymptoms;
                human.isInfected = isInfected;
            }

        }
    }
    // n random humans from [x1, y1] to [x2, y2]
    static void randomHumans(int number, int x1, int y1, int x2, int y2){
        Random randomX = new Random();
        Random randomY = new Random();
        for (int i = 0; i < number; i++) {
            humans[i].position = new Position(randomX.nextInt((Math.abs(x1)+x2)) + x2, randomY.nextInt((Math.abs(y1)+y2)) + y2);
        }
    }

}
