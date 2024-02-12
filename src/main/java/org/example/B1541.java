package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1541 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        String[] str = N.split("-");

        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);

            if(i == 0){
                answer += temp;
            }else {
                answer -= temp;
            }
        }
        System.out.println(answer);
    }

    static int mySum(String a){
        int sum = 0;

        String temp[] = a.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }
}