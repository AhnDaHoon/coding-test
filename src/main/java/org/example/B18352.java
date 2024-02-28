package org.example;

import java.util.*;

public class B18352 {
    static int visited[];
    static ArrayList<Integer>[] A;
    static int N,M,K,X;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int X = scanner.nextInt();

        A = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();

            A[s].add(e);
        }

        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        BFS(X);

        for (int i = 1; i <= N; i++) {
            if(visited[i] == K){
                answer.add(i);
            }
        }

        if(answer.isEmpty()){
            System.out.println("-1");
        }else{
            Collections.sort(answer);
            for (Integer i : answer) {
                System.out.println(i);
            }
        }
    }

    private static void BFS(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x]++;

        while (!q.isEmpty()){
            int nowNode = q.poll();
            for (Integer i : A[nowNode]) {
                if(visited[i] == -1){
                    visited[i] = visited[nowNode] + 1;
                    q.add(i);
                }
            }
        }
    }


}