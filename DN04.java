public class DN04 {
    public static void main(String [] args){
        String niz = "";
        for(int i = 0; i < args[0].length(); i++)
            niz += "a";
        int bsd1 = bsd(args[0]);
        int bsd_searched  = bsd(niz);
        while (bsd1 != bsd_searched && !(niz.startsWith("z") && niz.endsWith("z"))){
            niz = povecaj(niz);
            bsd_searched = bsd(niz);
        }
        System.out.println(niz);
        }


        static String povecaj(String niz) {
            char[] to_ni_potrebno_v_pythonu = new char[niz.length()];
            for(int i = 0; i< niz.length(); i++)
                to_ni_potrebno_v_pythonu[i]  = niz.charAt(i);
            if (Character.toString(to_ni_potrebno_v_pythonu[niz.length() - 1]).equals("z")){
                for (int i = niz.length() - 1; i >= 0; i--) {
                    if(!Character.toString(to_ni_potrebno_v_pythonu[i]).equals("z") ) {
                        to_ni_potrebno_v_pythonu[i] = (char) (to_ni_potrebno_v_pythonu[i] + 1);
                        return String.valueOf(to_ni_potrebno_v_pythonu);
                    }
                    else
                        to_ni_potrebno_v_pythonu[i] = 'a';
                }
            }
            else
                to_ni_potrebno_v_pythonu[niz.length() - 1] =(char)(to_ni_potrebno_v_pythonu[niz.length() - 1] + 1);
            return String.valueOf(to_ni_potrebno_v_pythonu);
        }


        static int bsd(String niz) {
            int checksum = 0;
            for (int i = 0; i < niz.length(); i++) {
                checksum = (checksum >> 1) + ((checksum & 1) << 15);
                checksum += niz.charAt(i);
                checksum &= 0xffff;
            }
            return checksum;
        }
}

