package org.example;

import java.io.IOException;
import java.util.Scanner;

public class B2018 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (end != N) {
            if (sum > N) {
                sum -= start;
                start++;
            }else if(sum < N){
                end++;
                sum += end;
            }else {
                end++;
                count++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}
