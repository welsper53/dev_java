// 연습문제2
// -10에서 10사이의 정수 10개를 랜덤하게 채번하여 
// 음수와 양수의 합계를 구하는 프로그램을 작성하시오.
// 출력)
//    배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
//    음수합 : -24
//    양수합 : 17

package dev_java.weak3.d221215;

import java.util.Random;

public class HWork2 {

    public static void main(String[] args) {
        Random r = new Random();

        for (int j = 0; j < 10; j++) {
            int i = r.nextInt(20) - 9;
            System.out.print(i + " ");
        }

        System.out.println("======================\n\n");

        int users[] = new int[10];
        for (int i = 0; i < users.length; i++) {
            users[i] = (int) (Math.random() * 20) % 21 - 10;
            System.out.print(users[i] + " ");
        }
        System.out.println("======================\n\n");
        int i = (int) (Math.random());
        System.out.println((Math.random()*10));
    }
}
