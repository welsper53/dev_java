package dev_java.ch01.d221205;

import java.util.Scanner;

public class Quiz21 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("구하고자 하는 합의 두번째 숫자를 입력하세요");
        int user_end = s.nextInt();
        int tot = 0;
        int cnt;
        cnt = 1;

        for (; cnt <= user_end; cnt++) {
            // 짝수들의 합
            if (cnt % 2 == 1) {
                tot = tot + cnt;
            }
        }
        System.out.printf("tot: %d, cnt : %d %n", tot, cnt);
        s.close();
    }
}
