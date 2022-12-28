package dev_java.week5.d221228;

class Sup {
    Sup() {
        // m();
    }

    public void m() {
        System.out.println("Sup m()호출");
    }
}

class Sub extends Sup {
    Sub() {
        super.m();
    }

    @Override // 재정의
    public void m() {
        System.out.println("Sub m()호출");
    }
}

public class SupNSubMain {
    public static void main(String[] args) {
        // insert here
        Sup sup = new Sup();
        sup.m();
        System.out.println("=====================");
        Sub sub = new Sub();
        sub.m();
        System.out.println("=======다형성========");

        // 다형성
        // 선언부(Sup) = 생성부(Sub)
        // 부모클래스의 메소드는 shadow메소드(은닉)
        Sup sp = new Sub();
        sp.m();

        System.out.println("=======형변환========");
        // // 아래는 런타임에러 발생
        // // sup의 실제 생성된 객체는 Super타입이다
        // // 따라서 강제 형전환을 하더라도 문법적인 문제는 해결을 했어도
        // // 실제로 가리키는 객체는 상위 객체이므로 에러가 발생
        // sub = (Sub) sup; // sub = new Sup();

        // sp의 타입은 Sup이지만 Sub강제형전환한다
        // sp의 실제 생성된 객체는 Sub타입이다
        // 타입은 달라서 강제 형전환을 해야 하지만 실제 가리키는 객체가 자손 타입이므로
        // 에러가 발생하지 않는다
        sub = (Sub)sp;
        sub.m();
        int i = (int) 23.5d;
        System.out.println(i);
    }
}
