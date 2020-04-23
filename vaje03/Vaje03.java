package P02.vaje03;

public class Vaje03 {
    private static final char znak = '\u2B1B'; // Square character ⬛
    private static final char blank = '\u2B1C'; // Empty Square character ⬜
    private static final char[] abeceda = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' '};
    private static final short[] abeceda16bit = {
            (short)0b1001111110011111, // a
            (short)0b0101101101010011, // b
            (short)0b1111000100011111, // c
            (short)0b0111100110010111, // d
            (short)0b1111000101111111, // e
            (short)0b0001011100011111, // f
            (short)0b1111100100011111, // g
            (short)0b1001111110011001, // h
            (short)0b1111001000101111, // i
            (short)0b1111100110001111, // j
            (short)0b1001010100111101, // k
            (short)0b1111000100010001, // l
            (short)0b1001100111011111, // m
            (short)0b1001100111011011, // n
            (short)0b1111100110011111, // o
            (short)0b0001111110011111, // p
            (short)0b1111110110011111, // q
            (short)0b0101111110011111, // r
            (short)0b1110111100011111, // s
            (short)0b0010001000101111, // t
            (short)0b1111100110011001, // u
            (short)0b0110100110011001, // v
            (short)0b1111110110011001, // w
            (short)0b1001011001101001, // x
            (short)0b0010111110011001, // y
            (short)0b1111001001001111, // z
            (short)0b0110100110010110, // 0
            (short)0b1111010001000110, // 1
            (short)0b1111001001000111, // 2
            (short)0b1111100011101111, // 3
            (short)0b1000111110011001, // 4
            (short)0b0110011100011111, // 5
            (short)0b1111100111110001, // 6
            (short)0b1000100010001111, // 7
            (short)0b1110101111010111, // 8
            (short)0b1000111110011111, // 9
            (short)0b0000000000000000, // space
    };
    private static final long[] abeceda64bit = {        // 45 minut vrženih stran... zakaj?
            0b1110011101000010010000100111111001000010010000100010010000011000L, // a
            0b0111111110000010100000101000001001111110001000100100001000111111L, // b
            0b0011110001000010010000001000000010000000110000001010000100111100L, // c
            0b0011111101000010100000101000001010000010100000100100001000111111L, // d
            0b1111111110000010000000100000001000001110000000101000001011111111L, // e
            0b0000011100000010000100100001111000010010100000101000001011111111L, // f
            0b0111110010000010100000011000100111111001000000011000001011111100L, // g
            0b1110011101000010010000100100001001111110010000100100001011100111L, // h
            0b1111111100001000000010000000100000001000000010000000100011111111L, // i
            0b0001111000100001001000010010001100100000001000000010000011111100L, // j
            0b1110011101000010001000100001001000001110000100100010001011110111L, // k
            0b1111111110000010100000100000001000000010000000100000001000000111L, // l
            0b1110011101000010010000100100001001001010010010100101011011100011L, // m
            0b1110011101000010010000100110001001010010010010100100011011100011L, // n
            0b0011110001000010100000011000000110000001100000010100001000111100L, // o
            0b0000011100000010000000100111111010000010100000101000001001111111L, // p
            0b0000100001111110100010011000000110000001100000011000000101111110L, // q
            0b1110011101000010001000100111111010000010100000101000001001111111L, // r
            0b0111110110000011100000010100000000111110100000011100000110111110L, // s
            0b0011100000010000000100000001000000010000000100001001000111111111L, // t
            0b0111111010000001100000011000000110000001100000011000000111100111L, // u
            0b0001000000101000001001000100010001000010010000100100001011100111L, // v
            0b0011010001001010010010100100101001000010010000100100001011100111L, // w
            0b1110011101000010001001000010010000011000001001000100001011100111L, // x
            0b0011100000010000000100000001000000101000001001000100001011100111L, // y
            0b1111111110000010100001000000100000010000001000010100000111111111L, // z
            0b0011110001000010100001011000100110010001101000010100001000111100L, // 0
            0b1111111100001000000010000000100000001000000010000000101000001100L, // 1
            0b1111111110000001100001100001100001100000100000001000000101111110L, // 2
            0b0111111010000001100000011000000001110000100000011000000101111110L, // 3
            0b1110000001000000111111110100001001000100010010000101000001100000L, // 4
            0b0111111010000001100000011000000001111111000000011000000111111111L, // 5
            0b0111111010000001100000011000000101111111000000011000000101111110L, // 6
            0b0001110000001000000010000001000000100000010000001000000111111111L, // 7
            0b0111111010000001100000011000000101111110100000011000000101111110L, // 8
            0b0111111010000001100000001111111010000001100000011000000101111110L, // 9
            0b0000000000000000000000000000000000000000000000000000000000000000L, // space
    };

    public static void main(String [] args){
        izpisZnak16bit((short)0b1001111110011111);
        System.out.print("\n\n\n");
        izpisiNiz16bit(new short[] {(short)0b0001011100011111, (short)0b0101111110011111, (short)0b1111001000101111});
        System.out.print("\n\n\n");
        izpisiNiz216bit("Java ni zakon");
        System.out.print("\n\n\n");
        izpisiZnak64bit(0b1110011101000010010000100111111001000010010000100010010000011000L);
        System.out.print("\n\n\n");
        izpisiNiz64bit(new long[] {0b0000011100000010000000100111111010000010100000101000001001111111L,
                0b1111111110000001100001100001100001100000100000001000000101111110L});
        System.out.print("\n\n\n");
        izpisiNiz64bit("Juhej");
        System.out.print("\n\n\n");
        izpisiZnak64bit(4342206308063461948L);
        System.out.print("\n\n\n");
        izpisiZnak64bit(-6521708140789089256L);
    }


    static void izpisZnak16bit(short kodaZnaka){
        String tabela = Integer.toBinaryString(kodaZnaka);
        String zeros = "";
        for (int i = 0; i < 32 - tabela.length(); i++)
            zeros += 0;
        tabela = zeros + tabela;
        for (int i = 4; i > 0; i--){
            for (int j = 4; j > 0; j--){
                System.out.print(tabela.charAt(tabela.length() / 2  + (i - 1) * 4 + j - 1) == 49  ? znak : blank);
            }
            System.out.print("\n");
        }
    }


    static void izpisiNiz16bit(short[] nizZnakov){
            String[] tabela = new String[nizZnakov.length];
            for (int k = 0; k < nizZnakov.length; k++) {
                tabela[k] = Integer.toBinaryString(nizZnakov[k]);
                String zeros = "";
                for (int i = 0; i < 32 - tabela[k].length(); i++)
                    zeros += 0;
            tabela[k] = zeros + tabela[k];
            }
            for (int i = 4; i > 0; i--) {
                for (int j = 0; j < nizZnakov.length; j++ ) {
                    for (int k = 4; k > 0; k--) {
                        System.out.print(tabela[j].charAt(tabela[j].length() / 2 + (i - 1) * 4 + k - 1) == 49 ? znak : blank);
                    }
                    System.out.print(blank);
                }
                System.out.print("\n");
            }
        }


    static void izpisiNiz216bit(String nizZnakov){
        nizZnakov = nizZnakov.toUpperCase();
        short[] niz = new short[nizZnakov.length()];
        for (int i = 0; i < nizZnakov.length(); i++){
            if(nizZnakov.charAt(i) >= 65 && nizZnakov.charAt(i) <= 90){
                niz[i] = abeceda16bit[nizZnakov.charAt(i) - 65];
            }
            else if (nizZnakov.charAt(i) > 47 && nizZnakov.charAt(i) < 58)
                niz[i] = abeceda16bit[nizZnakov.charAt(i) - 22];
            else
                niz[i] = abeceda16bit[abeceda16bit.length - 1];
        }
        izpisiNiz16bit(niz);
    }


    static void izpisiZnak64bit(long kodaZnaka){
        String tabela = Long.toBinaryString(kodaZnaka);
        String zeros = "";
        for (int i = 0; i < 64 - tabela.length(); i++)
            zeros += 0;
        tabela = zeros + tabela;
        for (int i = 8; i > 0; i--){
            for (int j = 8; j > 0; j--){
                System.out.print(tabela.charAt((i - 1) * 8 + j - 1) == 49  ? znak : blank);
            }
            System.out.print("\n");
        }
    }


    static void izpisiNiz64bit(long[] nizZnakov) {
        String[] tabela = new String[nizZnakov.length];
        for (int k = 0; k < nizZnakov.length; k++) {
            tabela[k] = Long.toBinaryString(nizZnakov[k]);
            String zeros = "";
            for (int i = 0; i < 64 - tabela[k].length(); i++)
                zeros += 0;
            tabela[k] = zeros + tabela[k];
        }
        for (int i = 8; i > 0; i--) {
            for (int j = 0; j < nizZnakov.length; j++) {
                for (int k = 8; k > 0; k--) {
                    System.out.print(tabela[j].charAt((i - 1) * 8 + k - 1) == 49 ? znak : blank);
                }
                System.out.print(blank);
            }
            System.out.print("\n");
        }
    }


    public static void izpisiNiz64bit(String nizZnakov){
        nizZnakov = nizZnakov.toUpperCase();
        long[] niz = new long[nizZnakov.length()];
        for (int i = 0; i < nizZnakov.length(); i++){
            if(nizZnakov.charAt(i) >= 65 && nizZnakov.charAt(i) <= 90){
                niz[i] = abeceda64bit[nizZnakov.charAt(i) - 65];
            }
            else if (nizZnakov.charAt(i) > 47 && nizZnakov.charAt(i) < 58)
                niz[i] = abeceda64bit[nizZnakov.charAt(i) - 22];
            else
                niz[i] = abeceda64bit[abeceda64bit.length - 1];
        }
        izpisiNiz64bit(niz);
    }
}

