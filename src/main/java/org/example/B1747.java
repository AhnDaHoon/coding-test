package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1747 {
    static int number = 0;
    static int[] A = new int[1100000];

    static boolean b = false;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        number = N;
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if(A[i] == 0){
                continue;
            }
            for (int j = i + i; j < A.length; j+=i) {
                A[j] = 0;
            }
        }

        while (!b){
            b = m();
            number++;
        }

    }

    static boolean m(){
        if(A[number] == 0 || number == 0 || number == 1){
            return false;
        }
        String s = A[number]+"";

        int start = 0;
        int end = s.length()-1;
        boolean isSuccess = true;


        while (end >= start){
            char startC = s.charAt(start);
            char endC = s.charAt(end);
            if(startC != endC){
                isSuccess = false;
                break;
            }
            start++;
            end--;

        }
        if(isSuccess){
            System.out.println(s);
        }

        return isSuccess;
    }
}