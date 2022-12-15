// 연습문제1
// 키보드로 부터 5개의 정수를 입력 받아서 배열에 저장하세요.
// 그리고 이들의 합계와 평균을 출력하는 프로그램을 작성하시오.


package dev_java.weak3.d221215;

import java.util.Scanner;

public class HWork1 {
    int users[] = new int[5];    // 0, 0, 0, 0, 0

    int total() {
        int hap = 0;
        for(int i=0; i<users.length; i++) {
            hap += users[i];
        }
        return hap;
    }
    void average(int hap) {
        double avg = 0;
        avg = hap / (double)users.length;
        System.out.println("평균은 " +  avg + "입니다.");
    }

    void initUsers() {
        Scanner s = new Scanner(System.in);

        for (int i=0; i<users.length; i++) {
            System.out.print("정수를 입력하세요 : ");
            users[i] = s.nextInt();
        }
    }

    public static void main(String[] args) {
        HWork1 hw1 = new HWork1();

        hw1.initUsers();
        int hap = hw1.total();
        hw1.average(hap);
    }
}
