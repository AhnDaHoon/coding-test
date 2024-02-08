package org.example;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class B1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드 묶음의 수 저장

        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            if(number > 1){
                plusQ.add(number);
            }else if(number == 1){
                one++;
            }else if(number == 0) {
                zero++;
            }else{
                minusQ.add(number);
            }
        }

        while(plusQ.size() > 1){
            Integer first = plusQ.remove();
            Integer second = plusQ.remove();
            sum += first * second;
        }
        if(!plusQ.isEmpty()){
            sum += plusQ.remove();
        }

        while(minusQ.size() > 1){
            Integer first = minusQ.remove();
            Integer second = minusQ.remove();
            sum += first * second;
        }
        if(!minusQ.isEmpty()){
            if (zero == 0){
                sum += minusQ.remove();
            }
        }

        sum += one;

        System.out.println("sum = " + sum);

    }
}