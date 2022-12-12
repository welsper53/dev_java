package dev_java.nansuGame;

import java.util.Scanner;

public class Nansu1_2 {
    int com = -1;
    //// 사용자입력 변수 주석 처리
    // int user = -1;

    // [난수 생성]
    public void ranCom() {
        // 10을 곱하는 이유는 구간을 늘리기 위함
        com = (int) (Math.random() * 10);
    }

    // [숫자 비교]
    // user변수 때문에 변수 my를 삭제하였다.
    // 1) 사용자가 입력한 값을 지역변수에 담아야하는 이유를 설명하시오
    // ==> 사용자가 입력한 값이 난수와 같이 않을 경우
    // 계속 user변수 값을 수정해야할 필요가 있어서
    // 2) com 변수는 왜 전역변수해야 하는지 설명하시오
    // ==> com변수(난수)는 정답이 될 때까지 변경되면 안되기 때문
    public String 판정하기(int user) {
        String msg = null;
        // 정답보다 입력한 값이 작니?
        if (com > user) {
            msg = "높여라";
        }
        // 정답보다 입력한 값이 크니?
        else if (com < user) {
            msg = "낮춰라";
        } else if (com == user) {
            msg = "정답";
            //// "if문에서 해당 메소드를 탈출할 때", return예약어 사용가능함
            //// 반복문에서는 break문 사용한다
            // return msg;
        }
        // return null;
        return msg;
    }

    public static void main(String[] args) {
        // [실행하자 마자 채번하도록 코딩하시오.]
        // -> 생성자 활용
        // 생성자 역활 : 전역변수 초기화, 부모클래스 초기화 포함(상속)
        Nansu1_2 nansu = new Nansu1_2();

        // [채번한 숫자를 출력하시오.]
        // 채번한 값을 초기화하는 메소드 호출
        // 새 게임을 누르면 - 재사용성(메소드), 정답을 봤니?
        nansu.ranCom();
        // nansu.com : 전역변수 -> 인스턴스변수, 값 유지
        System.out.println("채번한 값 : " + nansu.com);

        // [Scanner를 활용하여 사용자가 입력한 값을 받으시오.]
        // 매번 새로 받아와한다 -> 반복문 안에 올것
        Scanner scanner = new Scanner(System.in);
        String 입력값 = null;
        String 반환값 = null;

        // [게임 기회는 5회로 제한하시오.]
        // i변수 : 지역변수, 회차 표시
        int i = 0;
        
        // 반복문, 무한루프 방지코드를 작성할 것 -> break;
        while (i < 5) {
            System.out.print("숫자를 입력하세요(0~9) : ");
            // 사용자가 입력한 값 받아오기
            // nextLine() : 반환값이 있다
            입력값 = scanner.nextLine();

            // 입력값이 null인지 확인
            // 알면서도 잡지 못하는 Exception
            // null : NumberFormatException
            System.out.println("입력한 값 : " + 입력값);
            int userNum = Integer.parseInt(입력값);

            // [정답을 맞추었을 경우 축하합니다. 라고 말한 뒤]
            // [새 게임 진행 여부를 물어보시오.]
            반환값 = nansu.판정하기(userNum);
            if ("정답".equals(반환값)) {
                System.out.println("축하합니다");
                break;
            }
            // 증감연산자
            i++;
            
            // [시도 할 때마다 몇번째 기회를 사용하는지 출력하시오.]
            System.out.println(userNum + " : " + 반환값);
            System.out.println(i + "회차");
        }// end of while
        // Stream, I/O, Network 사용 후 반드시 닫는다.
        scanner.close();
    }

}
