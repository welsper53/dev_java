package dev_java.ch03.d221207;

public class Array1 extends Object {
    // 상속(extends) -> 확장, 재사용(오버라이딩 경우), 재정의해서 쓴다

    public static void main(String[] args) {
        // 선언과 생성을 나누어 할 수 있다.
        // -> 이른 주입인가 아니면 게으른 주입인가
        // 1. 이른 인스턴스화 : 선언부에 선언과 생성을 한번(한문장)에 작성함
        // 2. 게으른 인스턴스화 : 선언과 생성을 분리함
        int i[];
        // int j[3] = new int[3];
        i = new int[3];

        // 초기화 없다. 아직.. = 객체배열 {null, null, null}
        System.out.println(i[0]);

        // 예외처리
        // 예외가 발생할 가능성이 있는 코드를 감싼다.
        // 코드가 정상적으로 동작하는지 확인
        int x = 3;
        try {
            // 문법에러는 Exception과는 상관없다.
            // => 런타임에러
            System.out.println(i[x]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스가 범위를 넘었다");
        }

        // System.out.println(i[3]);
        // System.out.println("여기"); // 바로 윗줄로인해 출력되지 않는다
    }

}
