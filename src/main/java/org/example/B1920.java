package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] nA = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nA[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nA);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boolean find = false;
            int number = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = nA.length-1;
            while (start <= end){
                int midi = (start + end) / 2;
                int midV = nA[midi];

                if(midV > number){
                    end = midi - 1;
                }else if(midV < number){
                    start = midi + 1;
                }else {
                    find = true;
                    break;
                }

            }
            if(find){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }
}