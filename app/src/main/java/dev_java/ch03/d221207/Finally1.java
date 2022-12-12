package dev_java.ch03.d221207;
// java 예외처리
// java finally사용법

public class Finally1 {
    public static void main(String[] args) {
        int i = 10;
        int j = 2;
        j = 0;
        try {
            System.out.println(i/j);
        } catch (ArithmeticException e) {
            // 오류 메시지 출력
            System.out.println(e.getLocalizedMessage());
        } finally {
            System.out.println("finally는 무조건 실행이 된다");
        }
        
        j = 5;
        try {
            System.out.println(i/j);
        } catch (ArithmeticException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            System.out.println("finally는 무조건 실행이 된다");
        }

    }
}
