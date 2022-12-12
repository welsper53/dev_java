package dev_java.pattern;

import java.util.Scanner;

public class HintPart1 {
    // 선언부
    // 채번한 숫자를 담을 1차배열 선언
    int com[] = new int[3];
    // 사용자가 입력한 문자열 쪼개서 담을 1차배열 선언
    int my[] = new int[3];
    // 회차를 담을 변수 선언
    int cnt = 0;

    // 새 게임 버튼을 누르면 3자리의 서로 다른 숫자를 채번한다
    public void ranCom() {
        com[0] = (int) (Math.random() * 10);
        // 채번한 숫자 중 중복 되는게 있는지 확인
        // do-while문 선택
        do {
            com[1] = (int) (Math.random() * 10);
        } while (com[0] == com[1]);
        do {
            com[2] = (int) (Math.random() * 10);
        } while (com[0] == com[2] || com[1] == com[2]);
    }

    // 3자리 숫자를 입력 받아서 힌트문을 작성해주는 메소드 구현
    public String account(String user) {
        // account 메소드 탈출 제어문
        if (user.length() != 3) {
            // 메소드 종료
            return "세자리 숫자만 입력하세요";
        }

        // 파라미터로 넘어온 사용자가 입력한 문자열 값을 정수형으로 변환 담기
        int imsi = 0;
        int strike = 0;
        int ball = 0;

        try {
            imsi = Integer.parseInt(user);
        } catch (NumberFormatException e) {
            return "숫자만 입력하세요";
        }

        // 256/100 = 2.56 -> int/int => 2만 남음
        my[0] = imsi / 100;
        // 256%100 = 56 -> 56/10 = 5.6 --> 5 남음
        my[1] = (imsi % 100) / 10;
        // 256%10 = 6
        my[2] = imsi % 10;

        System.out.println("입력값 : " + my[0] + my[1] + my[2]);

        // 입력 받은 숫자가 com배열에 존재하니?
        // 네 -> 볼 | 아니오 -> 제외
        for (int i = 0; i < com.length; i++) {
            // 만일 위에서 '네' 라면 스트라이크인지 검사
            // com 배열의 i자리와 my 배열의 j자리가 같니?
            for (int j = 0; j < com.length; j++) {
                // 숫자가 있어?
                // 같은 숫자가 있는지만 비교하고 자리가 달라도 참
                if (com[i] == my[j]) {
                    // 볼은 확보 되었다. 자리가 같은지 비교
                    // 숫자의 자리도 같니?
                    // 네 -> 스트라이크 | 아니오 -> 볼
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                } // 입력 받은 숫자가 채번한 숫자와 일치하는 경우
            } // end of inner for문
        } // end of outter for문

        // strike변수값이 3이면 메소드 마지막줄 return은 실행하지 않는다.
        if (strike == 3)
            return "정답입니다";

        return strike + "스" + ball + "볼";
    }

    public static void main(String[] args) {
        HintPart1 hintPart1 = new HintPart1();
        Scanner s = new Scanner(System.in);
        String result;

        // [난수 채번]
        hintPart1.ranCom();
        System.out.println("채번값 : " + hintPart1.com[0] + hintPart1.com[1] + hintPart1.com[2]);

        int cnt = 1;
        while (cnt <= 3) {

            // [사용자 입력]
            System.out.print("(" + cnt + "회차) 숫자를 입력하세요 : ");

            String user = s.nextLine();
            cnt++;

            // [숫자 비교 확인]
            result = hintPart1.account(user);
            System.out.println(result);

            // [새 게임 여부]
            if (cnt == 3 || "정답입니다".equals(result)) {
                System.out.println("게임이 끝났습니다.\n새 게임을 하겠습니까?(Y/N) : ");
                String newGame = s.nextLine();

                try {
                    newGame = newGame.toUpperCase();

                    if ("Y".equals(newGame)) {

                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            } // end of if문 - 새 게임 여부

        } // end of for문 - 회차 돌리기
    }
}
