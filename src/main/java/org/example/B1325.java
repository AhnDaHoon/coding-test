package org.example;

import java.io.*;
import java.util.*;

public class B1325 {

    static List<Integer>[] A;

    static boolean[] visited;
    static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int maxVal = 0;
        for (int i = 1; i <= N; i++) {
            maxVal = Math.max(maxVal, answer[i]);
        }
        for (int i = 1; i <= N; i++) {
            if(maxVal == answer[i]){
                System.out.print(i + " ");
            }
        }

    }

    private static void BFS(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        while (!q.isEmpty()){
            int nowNode = q.poll();
            for (Integer num : A[nowNode]) {
                if(visited[num] == false){
                    visited[num] = true;
                    q.add(num);
                    answer[num]++;
                }
            }
        }
    }


}