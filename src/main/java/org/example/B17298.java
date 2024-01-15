package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> S = new Stack<>();
        int[] A = new int[N];
        int[] B = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            B[i] = num;

            if(i == 0){
                S.add(i);
                continue;
            }

            int peek = B[S.peek()];
            if(peek < num){
                int index = S.pop();
                S.add(i);
                A[index] = num;
            }else if(S.peek() > num){
                A[i] = num;
            }
        }

        while (!S.empty()){
            int index = S.pop();
            A[index] = -1;
        }

        for (int i : A) {
            System.out.println("i = " + i);
        }

        bf.close();

    }
}
