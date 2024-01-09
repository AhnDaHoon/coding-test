package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891 {
    static int checkArr[] = new int[4];
    static int myArr[] = new int[4];
    static int checkSecret = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int count = 0;

        char A[] = new char[S];
        A = bf.readLine().toCharArray();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0){
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) {
            add(A[i]);
        }

        if(checkSecret == 4){
            count++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            add(A[i]);
            remove(A[j]);
            if(checkSecret == 4){
                count++;
            }
        }

        System.out.println(count);
    }

    public static void add(char c){
        switch (c){
            case 'A' -> {
                myArr[0]++;
                if(myArr[0] == checkArr[0]){
                    checkSecret++;
                }
            }
            case 'C' -> {
                myArr[1]++;
                if(myArr[1] == checkArr[1]){
                    checkSecret++;
                }
            }
            case 'G' -> {
                myArr[2]++;
                if(myArr[2] == checkArr[2]){
                    checkSecret++;
                }
            }
            case 'T' -> {
                myArr[3]++;
                if(myArr[3] == checkArr[3]){
                    checkSecret++;
                }
            }
        }
    }

    public static void remove(char c){
        switch (c){
            case 'A' -> {
                if(myArr[0] == checkArr[0]){
                    checkSecret--;
                }
                myArr[0]--;
            }
            case 'C' -> {
                if(myArr[1] == checkArr[1]){
                    checkSecret--;
                }
                myArr[1]--;
            }
            case 'G' -> {
                if(myArr[2] == checkArr[2]){
                    checkSecret--;
                }
                myArr[2]--;
            }
            case 'T' -> {
                if(myArr[3] == checkArr[3]){
                    checkSecret--;
                }
                myArr[3]--;
            }
        }
    }

}
