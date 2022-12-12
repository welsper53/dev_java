package dev_java.ch01.d221205;
// 도전문제

// 0부터 9사이의 임의의 수를 채번하고 그 숫자를 맞추는 게임을 구현하시오
// 기회는 단 5번
// 아래 패키지 사용
// java.util.Random
// Random r = new Random();
// 힌트는 낮춰라, 높여라
// 맞으면 축하합니다. 끝

import java.util.Random; // 난수생성 패키지
import java.util.Scanner; // Scanner 패키지

public class Nansu1 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        System.out.println("채번한 숫자 : " + s);
        int com = r.nextInt(10); // 난수 생성
        int my = -1; // 입력값 초기화
        int cnt = 0; // 틀린횟수

        boolean isOk = false;
        while (!isOk) {
            System.out.print("0부터 9사이의 정수를 입력 : ");
            my = s.nextInt(); // 입력 받은 값을 int 타입으로 반환한다.
            System.out.println("사용자가 입력한 값 : " + my);
            if (com == my) { // 맞다
                System.out.println("축하합니다.");
                s.close(); // Scanner 종료
                break;
            } else if (com > my) {
                System.out.println("높여라");
            } else if (com < my) {
                System.out.println("낮춰라");
            } else if (my == 10) {
                System.exit(0); // 터미널 종료, while 문 종료
                s.close(); // Scanner 종료
            }
            cnt++;
            if (cnt == 5) {
                System.out.println("5회 틀렸습니다.\n게임종료");
                break;
            }

        }
    }
}
