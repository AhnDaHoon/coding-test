package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260 {
    static boolean[] DFSVisited;
    static boolean[] BFSVisited;
    static Queue<Integer> q = new LinkedList();

    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        DFSVisited = new boolean[n+1];
        BFSVisited = new boolean[n+1];

        A = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i < n+1; i++) {
            Collections.sort(A[i]);
        }

        DFS(v);

        System.out.println();

        BFS(v);
    }


    private static void DFS(int v) {
        DFSVisited[v] = true;
        System.out.print(v + " ");
        for (Integer i : A[v]) {
            if(!DFSVisited[i]){
                DFS(i);
            }
        }
    }

    private static void BFS(int v) {
        BFSVisited[v] = true;
        System.out.print(v + " ");

        for (Integer i : A[v]) {
            if(!BFSVisited[i]){
                q.add(i);
                BFSVisited[i] = true;
            }
        }

        if(q.isEmpty()){
            return;
        }
        Integer poll = q.poll();
        BFS(poll);
    }
}