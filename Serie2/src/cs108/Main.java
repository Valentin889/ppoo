package cs108;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        try {

            int[] b = byteFrequencies("./STAT/file0.bin");
            System.out.println(entropy(b));
            b = byteFrequencies("./STAT/file1.bin");
            System.out.println(entropy(b));
            b = byteFrequencies("./STAT/file2.bin");
            System.out.println(entropy(b));
            b = byteFrequencies("./STAT/file3.bin");
            System.out.println(entropy(b));
            b = byteFrequencies("./STAT/file4.bin");
            System.out.println(entropy(b));
            b = byteFrequencies("./STAT/file5.bin");
            System.out.println(entropy(b));



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

        double somme1 = 0;
        double somme2 = 0;

        for (int i = 0; i < freq.length; i++) {
            somme2 += freq[i];
            somme1 += i*freq[i];
        }

        return somme1/somme2;
    }

    private static double entropy(int[] freq) {

        double H = 0;
        int somme = 0;
        for (int i = 0; i < freq.length; i++) {
            somme += freq[i];
        }
        for (int i = 0; i < freq.length; i++){

            if(freq[i] != 0){
                double p = Double.valueOf(freq[i])/somme;

                H += p * (Math.log(p) / Math.log(2));

            }
        }
        return -H;
    }

}
