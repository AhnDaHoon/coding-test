package org.example;

import java.io.IOException;
import java.util.Scanner;

public class B10986 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 합배열
        long[] S = new long[N];

        // 나머지 배열
        long[] C = new long[M];
        long answer = 0;
        S[0] = sc.nextInt();

        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int remainder = (int)(S[i] % M);
            if(remainder == 0){
                answer++;
            }
            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if(C[i] > 1){
                answer = answer + (C[i] * (C[i] - 1) / 2); // 콤비네이션 공식 적용
            }
        }

        System.out.println(answer);
    }
}
