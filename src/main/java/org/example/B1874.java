package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> S = new Stack<>();
        int[] A = new int[N];
        StringBuffer sbf = new StringBuffer();
        boolean result = true;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }

        int num = 1;
        for (int i = 0; i < N; i++) {
            int su = A[i];
            if(su >= num){
                while (su >= num){
                    S.add(num++);
                    sbf.append("+\n");
                }
                S.pop();
                sbf.append("-\n");
            }else if(su < num){
                int pop = S.pop();
                sbf.append("-\n");
                if(pop > su){
                    System.out.println("NO");
                    result = false;
                    break;
                }
            }
        }

        if(result){
            System.out.println(sbf.toString());

        }

    }
}
