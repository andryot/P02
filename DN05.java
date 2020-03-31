import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class DN05 {


    public static void main(String[] args) {
        if(args.length == 2) { // 1. del
            izrisiLabirint(preberiLabirint(args[0]));
            System.out.print(preveriResitev(preberiLabirint(args[0]),
                    preberiResitev(args[1])) ? "\nPravilna resitev!\n" : "\nNepravilna resitev!\n");
        }
        else if(args.length == 3){ // 2. del naloge
            narediLabirint(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        }
        else if(args.length == 1){ // 3. del naloge
            int [] solution = poisciResitev(preberiLabirint(args[0]));
            for (int i = 0; i < solution.length; i++) {
                System.out.print(solution[i]);
            }
            shraniResitev(solution, args[0]);
        }
    }


    public static int[][] preberiLabirint(String ime){
        File file = new File(ime);
        try {
            Scanner sc = new Scanner(file);
            ime = ime.replace(".txt", "");
            String[] temp = ime.split("_");

            int width =  2 * Integer.parseInt(temp[temp.length - 2]) - 1 ;
            int height = 2 * Integer.parseInt(temp[temp.length - 1]) - 1;

            int[][] table = new int[height][width];

            for (int i = 0; i < height; i++)
                for (int j = 0; j < width ; j++)
                    table[i][j] = sc.nextInt();
            return table;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File ni najden");
            return new int[0][0];
        }
    }

    public static void izrisiLabirint(int[][] labirint){
        System.out.print(new String(new char[labirint[0].length + 2]).replace("\0", "# ") + "\n");
        for (int[] row : labirint) { //foreach v Javi
            System.out.print("# ");
            for (int i : row)
                System.out.print(i == 1 ? "  " : "# ");
            System.out.print("# \n");
        }
        System.out.print(new String(new char[labirint[0].length]).replace("\0", "# ") + "  # ");
    }


    public static int[] preberiResitev(String ime){
       File file = new File(ime);
       try {
           Scanner sc = new Scanner(file);
           int ct = 0;
           while (sc.hasNextInt()){
               sc.nextInt();
               ct++;
           }
           int[] table = new int[ct];
           ct = 0;
           sc.close();
           sc = new Scanner(file);
           while (sc.hasNextInt()){
               table[ct] = sc.nextInt();
               ct++;
           }
           return table;

       } catch (FileNotFoundException e) {
           e.printStackTrace();
           System.out.println("File ni najden");
           return new int[0];
       }
    }


    public static boolean preveriResitev(int[][] labirint, int[] resitev){
        int x = 0, y = 0;
        for (int value : resitev) {
            switch (value) {
                case 2: //ostani na mestu
                    break;
                case 3: // levo
                    x--;
                    break;
                case 4: // desno
                    x++;
                    break;
                case 5: // gor
                    y--;
                    break;
                case 6: // dol
                    y++;
                    break;
            }

            // od kdaj je prvi argument pri tabeli (20x10) širina?? 30 minut izgubljenih z iskajem napake nepotrebno...
            if ((x < 0 || x > labirint[0].length - 1) || (y < 0 || y > labirint.length - 1) || labirint[y][x] == 0)
                return false;
        }
        return x == labirint[0].length - 1 && y == labirint.length - 1;
    }

    static int [][] table;
    //nedokončano
    public static int[][] narediLabirint(int sirina, int visina, double verjetnost){
        table = new int[visina][sirina];
        for (int i = 0; i < visina; i++)
            for (int j = 0; j < sirina; j++)
                table[i][j] = 1;

            Random rand = new Random();

            int y = rand.nextInt(visina);
            while (y % 2 == 0)
                y = rand.nextInt(visina);

            int x = rand.nextInt(sirina);
            while (x % 2 == 0)
                x = rand.nextInt(sirina);

            for (int j = 0; j < sirina; j++) {
                table[y][j] = 0;
            }
            for (int j = 0; j < visina; j++) {
                table[j][x] = 0;
            }

        izrisiLabirint(table);
        return table;
    }


    public static int[] poisciResitev(int[][] maze) {
        boolean[][] wasHere = new boolean[maze.length][maze[0].length];

        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[i].length; j++){
                wasHere[i][j] = false;
            }
        recursiveSolve(0, 0, maze, wasHere);

        solutionForSaving = new int[solution.length()];

        for (int i = 0; i < solution.length(); i++) {
            solutionForSaving[i] = Integer.parseInt(String.valueOf(solution.charAt(i)));
        }
        return solutionForSaving;
    }

    static StringBuffer solution = new StringBuffer("");
    static int [] solutionForSaving = new int[solution.length()];

    public static boolean recursiveSolve(int x, int y, int[][] maze, boolean[][] wasHere) {
        if (x == maze.length - 1 && y == maze[0].length - 1)
            return true;
        if (maze[x][y] == 0 || wasHere[x][y])
            return false;

        wasHere[x][y] = true;

        if (x != 0)
            if (recursiveSolve(x-1, y, maze, wasHere)) {
                solution.insert(0, "5");
                return true;
            }
        if (x != maze.length - 1)
            if (recursiveSolve(x+1, y, maze, wasHere)) {
                solution.insert(0, "6");
                return true;
            }
        if (y != 0)
            if (recursiveSolve(x, y-1, maze, wasHere)) {
                solution.insert(0, "3");
                return true;
            }
        if (y != maze[0].length - 1)
            if (recursiveSolve(x, y+1, maze, wasHere)) {
                solution.insert(0, "4");
                return true;
            }
        return false;

    }


    public static void shraniResitev(int[] resitev, String ime){
        try {
            Writer wrt = new FileWriter("resitev-" + ime);
            for(int i : resitev){
                wrt.write(i);
                wrt.write(" ");
            }
            wrt.flush();
            wrt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
