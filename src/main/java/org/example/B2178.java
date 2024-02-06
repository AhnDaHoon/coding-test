package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2178 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] A, visited;

    static int n, m ,y, x, my = 0, mx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                A[i][j] =  Character.getNumericValue(line.charAt(j));
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        visited[my][mx] = 1;
        queue.add(new int[] {my, mx});

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            y = current[0];
            x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m || A[ny][nx] == 0) {
                    continue;
                }
                if(visited[ny][nx] != 0){
                    continue;
                }

                visited[ny][nx] = visited[y][x] + 1;
                queue.add(new int[]{ny, nx});
            }
        }

        System.out.println(visited[n-1][m-1]);
    }


}