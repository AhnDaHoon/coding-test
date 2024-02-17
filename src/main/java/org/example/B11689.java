package org.example;

import java.io.IOException;
import java.util.Scanner;

public class B11689 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long result = N;

        for(long p = 2; p <= Math.sqrt(N); p++){
            if(N % p == 0){
                result = result - result / p;
                while (N % p == 0){
                    N /= p;
                }
            }
        }
        if(N > 1){
            result = result - result / N;
        }

        System.out.println(result);

    }

}