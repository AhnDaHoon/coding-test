package org.example;

import java.io.IOException;
import java.util.Scanner;

public class B최대_공약수 {
    static boolean b = true;

    public static void main(String[] args) throws IOException {
        int N = 270;
        int M = 192;

        A(N, M);
    }

    private static void A(int n, int m) {
        while(b){
            int num1 = m;
            int num2 = n % m;
            if(num2 == 0){
                b = false;
                System.out.println(num1);
            }else {
                A(num1, num2);
            }
        }
    }

}