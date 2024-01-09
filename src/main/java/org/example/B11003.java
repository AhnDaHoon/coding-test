package org.example;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        LinkedList<Node> arr = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!arr.isEmpty() && arr.getLast().value > now){
                arr.removeLast();
            }

            arr.addLast(new Node(i, now));

            if(arr.getFirst().idx <= i - L){
                arr.removeFirst();
            }

            bw.write(arr.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        private int idx;
        private int value;

        Node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }

}
