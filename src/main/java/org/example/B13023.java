package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B13023 {

    static boolean[] visited;

    static ArrayList<Integer>[] A;

    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        A = new ArrayList[n];
        arrive = false;

        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                DFS(i, 1);
            }
        }

        if (arrive){
            System.out.println("1");
        }else{
            System.out.println("0");
        }


    }

    private static void DFS(int v, int depth) {
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }
        visited[v] = true;
        for (Integer i : A[v]) {
            if(!visited[i]){
                DFS(i, depth + 1);
            }
        }
        visited[v] = false;
    }


}
