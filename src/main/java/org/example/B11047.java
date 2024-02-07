package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            int Ai = A[i];
            if(Ai <= K){
                while (Ai <= K){
                    K -= Ai;
                    count++;
                }
            }else if(Ai > K){
                continue;
            }
        }

        System.out.println(count);
    }
}
