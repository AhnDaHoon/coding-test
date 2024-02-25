package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class B1850 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        Long result = gcd(A, B);

        while (result > 0){
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();

        bf.close();

    }

    private static Long gcd(Long n, Long m) {
        if(m == 0){
            return n;
        }else {
            return gcd(m, n % m);
        }
    }

}