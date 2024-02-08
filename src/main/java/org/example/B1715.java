package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(Integer.parseInt(st.nextToken()));
        }

        int count = 0;

        while (q.size() > 1){
            Integer poll1 = q.poll();
            Integer poll2 = q.poll();

            count += poll1+poll2;

            q.add(poll1+poll2);
        }
        System.out.println(count);

    }
}
