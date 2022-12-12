package dev_java.nansuGame;
// 0~9사이 숫자 맞추기 게임

// 입력받는 값은 0~9 사이의 숫자여야 한다.
// 답을 맞추면 새게임 시작이 가능하다 - 초기화 실전연습
// 답을 맞추지 못했을 경우 답을 볼 수 있도록 한다.

import java.util.Scanner;

public class NansuMaker {
    // 선언부
    // 만일 여기서 채번한 값을 다른 클래스에서 재사용해야 한다면
    // 그런 상황이면 나는 멤버변수(member*global variable)로 결정한다.

    int com[] = new int[3];
    int my[] = new int[3]; // 사용자가 선택한 숫자

    // 난수 발생하여 3자리의 서로 다른 숫자로된 값을 배열에 담기
    public void ranCom() {
        // Math.random(10) = 0.0 < n < 10.0
        // return type = static double
        com[0] = (int) (Math.random() * 10);

        do {
            com[1] = (int) (Math.random() * 10);
        } while (com[0] == com[1]);
        do {
            com[2] = (int) (Math.random() * 10);
        } while (com[0] == com[2] || com[1] == com[2]);
    }

    // 사용자가 선택한 숫자
    public void myCom() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("3자리 숫자를 입력해주세요(공백구분) : ");

        for (int n = 0; n < 3; n++) {
            my[n] = scanner.nextInt();
        }
        scanner.close();
    }

    // 입력값과 난수값 비교
    public boolean matchNum() {
        int n = 0;
        int m = 0;
        int ball = 0;
        int strike = 0;
        boolean result = false;

        while (n < 3) {
            while (m < 3) {
                // 입력값과 난수값이 같은지 확인
                if (my[n] == com[m]) {
                    // 값이 같을 때, 같은 자리인지 확인
                    if (n == m) {
                        strike += 1;
                    } else {
                        ball += 1;
                    }
                }
                m++;
            }
            n++;
            m = 0;
        }
        System.out.println("Ball = " + ball + ", strike = " + strike);

        if (strike == 3) {
            System.out.println("out");
            result = true;
        }

        return result;
    }

    ///////////////////////////////////////////////
    // 초기화, 전역변수 ? 지역변수
    // 자리가 같다는 것을 배열의 index를 활요하시오
    public String account(String user_input) {
        return "1스 2볼";
    }
    ////////////////////////////////////////////////

    // 메인메소드
    public static void main(String[] args) {
        NansuMaker nansuMaker = new NansuMaker();

        nansuMaker.ranCom();
        System.out.println("\n정답 : " + nansuMaker.com[0] + " " + nansuMaker.com[1] + " " + nansuMaker.com[2]);

        boolean result = false;

        while (!result) {
            nansuMaker.myCom();
            result = nansuMaker.matchNum();
        }
    }
}
