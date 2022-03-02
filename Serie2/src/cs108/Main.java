package cs108;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        try {
            int[] b = byteFrequencies("./STAT/file0.bin");
            System.out.println(average(b));
            b = byteFrequencies("./STAT/file1.bin");
            System.out.println(average(b));
            b = byteFrequencies("./STAT/file2.bin");
            System.out.println(average(b));
            b = byteFrequencies("./STAT/file3.bin");
            System.out.println(average(b));
            b = byteFrequencies("./STAT/file4.bin");
            System.out.println(average(b));
            b = byteFrequencies("./STAT/file5.bin");
            System.out.println(average(b));


        } catch(IOException e){
            System.out.println("Error");
        }


    }

    private static int[] byteFrequencies(String fileName) throws IOException {

        int[] valReturn = new int[256];
        try (InputStream stream = new FileInputStream(fileName)) {

            int b = 0;
            while ((b = stream.read()) != -1) {
                valReturn[b]++;
            }
        }

        return valReturn;
    }

    private static double average(int[] freq) {

        double somme = 0;

        for (int i = 0; i < freq.length; i++) {
            somme += i*freq[i];
        }

        return somme/freq.length;
    }


}
