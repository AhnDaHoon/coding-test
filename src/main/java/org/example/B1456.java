package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Long[] ARR = new Long[1000001];

        for (long i = 2; i <= B; i++) {
            ARR[Math.toIntExact(i)] = i;
        }

        for (int i = 2; i <= Math.sqrt(B); i++) {
            if(ARR[i] == 0L){
                continue;
            }
            for (long j = i + i; j <= B; j += i) {
                ARR[Math.toIntExact(j)] = 0L;
            }
        }

        int count = 0;
        for (long i = 2; i <= Math.sqrt(B); i++) {
            if(ARR[Math.toIntExact(i)] != 0L){
                for (long j = i * i; j <= B; j = j*i) {
                    if(j >= A){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}