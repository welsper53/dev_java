package dev_java.ch02.d221206;

public class DoWhile {
    public static void main(String[] args) {
        int i = 1;

        // 조건을 수렴하지 않으면 단 한번도 실행 기회가 없다
        while(i>3) {    // false; 조건문을 먼저 실행
            System.out.println("while 실행문 출력됨");
        }
        System.out.println("요기");

        // 굳이 i 값을 1로 초기화한 것은 동일한 조건에서 테스트하기 위함
        i=1;
        do {        // {}안 코드 먼저 실행 후, 조건문 실행
            System.out.println("do-while 실행문 출력됨");
        } while(i>3);
    }
}
