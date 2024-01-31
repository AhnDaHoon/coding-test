package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class B11724 {

    static boolean result[];

    static ArrayList<Integer>[] A;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer n = Integer.parseInt(st.nextToken());
        Integer m = Integer.parseInt(st.nextToken());

        result = new boolean[n + 1];
        A = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            Integer s = Integer.parseInt(st.nextToken());
            Integer e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(!result[i]){
                count++;
                DFS(i);
            }
        }

        System.out.println(count);

    }

    private static void DFS(int v) {
        if(result[v]){
            return;
        }

        result[v] = true;
        for (Integer i : A[v]) {
            if(!result[i]){
                DFS(i);
            }
        }
    }
}
