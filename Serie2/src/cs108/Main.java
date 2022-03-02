package cs108;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        try {
            int[] b = byteFrequencies("./STAT/file0.bin");
            System.out.println(Arrays.toString(b));
        } catch(IOException e){
            System.out.println("Error");
        }
    }

    private static int[] byteFrequencies(String fileName) throws IOException {

        InputStream stream = new FileInputStream(fileName);

        int[] valReturn = new int[256];

        int b = 0;
        while((b = stream.read()) != -1){
            valReturn[b]++ ;
        }

        stream.close();

        return valReturn;
    }
}
